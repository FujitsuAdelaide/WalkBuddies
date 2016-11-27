package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
    }

    public void navigateToGroupsViewAfterCreate(View view) {
        DataProvider dp = DataProvider.getInstance();
        EditText et = (EditText) findViewById(R.id.walk_group_name);
        Spinner spinnerSchools = (Spinner) findViewById(R.id.school_spinner);
        String walkGroupName = spinnerSchools.getSelectedItem().toString();
        if (!dp.walkGroupExists(walkGroupName)) {
            WalkGroup wg = new WalkGroup(et.getText().toString(), "",walkGroupName
                    , "", "");
            dp.getWalkGrouplList().add(wg);
        }
        Intent intent = new Intent(this,ViewGroupsActivity.class);
        startActivity(intent);
    }

}
