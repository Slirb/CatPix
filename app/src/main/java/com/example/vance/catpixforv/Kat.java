package com.example.vance.catpixforv;

/**
 * Created by Vance on 5/22/2017.
 */

public class Kat {
    private int id;
    private String URL;
    private String Used;
    //Constructors



    //Get Data
    public int getId(){
        return id;
    }

    public String getURL(){
        return URL;
    }

    public String getUsed(){
        return Used;
    }


    //Set Data
    public void setId(int id){
        this.id=id;
    }

    public void setURL(String url){
        this.URL=url;
    }

    public void setUsed(String use){
        this.Used=use;
    }

}
