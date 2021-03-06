package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import au.com.fujitsu.walkbuddies.util.WalkGroupListAdapter;
import au.com.fujitsu.walkbuddies.util.DataProvider;
import au.com.fujitsu.walkbuddies.util.WalkGroup;

public class ViewGroupsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_groups);

        Toolbar toolbar;
        toolbar = (Toolbar)findViewById(R.id.main_top_toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            toolbar.setNavigationIcon(R.drawable.hamb);
            String title = "         "+toolbar.getTitle().toString();
            SpannableString s = new SpannableString(title);
            s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(s);

            ImageButton settingsButton = (ImageButton) findViewById(R.id.toolbar_home_button);
            settingsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(),HomeActivity.class);
                    startActivity(intent);
                }
            });
        }

        DataProvider dp = DataProvider.getInstance();
        //If there are no walk groups redirect to create walk group activity
        if(!dp.walkGroupExists()) {
            Intent intent = new Intent(this,CreateWalkGroupActivity.class);
            startActivity(intent);
            finish();
        } else {
            ListView lv = (ListView)findViewById(R.id.walk_group_list);
            WalkGroupListAdapter adapter = new WalkGroupListAdapter(
                    this, android.R.layout.simple_list_item_1, dp.getWalkGrouplList());
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    WalkGroup wgAtPos = (WalkGroup) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(getBaseContext(),ViewWalkGroupActivity.class);
                    //Pass in Walk Group Name as a Param for the next activity
                    Bundle bundle = new Bundle();
                    bundle.putString("WALK_GROUP_NAME", wgAtPos.getGroupName());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
    }

    public void navigateToCreateGroup(View view){
        Intent intent = new Intent(this,CreateWalkGroupActivity.class);
        startActivity(intent);
    }

    public void navigateToSearchWalkGroups(View view){
        Intent intent = new Intent(this,SearchWalkGroupsActivity.class);
        startActivity(intent);
    }

}
