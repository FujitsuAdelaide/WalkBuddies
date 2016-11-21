package au.com.fujitsu.walkbuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import au.com.fujitsu.walkbuddies.util.DataProvider;

public class MainActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        try {
            if (((WalkBuddiesApplication) this.getApplication()).getDataProvider() == null)
                ((WalkBuddiesApplication) this.getApplication()).setDataProvider(new DataProvider());
        }catch (NullPointerException npe){
            ((WalkBuddiesApplication) this.getApplication()).setDataProvider(new DataProvider());
            System.out.println("Nullpointer exception while setting DataProvider");

        }
    }

    /**
     * Called when user click's on Sign In button from Sign Up page
     * @param view
     */
    public void navigateToLogin(View view){
        ((WalkBuddiesApplication) this.getApplication()).getDataProvider().addDummyData();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void registerWithGoogle(View view){
        Intent intent = new Intent(this,RegisterParent.class);
        startActivity(intent);
    }

}
