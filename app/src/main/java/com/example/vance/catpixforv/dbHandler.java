package com.example.vance.catpixforv;

/**
 * Created by Vance on 11/29/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class dbHandler extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "Kat.db";
    private static final int DATABASE_VERSION = 1;

    public dbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);

    }
    private static String TABLE_NAME="KATS";

    private static String COLUMN_ID="_id";



    public int tableCount(){

        int count=0;
        String countq = "SELECT COUNT(*) FROM "+TABLE_NAME+"";

        SQLiteDatabase cdb = this.getReadableDatabase();

        Cursor countcursor = cdb.rawQuery(countq, null);
        if(countcursor.moveToFirst())
        {

            count=Integer.parseInt(countcursor.getString(0));

        }
        else
        {
            count=1;
        }
        countcursor.close();
        return count;
    }



    public Kat findKat(int ID){
        Kat returnKat=new Kat();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = \"" + ID + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            cursor.moveToFirst();
            returnKat.setId(ID);
            returnKat.setId(cursor.getInt(0));
            returnKat.setURL(cursor.getString(1));
            returnKat.setUsed(cursor.getString(2));

        }
        else
        {

        }

        cursor.close();
        db.close();
        return returnKat;

    }


    public void updateKat(Kat r){

        ContentValues values= new ContentValues();
        values.put("URL", r.getURL());
        values.put("USED", String.valueOf(r.getUsed()));

        SQLiteDatabase db = this.getWritableDatabase();

        db.update(TABLE_NAME, values, COLUMN_ID + " = " + r.getId(), null);
        db.close();

    }




}
