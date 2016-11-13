package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
