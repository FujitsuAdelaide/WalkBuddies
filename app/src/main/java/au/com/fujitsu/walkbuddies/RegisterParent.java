package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import au.com.fujitsu.walkbuddies.util.DataProvider;
import au.com.fujitsu.walkbuddies.util.Parent;

public class RegisterParent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_parent);
    }

    public void registerParent(View v){
        try {
            DataProvider localDataProvide = ((WalkBuddiesApplication) this.getApplication()).getDataProvider();
            if (localDataProvide == null)
                System.out.println("localDataProvide is null");


            Parent parent = new Parent();
            parent.setParentName(((EditText) findViewById(R.id.edtParentName)).getText().toString());
            parent.setParentAddress(((EditText) findViewById(R.id.edtParentAddress)).getText().toString());
            parent.setParentMobile(((EditText) findViewById(R.id.edtParentMobile)).getText().toString());
            parent.setParentEmail(((EditText) findViewById(R.id.edtParentEmail)).getText().toString());
            parent.setParentID(localDataProvide.getMaxParentID() + 1);

            if(registrationValidations(parent)) {
                localDataProvide.addParent(parent);
                localDataProvide.setLoggedInParent(parent);
                System.out.println("WalkBuddiesApplication log: Parent registered.");
                Intent intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
            }

        }catch(Exception e){
            System.out.println("WalkBuddiesApplication log: Parent could not registered.");
            e.printStackTrace();
            Intent intent = new Intent(this,MainActivityStart.class);
            startActivity(intent);

        }

    }

    private boolean registrationValidations(Parent parent){

        boolean result = true;

        System.out.println("Parent name is " + parent.getParentName());
        if("".equalsIgnoreCase(parent.getParentName())) {
            TextView tvError = ((TextView) findViewById(R.id.tvNameError));
            tvError.setVisibility(View.VISIBLE);
            System.out.println("WalkBuddiesApplication log: Parent could not registered. Please fix the error.");
            result = false;
        }else{
            TextView tvError = ((TextView) findViewById(R.id.tvNameError));
            tvError.setVisibility(View.GONE);

        }

        if("".equalsIgnoreCase(parent.getParentAddress())) {
            TextView tvError = ((TextView) findViewById(R.id.tvParentAddressError));
            tvError.setVisibility(View.VISIBLE);
            System.out.println("WalkBuddiesApplication log: Parent could not registered. Please fix the error.");
            result = false;
        }else{
            TextView tvError = ((TextView) findViewById(R.id.tvParentAddressError));
            tvError.setVisibility(View.GONE);

        }



        return result;
    }
}
