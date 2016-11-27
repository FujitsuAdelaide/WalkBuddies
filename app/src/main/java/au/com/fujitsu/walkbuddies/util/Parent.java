package au.com.fujitsu.walkbuddies.util;

import java.util.ArrayList;

/**
 * Created by kamran on 21/11/16.
 */

public class Parent {

    long   parentID;
    String parentName;
    String parentMobile;
    String parentEmail;
    String parentAddress;
    private ArrayList<Child> childList;

    public Parent(String parentName, String parentMobile, String parentEmail) {

        this.parentName = parentName;
        this.parentMobile = parentMobile;
        this.parentEmail = parentEmail;

    }

    public Parent(){
      //  this.parentID = parent
    }


    public String getParentAddress() {
        return parentAddress;
    }

    public void setParentAddress(String parentAddress) {
        this.parentAddress = parentAddress;
    }
    public long getParentID() {
        return parentID;
    }

    public void setParentID(long parentID) {
        this.parentID = parentID;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentMobile() {
        return parentMobile;
    }

    public void setParentMobile(String parentMobile) {
        this.parentMobile = parentMobile;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public ArrayList<Child> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<Child> childList) {
        this.childList = childList;
    }
}
