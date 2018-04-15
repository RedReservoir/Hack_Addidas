package ub.edu.pis2017.pis_17.synergy.View.main;

import android.graphics.drawable.Drawable;

/**
 * Created by gerar on 26/03/2018.
 */

public class MainActivityListItemP {

    private String title;
    private String location;
    private String admin;
    private int distance;
    private int numParticipants;
    private int numVacants;
    private Drawable profilePic;

    public MainActivityListItemP(String location, String title, String admin, int distance, int numParticipants, int numVacants, Drawable profilePic) {
        this.location = location;
        this.title = title;
        this.admin = admin;
        this.distance = distance;
        this.numParticipants = numParticipants;
        this.numVacants = numVacants;
        this.profilePic = profilePic;
    }

    //Getters and Setters
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}
    public String getAdmin() {return admin;}
    public void setAdmin(String admin) {this.admin = admin;}
    public int getDistance() {return distance;}
    public void setDistance(int distance) {this.distance = distance;}
    public int getNumParticipants() {return numParticipants;}
    public void setNumParticipants(int numParticipants) {this.numParticipants = numParticipants;}
    public int getNumVacants() {return numVacants;}
    public void setNumVacants(int numVacants) {this.numVacants = numVacants;}
    public Drawable getProfilePic() {return profilePic;}
    public void setProfilePic(Drawable profilePic) {this.profilePic = profilePic;}

}
