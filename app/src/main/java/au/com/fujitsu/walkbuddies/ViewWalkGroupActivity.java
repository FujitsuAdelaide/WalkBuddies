package au.com.fujitsu.walkbuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewWalkGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_walk_group);
        TextView tv = (TextView) findViewById(R.id.walk_group_name);
        tv.setText(getIntent().getExtras().get("WALK_GROUP_NAME").toString());
    }
}
