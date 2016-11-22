package au.com.fujitsu.walkbuddies;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.AbsListView;
import android.content.Intent;

import java.util.ArrayList;

public class ViewChild_MB extends AppCompatActivity {

    DBAdapter myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_child);
        openDB();
        Cursor cursor = myDb.getAllRows();
        displayRecordSet(cursor);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }


    private void openDB() {
        myDb = new DBAdapter(this);
        myDb.open();
    }
    private void closeDB() {
        if (myDb != null) {
            myDb.close();
        }
    }

    private void addToList(String[] childlist) {
        ListView listView = (ListView) findViewById(R.id.childList);

        // listening to single list item on click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // selected item
                String ref = ((TextView) view).getText().toString();

                Intent intent = new Intent();
                intent.setClassName("au.com.fujitsu.walkbuddies",
                        "au.com.fujitsu.walkbuddies.AddChild_MB");
                intent.putExtra("childName", ref);
                startActivity(intent);
            }
        });


        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, childlist);

        /*MyAdapter itemsAdapter =
                new MyAdapter(this, childlist);*/

        listView.setAdapter(itemsAdapter);
     }

    // Display an entire recordset to the screen.
    private void displayRecordSet(Cursor cursor) {
        ArrayList<String> arrayList = new ArrayList<>();

        // populate the message from the cursor

        // Reset cursor to start, checking to see if there's data:
        if (cursor.moveToFirst()) {
            do {
                // Process the data:
                int id = cursor.getInt(DBAdapter.COL_ROWID);
                String name = cursor.getString(DBAdapter.COL_NAME);
                int age = cursor.getInt(DBAdapter.COL_AGE);

                arrayList.add(name);

            } while(cursor.moveToNext());
        }

        // Close the cursor to avoid a resource leak.
        cursor.close();

        String[] childlist = new String[arrayList.size()];
        childlist = arrayList.toArray(childlist);

        addToList(childlist);

    }

    /*
    public class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(Context context, String[] strings) {
            super(context, -1, -1, strings);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LinearLayout listLayout = new LinearLayout(ViewChild_MB.this);
            listLayout.setLayoutParams(new AbsListView.LayoutParams(
                    AbsListView.LayoutParams.WRAP_CONTENT,
                    AbsListView.LayoutParams.WRAP_CONTENT));

            TextView listText = new TextView(ViewChild_MB.this);
            listLayout.addView(listText);
            listText.setText(super.getItem(position));

            return listLayout;
        }
    }*/


}
