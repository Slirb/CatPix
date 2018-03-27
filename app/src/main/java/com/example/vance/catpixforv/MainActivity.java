package com.example.vance.catpixforv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private dbHandler db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new dbHandler(this);
        }
    public void sendClick(View view){
        //Insert the recipients number after the +
        String Name="+";
        String Message=" ";
        Kat kat;
        int flag=0;
        do{
            int ran=1+((int)(Math.random()*100)% 3109+1);
            kat=db.findKat(ran);

            if(kat.getUsed().equals("0"))
            {
                Message = kat.getURL().toString();
                kat.setUsed("1");
                db.updateKat(kat);
                flag=1;
                //Deez Nuts are for John
            }
        }while(flag !=1);

        SmsManager TestMsg=SmsManager.getDefault();
        try
        {
            TestMsg.sendTextMessage(Name, null, Message, null, null);
        }
        catch(Exception e)
        {

        }
        db.close();
        finish();

    }



}
