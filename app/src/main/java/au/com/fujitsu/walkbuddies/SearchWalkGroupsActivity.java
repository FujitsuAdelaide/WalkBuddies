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
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import au.com.fujitsu.walkbuddies.util.DataProvider;

public class SearchWalkGroupsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_walk_groups);
        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.main_top_toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            toolbar.setNavigationIcon(R.drawable.hamb);
            String title = "         " + toolbar.getTitle().toString();
            SpannableString s = new SpannableString(title);
            s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(s);

            ImageButton settingsButton = (ImageButton) findViewById(R.id.toolbar_home_button);
            settingsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                    startActivity(intent);
                }
            });
        }

        DataProvider dp = DataProvider.getInstance();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, dp.getSchoolList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerSchools = (Spinner) findViewById(R.id.school_spinner2);
        spinnerSchools.setAdapter(adapter);

        String error = "";
        try{
            error = getIntent().getExtras().get("ERROR_MSG").toString();
        } catch (Exception e){}

        TextView tv = (TextView) findViewById(R.id.textViewError1);
        tv.setText(error);
        if(!"".equals(error)){
            tv.setTextColor(Color.WHITE);
            tv.setBackgroundColor(Color.RED);
        } else {
            tv.setBackgroundColor(0);
        }
    }

    public void navigateToJoinGroupsAfterSearch(View view) {

        Spinner spinnerSchools = (Spinner) findViewById(R.id.school_spinner2);
        String schoolName = spinnerSchools.getSelectedItem().toString();

        if("Select School...".equals(schoolName)){
            return;
        }

        Intent intent = new Intent(this,JoinWalkGroupActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("SCHOOL_NAME", schoolName);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
