package au.com.fujitsu.walkbuddies;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;

import au.com.fujitsu.walkbuddies.util.Child;
import au.com.fujitsu.walkbuddies.util.ChildGroup;
import au.com.fujitsu.walkbuddies.util.DataProvider;

public class KidsWalkGroups extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_walk_groups);
     //   setupTable();
        loadKidsGroups();

   //     Button button = (Button) findViewById(R.id.btnAbsentee);

        // add button listener
/*        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.kids_check_list);
                dialog.setTitle("My Kids");

                Button dialogButton = (Button) dialog.findViewById(R.id.btnDialogOk);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });*/


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


    public void absenteeDialog(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final ArrayList mSelectedItems = new ArrayList();
        DataProvider mDataProvider = ((WalkBuddiesApplication) this.getApplication()).getDataProvider();
        ArrayList<Child> myKids = mDataProvider.getMyKids();
        final String[] ara=new String[myKids.size()];
        int index = 0;
        for(Child child: mDataProvider.getMyKids()) {
            ara[index]= child.getChildName();
            index++;
            }

        //alertDialogBuilder.setMessage("Are you sure, You wanted to make decision").setTitle("My Kids");
     //   alertDialogBuilder.setTitle("Kids to Absent");

        alertDialogBuilder.setTitle("Kids to Absent")
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(ara, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        String selectedKids = "";
                        for(int i = 0; i < mSelectedItems.size() ; i++){
                            int index = Integer.parseInt(mSelectedItems.get(i).toString());
                            selectedKids = selectedKids + " " + ara[index];
                        }


                        Toast.makeText(KidsWalkGroups.this,"You clicked Ok button and selected values " + selectedKids,
                                Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(KidsWalkGroups.this,"You clicked Cancel button",
                                Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.create();
        alertDialogBuilder.show();

/*        alertDialogBuilder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(KidsWalkGroups.this,"You clicked yes button",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

        alertDialogBuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();*/
    }
}
