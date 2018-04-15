package ub.edu.pis2017.pis_17.synergy.View.post;

import android.graphics.drawable.Drawable;

/**
 * Created by gerar on 26/03/2018.
 */

public class ProjectActivityListItem {

    private String username;
    private String positionName;
    private int state;
        // 0 Admin
        // 1 Not vacant
        // 2 Vacant
    private Drawable profilePic;

    public ProjectActivityListItem(String username, String positionName, int state, Drawable profilePic) {
        this.username = username;
        this.positionName = positionName;
        this.state = state;
        this.profilePic = profilePic;
    }

    //Getters and Setters
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPositionName() {return positionName;}
    public void setPositionName(String positionName) {this.positionName = positionName;}
    public int getState() {return state;}
    public void setState(int state) {this.state = state;}
    public Drawable getProfilePic() {return profilePic;}
    public void setProfilePic(Drawable profilePic) {this.profilePic = profilePic;}

}
