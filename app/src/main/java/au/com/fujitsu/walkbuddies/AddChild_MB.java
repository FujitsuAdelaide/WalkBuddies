package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.database.Cursor;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddChild_MB extends AppCompatActivity {

    DBAdapter myDb;
    private EditText mNameView;
    private EditText mAgeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);

        mNameView = (EditText) findViewById(R.id.childNameEdittxt);
        mAgeView = (EditText) findViewById(R.id.childAgeeditText);

        openDB();

        Intent i = getIntent();
        // getting attached intent data
        String childRef = i.getStringExtra("childName");

        if (childRef != null) {
            // get the reference value from the database
            displayReference(childRef);

        }




    }
    // Display a record on the screen.
    private void displayReference(String childRef) {
         Cursor cursor = myDb.getChildRows(childRef);

        // populate the message from the cursor

        // Reset cursor to start, checking to see if there's data:
        if (cursor.moveToFirst()) {
            do {
                // Process the data:
                int id = cursor.getInt(DBAdapter.COL_ROWID);
                String name = cursor.getString(DBAdapter.COL_NAME);
                int age = cursor.getInt(DBAdapter.COL_AGE);

                mNameView.setText(name);
                mAgeView.setText(""+age);


            } while(cursor.moveToNext());
        }

        // Close the cursor to avoid a resource leak.
        cursor.close();

    }




    public void onClick_ViewChild(View v) {

        int age;
        try {
            age = Integer.parseInt(mAgeView.getText().toString());
        }catch(ParseException | NumberFormatException e) {
            age = 0;
            Toast.makeText(this, "Invalid age entry", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            myDb.insertRow(mNameView.getText().toString(), age);
        } catch(RuntimeException r) {

        }

        Intent intent = new Intent();
        intent.setClassName("au.com.fujitsu.walkbuddies",
                "au.com.fujitsu.walkbuddies.ViewChild_MB");
        startActivity(intent);
    }

    private void openDB() {
        myDb = new DBAdapter(this);
        myDb.open();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }

    private void closeDB() {
        if (myDb != null) {
            myDb.close();
        }
    }

}
