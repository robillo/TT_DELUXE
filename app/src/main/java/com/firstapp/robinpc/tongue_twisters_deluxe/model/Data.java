package com.firstapp.robinpc.tongue_twisters_deluxe.model;

public class Data {

    public String Title;
    public String subTitle;
    public String TT;

    public Data(String Title, String subTitle, String TT){
        this.Title = Title;
        this.subTitle = subTitle;
        this.TT = TT;
    }


    //getters and setters

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTT() {
        return TT;
    }

    public void setTT(String TT) {
        this.TT = TT;
    }
}
