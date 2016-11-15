package au.com.fujitsu.walkbuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
    }

    /**
     * Called when user click's on Sign In button from Sign Up page
     * @param view
     */
    public void navigateToLogin(View view){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}
