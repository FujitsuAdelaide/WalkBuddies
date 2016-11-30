package au.com.fujitsu.walkbuddies;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.AbsListView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Iterator;


import au.com.fujitsu.walkbuddies.util.Child;
import au.com.fujitsu.walkbuddies.util.ChildGroup;
import au.com.fujitsu.walkbuddies.util.DataProvider;

public class ViewChild_MB extends AppCompatActivity {

    DBAdapter myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_child);

        loadKids();
    }

    private void loadKids(){
        final TableLayout table = (TableLayout) findViewById(R.id.kids);
        TableRow tr;
   //     TableRow tr1= (TableRow)table.findViewById(R.id.rowkg);
        Integer count = 0;

        DataProvider myKidsData = ((WalkBuddiesApplication) this.getApplication()).getDataProvider();

        for (Child child: myKidsData.getMyKids()) {
            tr = new TableRow(this);

            tr.setId(100 + count);
            tr.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));


            TextView label_Name = new TextView(this);
            label_Name.setId(200 + count);
            label_Name.setText(child.getChildName());
            label_Name.setGravity(Gravity.LEFT);

            tr.addView(label_Name, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.50f));// add the column to the table row here

            TextView label_Group = new TextView(this);
            label_Group.setId(300 + count);
            //label_Group.setText("      " + child.getChildAge());
            label_Group.setText(child.getChildAge());
            label_Group.setGravity(Gravity.LEFT);
            tr.addView(label_Group, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.20f));// add the column to the table row here

            ImageButton btnRemove = new ImageButton(this);
            btnRemove.setImageResource(android.R.drawable.ic_delete);
            btnRemove.setBackgroundColor(Color.TRANSPARENT);

            btnRemove.setId(400 + count);
            btnRemove.setTag(child);

            btnRemove.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Child child = (Child) v.getTag();
                    View row = (View) v.getParent();
                    ViewGroup container = ((ViewGroup)row.getParent());
                    container.removeView(row);
                    container.invalidate();

                    deleteChild(child);

                }
            });


            tr.addView(btnRemove, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.30f));// add the column to the table row here

            table.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

            count++;
        }
    }

    public void navigateToAddChild(View view) {
        Intent intent = new Intent(this,AddChild_MB.class);
        startActivity(intent);
    }

    private void deleteChild(Child child){
        DataProvider dp = DataProvider.getInstance();
        dp.getMyKids().remove(child);
    }
}
