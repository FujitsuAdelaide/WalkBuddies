package au.com.fujitsu.walkbuddies.util;

import java.util.ArrayList;

/**
 * Created by kamran on 19/11/16.
 */

public class DataProvider {
    ArrayList<Child> myKids;
    ArrayList<ChildGroup> myKidGroups;
    ArrayList<Parent> parents;
    ArrayList<Child> childs;
    Parent loggedInParent;

    public Parent getLoggedInParent() {
        return loggedInParent;
    }

    public void setLoggedInParent(Parent loggedInParent) {
        this.loggedInParent = loggedInParent;
    }

    public ArrayList<Child> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<Child> childs) {
        this.childs = childs;
    }

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }
    
    public ArrayList<Child> getMyKids() {
        return myKids;
    }

    public void setMyKids(ArrayList<Child> myKids) {
        this.myKids = myKids;
    }

    public ArrayList<ChildGroup> getMyKidGroups() {
        return myKidGroups;
    }

    public void setMyKidGroups(ArrayList<ChildGroup> myKidGroups) {
        this.myKidGroups = myKidGroups;
    }

    protected DataProvider(){
        myKids = new ArrayList();
        myKidGroups = new ArrayList();
        parents = new ArrayList();
        childs = new ArrayList();
        createSchoolList();
    }


    public void addMyKids(Child kid){

        myKids.add(kid);
    }

    public void addChild(Child kid){

        childs.add(kid);
    }

    public void addParent(Parent parent){

        parents.add(parent);
    }

    public void addDummyData(){

        Parent parent1 = new Parent("Iftikhar","0434214119","kamran.iftikhar@gmail.com");
        parent1.setParentID(getMaxParentID()+1);
        parents.add(parent1);
        Parent parent2 = new Parent("Sawhney","0431211212","amit.sawhney@au.fujitsu.com");
        parent2.setParentID(getMaxParentID()+1);
        parents.add(parent2);
        Parent parent3 = new Parent("Sidhu","0431234567","bobby.sidhu@au.fujitsu.com");
        parent3.setParentID(getMaxParentID()+1);
        parents.add(parent3);

        Child kid1 = new Child("Amit","6","Mawson lakes public school","Superman",parent2);
        kid1.setChildID(getMaxChildID()+1);
        addChild(kid1);
        Child kid2 = new Child("Bobby","6","Mawson lakes public school","Superman",parent3);
        kid2.setChildID(getMaxChildID()+1);
        addChild(kid2);
        Child kid3 = new Child("Kamran","6","Mawson lakes public school","Superman",parent1);
        kid3.setChildID(getMaxChildID()+1);
        addChild(kid3);

        addMyKids(kid1);
        addMyKids(kid2);
        addMyKids(kid3);


        WalkGroup wGroup1 = new WalkGroup("Sch1Group1","Mawson lakes", "Mawson lakes public school",
                "12 Mawson lakes boulevard, Mawson lakes", "730");

        ChildGroup group1 = new ChildGroup(kid1,wGroup1,false);
        ChildGroup group2 = new ChildGroup(kid2,wGroup1,false);
        ChildGroup group3 = new ChildGroup(kid3,wGroup1,false);

        addChildGroup(group1);
        addChildGroup(group2);
        addChildGroup(group3);

        //Alex code
        othersWalkGroupList = new ArrayList<WalkGroup>();
        WalkGroup wg1 = new WalkGroup("The Walkers","5050","Belair Primary","","");
        Parent p1 = new Parent("Simon","0404041010","simon@email.com");
        wg1.setGroupAdmin(p1);
        ArrayList<Child> cl1 = new ArrayList<Child>();
        cl1.add(new Child("Orson","10","Belair Primary","Thomas The Traing",p1));
        cl1.add(new Child("John","10","Belair Primary","Octonauts",p1));
        cl1.add(new Child("Kiara","10","Belair Primary","Chuggington",p1));
        wg1.setChildList(cl1);
        othersWalkGroupList.add(wg1);

        parentSelf = new Parent("Alex Bulgaris","0404040808","alex_bulgaris@email.com");

    }

    public void addChildGroup(ChildGroup group){
        myKidGroups.add(group);
    }

    public long getMaxParentID(){
        long maxParentID = 0;
        for(Parent p : parents){
            if (p.getParentID() > maxParentID)
                maxParentID = p.getParentID();
        }
        return maxParentID;
    }

    public long getMaxChildID(){
        long maxChildID = 0;
        for(Child c : childs){
            if (c.getChildID() > maxChildID)
                maxChildID = c.getChildID();
        }
        return maxChildID;
    }


    //Alex code

    private static DataProvider instance = null;

    //implementing singleton pattern
    public static DataProvider getInstance() {
        if(instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }

    private static ArrayList<String> schoolList = new ArrayList<String>();
    private static ArrayList<WalkGroup> walkGroupList = new ArrayList<WalkGroup>();
    private static ArrayList<WalkGroup> othersWalkGroupList = new ArrayList<WalkGroup>();
    private  static Parent parentSelf = null;

    private void createSchoolList(){
        schoolList.add("Select School...");
        schoolList.add("Belair Primary");
        schoolList.add("Crafers Primary");
        schoolList.add("Flinders Park Primary");
        schoolList.add("Happy Valley Primary");
        schoolList.add("Henley Beach Primary");
        schoolList.add("Mawson Lakes School");
        schoolList.add("Norwood Primary");
        schoolList.add("Prospect Primary");
        schoolList.add("Unley Primary");
        schoolList.add("Vale Park Primary");
        schoolList.add("Walkerville Primary");
    }

    public ArrayList<String> getSchoolList() {
        return schoolList;
    }

    public ArrayList<WalkGroup> getWalkGrouplList() {
        return walkGroupList;
    }

    public ArrayList<WalkGroup> getOthersWalkGrouplList() {
        return othersWalkGroupList;
    }

    public Parent getParentSelf() { return parentSelf; }

    public void addWalkGroup(String groupName, String suburb, String school, String dropzonAddress, String morningTime) {
        WalkGroup wg = new WalkGroup(groupName,suburb,school,dropzonAddress,morningTime);
        walkGroupList.add(wg);
    }

    public boolean walkGroupExists() {
        if(walkGroupList.size() > 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean walkGroupExists(String wgName){
        for(WalkGroup wg : walkGroupList) {
          if(wgName.equalsIgnoreCase(wg.getGroupName())){
              return true;
          }
        }
        return false;
    }

    public ArrayList<WalkGroup> findOtherWalkGroupsBySchool(String school) {
        ArrayList<WalkGroup> wgl = new ArrayList<WalkGroup>();
        for(WalkGroup wg : othersWalkGroupList) {
            if(school.equalsIgnoreCase(wg.getSchool())){
                wgl.add(wg);
            }
        }

        return wgl;
    }

    public void joinWalkGroup(WalkGroup wg) {
        if(!walkGroupExists(wg.groupName)){
            walkGroupList.add(wg);
        }
    }

    public WalkGroup findWalkGroupByName(String wgName) {
        for(WalkGroup wg : walkGroupList) {
            if(wgName.equalsIgnoreCase(wg.getGroupName())){
                return wg;
            }
        }
        return null;
    }
}
