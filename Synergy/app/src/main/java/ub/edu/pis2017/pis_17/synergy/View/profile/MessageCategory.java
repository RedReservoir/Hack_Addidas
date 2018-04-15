package ub.edu.pis2017.pis_17.synergy.View.profile;

/**
 * Created by manuellechasanchez on 26/03/2018.
 */


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.TextView;


public class MessageCategory {

    private String userName;
    private String message;
    private String lblName;
    private String messageCategoryId;
    private Drawable userImage;
    private Drawable lblDraw;

    public MessageCategory(String userName,String message, Drawable userImage, int lblType, Drawable lblDraw){
        this.userName = userName;
        this.message = message;
        this.userImage = userImage;
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

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName =  userName;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message =  message;
    }

    public String getLblName(){ return this.lblName; }

    public void setLblName(String lblName){
        this.lblName = lblName;
    }

    public Drawable getUserImage(){
        return userImage;
    }

    public void setUserImage(Drawable userImage){
        this.userImage = userImage;
    }

    public String getCategoryId(){return messageCategoryId;}

    public void setCategoryId(String categoryId){this.messageCategoryId = categoryId;}

    public void setLblDraw(Drawable lblDraw){this.lblDraw = lblDraw;}

    public Drawable getLblDraw(){return this.lblDraw;}


}
