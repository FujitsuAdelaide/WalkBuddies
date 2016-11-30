package au.com.fujitsu.walkbuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void navigateToChildView(View view) {
        Intent intent = new Intent(this,ViewChild_MB.class);
        startActivity(intent);
    }

    public void navigateToStartWalk(View view) {
        Intent intent = new Intent(this,KidsWalkGroups.class);
        startActivity(intent);
    }

    public void navigateToGroupsView(View view) {
        Intent intent = new Intent(this,ViewGroupsActivity.class);
        startActivity(intent);
    }
}
