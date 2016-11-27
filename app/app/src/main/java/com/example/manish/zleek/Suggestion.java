package com.example.manish.zleek;

/**
 * Created by manish on 11/27/2016.
 */

public class Suggestion {

    private StyleController jacket ; // formal,fashion blabl
    private StyleController pants;
    private StyleController shoes;
    private StyleController assecoires;

    public StyleController getJacket() {
        return jacket;
    }

    public void setJacket(StyleController jacket) {
        this.jacket = jacket;
    }

    public StyleController getPants() {
        return pants;
    }

    public void setPants(StyleController pants) {
        this.pants = pants;
    }

    public StyleController getShoes() {
        return shoes;
    }

    public void setShoes(StyleController shoes) {
        this.shoes = shoes;
    }

    public StyleController getAssecoires() {
        return assecoires;
    }

    public void setAssecoires(StyleController assecoires) {
        this.assecoires = assecoires;
    }
}
