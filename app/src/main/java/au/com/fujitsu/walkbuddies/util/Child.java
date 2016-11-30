package au.com.fujitsu.walkbuddies.util;

/**
 * Created by kamran on 19/11/16.
 */

public class Child {

    long   childID;
    String childName;
    String childAge;
    String childSchool;
    String childCharacter;
    Parent parent;

    public Child(String childName, String childAge, String childSchool, String childCharacter, Parent parent) {
        this.childName = childName;
        this.childAge = childAge;
        this.childSchool = childSchool;
        this.childCharacter = childCharacter;
        this.parent = parent;
    }

    public  Child(){

    }

    public long getChildID() {
        return childID;
    }

    public void setChildID(long childID) {
        this.childID = childID;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildAge() {
        return childAge;
    }

    public void setChildAge(String childAge) {
        this.childAge = childAge;
    }

    public String getChildSchool() {
        return childSchool;
    }

    public void setChildSchool(String childSchool) {
        this.childSchool = childSchool;
    }

    public String getChildCharacter() {
        return childCharacter;
    }

    public void setChildCharacter(String childCharacter) {
        this.childCharacter = childCharacter;
    }

    public Parent getParentID() {
        return parent;
    }

    public void setParentID(Parent parentID) {
        this.parent = parent;
    }


}
