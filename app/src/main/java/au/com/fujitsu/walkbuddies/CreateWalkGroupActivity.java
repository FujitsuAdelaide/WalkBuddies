package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import au.com.fujitsu.walkbuddies.util.DataProvider;
import au.com.fujitsu.walkbuddies.util.WalkGroup;

public class CreateWalkGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_walk_group);
        DataProvider dp = DataProvider.getInstance();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, dp.getSchoolList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerSchools = (Spinner) findViewById(R.id.school_spinner);
        spinnerSchools.setAdapter(adapter);
        spinnerSchools.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                EditText et = (EditText) findViewById(R.id.walk_group_drop_zone);
                if(position == 1) {
                    et.setText("45 - 83 Main Rd, Belair SA 5052");
                } else if(position == 2) {
                    et.setText("55 Piccadilly Road Crafers SA 5152");
                } else if(position == 3) {
                    et.setText("70 Holbrooks Rd, Flinders Park SA 5025");
                } else {
                    et.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        Toolbar toolbar;
        toolbar = (Toolbar)findViewById(R.id.main_top_toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            toolbar.setNavigationIcon(R.drawable.hamb);
            String title = "     "+toolbar.getTitle().toString();
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
    }

    public void navigateToGroupsViewAfterCreate(View view) {
        DataProvider dp = DataProvider.getInstance();
        EditText et = (EditText) findViewById(R.id.walk_group_name);
        Spinner spinnerSchools = (Spinner) findViewById(R.id.school_spinner);
        String schoolName = spinnerSchools.getSelectedItem().toString();
        String walkGroupName = et.getText().toString();
        EditText timeET = (EditText) findViewById(R.id.walk_group_time);
        EditText zoneET = (EditText) findViewById(R.id.walk_group_drop_zone);

        if("Select School...".equals(schoolName)){
            et.setError("Please select School from list");
            return;
        }

        if(TextUtils.isEmpty(walkGroupName)) {
            et.setError("Walk Group name cannot be empty");
            return;
        }

        if (!dp.walkGroupExists(walkGroupName)) {
            WalkGroup wg = new WalkGroup(walkGroupName, dp.getParentSelf().getParentAddress(),schoolName
                    , zoneET.getText().toString(), timeET.getText().toString());
            wg.setGroupAdmin(dp.getParentSelf());
            wg.setChildList(dp.getParentSelf().getChildList());
            wg.addAdult(dp.getParentSelf());
            dp.getWalkGrouplList().add(wg);
        }
        Intent intent = new Intent(this,ViewGroupsActivity.class);
        startActivity(intent);
    }

    public void navigateToSearchWalkGroups(View view){
        Intent intent = new Intent(this,SearchWalkGroupsActivity.class);
        startActivity(intent);
    }

}
