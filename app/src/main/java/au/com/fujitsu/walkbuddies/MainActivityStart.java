package au.com.fujitsu.walkbuddies;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

import au.com.fujitsu.walkbuddies.util.DataProvider;

public class MainActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        DataProvider dp = DataProvider.getInstance();
        dp.addDummyData();
        ((WalkBuddiesApplication) this.getApplication()).setDataProvider(dp);

        Toolbar toolbar;
        toolbar = (Toolbar)findViewById(R.id.main_top_toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            String title = "                    "+toolbar.getTitle().toString();
            SpannableString s = new SpannableString(title);
            s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(s);
        }
    }

    /**
     * Called when user click's on Sign In button from Sign Up page
     * @param view
     */
    public void navigateToLogin(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void navigateToHome(View view){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    public void registerWithGoogle(View view){
        Intent intent = new Intent(this,RegisterParent.class);
        startActivity(intent);
    }

}
