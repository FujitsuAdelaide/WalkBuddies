package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import au.com.fujitsu.walkbuddies.util.DataProvider;
import au.com.fujitsu.walkbuddies.util.WalkGroup;

public class ViewGroupsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_groups);
        DataProvider dp = DataProvider.getInstance();
        //If there are no walk groups redirect to create walk group activity
        if(!dp.walkGroupExists()) {
            Intent intent = new Intent(this,CreateWalkGroupActivity.class);
            startActivity(intent);
            finish();
        } else {
            ListView lv = (ListView)findViewById(R.id.walk_group_list);
            ArrayAdapter<WalkGroup> adapter = new ArrayAdapter<WalkGroup>(
                    this, android.R.layout.simple_spinner_item, dp.getWalkGrouplList());
            lv.setAdapter(adapter);
        }
    }
}
