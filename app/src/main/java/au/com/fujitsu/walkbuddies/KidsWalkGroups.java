package au.com.fujitsu.walkbuddies;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import au.com.fujitsu.walkbuddies.util.Child;
import au.com.fujitsu.walkbuddies.util.ChildGroup;
import au.com.fujitsu.walkbuddies.util.DataProvider;

public class KidsWalkGroups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_walk_groups);
     //   setupTable();
        loadKidsGroups();
    }

    private void setupTable() {

        Integer count = 0;
        TableLayout table = (TableLayout) findViewById(R.id.kids_groups);

        TableRow tr_head = new TableRow(this);

        tr_head.setId(10 + count);
        tr_head.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


        TextView label_KidName = new TextView(this);
        label_KidName.setId(20 + count);
        label_KidName.setText(R.string.kid_col_heading);
        label_KidName.setPadding(5, 5, 5, 5);
        tr_head.addView(label_KidName);// add the column to the table row here

        TextView label_Group = new TextView(this);
        label_Group.setId(21 + count);// define id that must be unique
        label_Group.setText(R.string.group_col_heading); // set the text for the header
        label_Group.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(label_Group); // add the column to the table row here

        TextView label_Status = new TextView(this);
        label_Status.setId(22 + count);// define id that must be unique
        label_Status.setText(R.string.status_col_heading); // set the text for the header
        label_Status.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(label_Status); // add the column to the table row here

        table.addView(tr_head);

    }

    private void loadKidsGroups(){
        TableLayout table = (TableLayout) findViewById(R.id.kids_groups);
        TableRow tr;
        Integer count = 0;

        DataProvider myKidsData = ((WalkBuddiesApplication) this.getApplication()).getDataProvider();

        for (ChildGroup group: myKidsData.getMyKidGroups()) {
            tr = new TableRow(this);
            tr.setId(100 + count);
            tr.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            TextView label_Name = new TextView(this);
            label_Name.setId(200 + count);
            label_Name.setText(group.getKid().getChildName());
            label_Name.setGravity(Gravity.LEFT);

            tr.addView(label_Name, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.30f));// add the column to the table row here

            TextView label_Group = new TextView(this);
            label_Group.setId(300 + count);
            label_Group.setText(group.getGroup().getGroupName());
            label_Group.setGravity(Gravity.LEFT);
            tr.addView(label_Group, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.50f));// add the column to the table row here

            CheckBox chk_Status = new CheckBox(this);
            chk_Status.setId(400 + count);
            chk_Status.setChecked(group.isInActive());
            tr.addView(chk_Status, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.20f));// add the column to the table row here

            table.addView(tr);
            count++;
        }






    }
}
