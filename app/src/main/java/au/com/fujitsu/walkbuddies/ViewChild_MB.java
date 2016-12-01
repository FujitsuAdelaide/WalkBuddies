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
import android.widget.RelativeLayout;
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
        TableLayout table = (TableLayout) findViewById(R.id.kids);
        TableRow tr;
        Integer count = 0;

        DataProvider myKidsData = ((WalkBuddiesApplication) this.getApplication()).getDataProvider();

        tr = new TableRow(this);
        tr.setId(100 + count);
        tr.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        tr.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        TextView head_Name = new TextView(this);
        head_Name.setId(200 + count);
        head_Name.setText("Name");
        head_Name.setTextColor(Color.WHITE);
        head_Name.setGravity(Gravity.LEFT);

        tr.addView(head_Name, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.50f));// add the column to the table row here

        TextView head_Group = new TextView(this);
        head_Group.setId(300 + count);
        head_Group.setText("Age");
        head_Group.setTextColor(Color.WHITE);
        head_Group.setGravity(Gravity.LEFT);
        tr.addView(head_Group, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.20f));// add the column to the table row here

        TextView head_Delete = new TextView(this);
        head_Delete.setId(400 + count);
        head_Delete.setText("");
        head_Delete.setTextColor(Color.RED);
        head_Delete.setGravity(Gravity.RIGHT);
        tr.addView(head_Delete, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.30f));// add the column to the table row here

        table.addView(tr);
        count++;

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
            label_Group.setText(child.getChildAge());
            label_Group.setGravity(Gravity.LEFT);
            tr.addView(label_Group, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.40f));// add the column to the table row here

            TextView label_Delete = new TextView(this);
            label_Delete.setTag(child);

            label_Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Child child = (Child) view.getTag();
                    View row = (View) view.getParent();
                    ViewGroup container = (ViewGroup)row.getParent();
                    container.removeView(row);
                    container.invalidate();

                    DataProvider dp = DataProvider.getInstance();
                    dp.getMyKids().remove(child);
                }
            });
            label_Delete.setId(400 + count);
            label_Delete.setText("X");
            label_Delete.setTextColor(Color.RED);
            label_Delete.setGravity(Gravity.RIGHT);
            tr.addView(label_Delete, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.10f));// add the column to the table row here

/*

            ImageButton btnRemove = new ImageButton(this);
          //  Button btnRemove = new Button(this);
            btnRemove.requestLayout();
            btnRemove.setImageResource(android.R.drawable.ic_delete);
          //  btnRemove.setBackgroundColor(Color.TRANSPARENT);

            btnRemove.setId(400 + count);
            TableRow.LayoutParams params = new TableRow.LayoutParams(200, 200);


//setting margins around imageimageview
            //params.setMargins(10, 10, 10, 10); //left, top, right, bottom

//adding attributes to the imageview
            btnRemove.setLayoutParams(params);

            tr.addView(btnRemove);
*/


            //tr.addView(btnRemove, null, 0.30f));// add the column to the table row here

            table.addView(tr);
            count++;
        }
    }

    public void navigateToAddChild(View view) {
        Intent intent = new Intent(this,AddChild_MB.class);
        startActivity(intent);
    }
}
