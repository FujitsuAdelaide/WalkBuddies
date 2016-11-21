package au.com.fujitsu.walkbuddies;

import android.app.Application;

import au.com.fujitsu.walkbuddies.util.DataProvider;

/**
 * Created by kamran on 21/11/16.
 */

public class WalkBuddiesApplication extends Application {

    private DataProvider dataProvider;

    public DataProvider getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }


}
