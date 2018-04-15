package ub.edu.pis2017.pis_17.synergy.View.main;

import android.graphics.drawable.Drawable;

/**
 * Created by gerar on 26/03/2018.
 */

public class MainActivityListItemOR {

    private String title;
    private String location;
    private int distance;
    private Drawable profilePic;

    public MainActivityListItemOR(String location, String title, int distance, Drawable profilePic) {
        this.location = location;
        this.title = title;
        this.distance = distance;
        this.profilePic = profilePic;
    }

    //Getters and Setters
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}
    public int getDistance() {return distance;}
    public void setDistance(int distance) {this.distance = distance;}
    public Drawable getProfilePic() {return profilePic;}
    public void setProfilePic(Drawable profilePic) {this.profilePic = profilePic;}

}
