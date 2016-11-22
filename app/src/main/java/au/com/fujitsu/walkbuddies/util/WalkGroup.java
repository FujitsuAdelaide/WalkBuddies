package au.com.fujitsu.walkbuddies.util;

/**
 * Created by kamran on 20/11/16.
 */

public class WalkGroup {

    long   groupID;
    String groupName;
    String suburb;
    String school;
    String dropzoneAddress;
    String morningTime;


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

    public String getMorningTime() {
        return morningTime;
    }

    public void setMorningTime(String morningTime) {
        this.morningTime = morningTime;
    }

    public WalkGroup(String groupName, String suburb, String school, String dropzonAddress, String morningTime) {
        this.groupName = groupName;
        this.suburb = suburb;
        this.school = school;
        this.dropzoneAddress = dropzonAddress;
        this.morningTime = morningTime;
    }



}
