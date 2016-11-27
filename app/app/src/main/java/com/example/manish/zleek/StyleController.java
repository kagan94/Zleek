package com.example.manish.zleek;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */


public class StyleController {

    private String styletype; // formal,fashion blabl
    private String color;
    private String selected_garment;
    private String  clothname;// jacket

    public StyleController(String selected_garment){
        styletype="";
        color="";
        selected_garment=selected_garment;
        clothname="";
    }

    public String getstyletype() {
        return styletype;
    }

    public void setstyletype(String styletype) {
        this.styletype = styletype;
    }

    public String clothname() {
        return clothname;
    }

    public void setclothname(String clothname) {
        this.clothname = clothname;
    }

    public String getSelectedGarment() {
        return selected_garment;
    }

    public void setSelectedGarment(String garment) {
        this.selected_garment = garment;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String brand) {
        this.color = color;
    }
}

