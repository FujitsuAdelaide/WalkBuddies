package au.com.fujitsu.walkbuddies.util;

import java.util.ArrayList;
import android.content.ClipData.Item;

/**
 * Created by kamran on 20/11/16.
 */

public class WalkGroup extends Item {

    long   groupID;
    String groupName;
    String suburb;
    String school;
    String dropzoneAddress;
    String morningTime;
    private Parent groupAdmin;
    private ArrayList<Parent> parentList;
    private ArrayList<Child> childList;

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDropzoneAddress() {
        return dropzoneAddress;
    }

    public void setDropzoneAddress(String dropzoneAddress) {
        this.dropzoneAddress = dropzoneAddress;
    }

    public Parent getGroupAdmin()
    {
        return this.groupAdmin;
    }

    public void setGroupAdmin(Parent groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public ArrayList<Child> getChildList() {
        return this.childList;
    }

    public void setChildList(ArrayList<Child> childList) {
        this.childList = childList;
    }

    public ArrayList<Parent> getParentList(){
        return this.parentList;
    }

    public void setParentList(ArrayList<Parent> parentList) {
        this.parentList = parentList;
    }

    public String getMorningTime() {
        return morningTime;
    }

    public void setMorningTime(String morningTime) {
        this.morningTime = morningTime;
    }

    public WalkGroup(String groupName, String suburb, String school, String dropzonAddress, String morningTime) {
        super(groupName);
        this.groupName = groupName;
        this.suburb = suburb;
        this.school = school;
        this.dropzoneAddress = dropzonAddress;
        this.morningTime = morningTime;
    }

    @Override
    public String toString() {
        return this.groupName + " - " + this.school;
    }
}
