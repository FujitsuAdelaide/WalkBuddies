package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.database.Cursor;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import au.com.fujitsu.walkbuddies.util.Child;
import au.com.fujitsu.walkbuddies.util.DataProvider;
import au.com.fujitsu.walkbuddies.util.Parent;

public class AddChild_MB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);

    }

    public void addChild(View v){
        try {
            DataProvider localDataProvide = ((WalkBuddiesApplication) this.getApplication()).getDataProvider();
            if (localDataProvide == null)
                System.out.println("localDataProvide is null");


            Child child = new Child();
            child.setChildName(((EditText) findViewById(R.id.childNameEdittxt)).getText().toString());
            child.setChildAge(((EditText) findViewById(R.id.childAgeeditText)).getText().toString());
            child.setChildID(localDataProvide.getMaxChildID() + 1);

            if(addChildValidations(child)) {
                localDataProvide.addMyKids(child);
                System.out.println("WalkBuddiesApplication log: Child added.");

                Intent intent = new Intent(this,ViewChild_MB.class);
                startActivity(intent);
            }

        }catch(Exception e){
            System.out.println("WalkBuddiesApplication log: Child could not added.");
            e.printStackTrace();
            Intent intent = new Intent(this,MainActivityStart.class);
            startActivity(intent);

        }

    }

    private boolean addChildValidations(Child child){

        boolean result = true;

        System.out.println("Child name is " + child.getChildName());
        if("".equalsIgnoreCase(child.getChildName())) {
            System.out.println("WalkBuddiesApplication log: Child could not added. Please fix the error.");
            result = false;
        }

        if("".equalsIgnoreCase(child.getChildAge())) {

            System.out.println("WalkBuddiesApplication log: Parent could not registered. Please fix the error.");
            result = false;
        }
        return result;
    }

}
