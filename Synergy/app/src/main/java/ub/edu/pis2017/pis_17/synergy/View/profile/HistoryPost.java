package ub.edu.pis2017.pis_17.synergy.View.profile;

import android.graphics.drawable.Drawable;

/**
 * Created by kanales on 26/03/2018.
 */
public class HistoryPost {
    private String title;
    private Drawable image;
    private String location;
    private String desc;
    private Drawable lblDraw;
    private String lblName;

    public HistoryPost(String title, Drawable image, String desc, String location, int lblType, Drawable lblDraw) {
        this.title = title;
        this.image = image;
        this.location = location;
        this.desc = desc;
        this.lblDraw = lblDraw;

        switch(lblType){

            case 0:
                lblName = "Offer";
                break;
            case 1:
                lblName = "Request";
                break;
            case 2:
                lblName = "Project";
                break;
            default:
                break;
        }
    }

    public String getTitle() {
        return title;
    }

    public Drawable getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    public String getDesc() {
        return desc;
    }

    public String getLblName(){return lblName;}

    public Drawable getLblDraw(){return lblDraw;}
}
