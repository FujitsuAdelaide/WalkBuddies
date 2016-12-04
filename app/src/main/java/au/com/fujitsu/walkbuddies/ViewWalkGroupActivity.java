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
import android.widget.ImageButton;
import android.widget.TextView;

import au.com.fujitsu.walkbuddies.util.DataProvider;
import au.com.fujitsu.walkbuddies.util.WalkGroup;

public class ViewWalkGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_walk_group);

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

        String wgName = getIntent().getExtras().get("WALK_GROUP_NAME").toString();

        DataProvider dp = DataProvider.getInstance();
        WalkGroup wg = dp.findWalkGroupByName(wgName);

        TextView wgNameTV = (TextView) findViewById(R.id.walk_group_name);
        try {
            wgNameTV.setText(wg.getGroupName());
        } catch (Exception e1) {}

        TextView wgSchoolTV = (TextView) findViewById(R.id.walk_group_school);
        try {
            wgSchoolTV.setText(wg.getSchool());
        } catch (Exception e2) {}

        TextView wgSuburbTV = (TextView) findViewById(R.id.walk_group_suburb);
        try {
            wgSuburbTV.setText(wg.getSuburb());
        } catch (Exception e3) {}

        TextView wgAdminTV = (TextView) findViewById(R.id.walk_group_admin);
        try {
            wgAdminTV.setText(wg.getGroupAdmin().getParentName());
        } catch (Exception e4) {}


    }
}
