package au.com.fujitsu.walkbuddies.util;

/**
 * Created by kamran on 19/11/16.
 */

public class ChildGroup {
    Child kid;
    WalkGroup group;
    boolean inActive;

    public ChildGroup(Child kid, WalkGroup group, boolean inActive) {
        this.kid = kid;
        this.group = group;
        this.inActive = inActive;
    }

    public Child getKid() {
        return kid;
    }

    public void setKid(Child kid) {
        this.kid = kid;
    }

    public WalkGroup getGroup() {
        return group;
    }

    public void setGroup(WalkGroup group) {
        this.group = group;
    }

    public boolean isInActive() {
        return inActive;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }


}
