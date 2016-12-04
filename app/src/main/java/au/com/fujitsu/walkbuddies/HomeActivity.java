package au.com.fujitsu.walkbuddies;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import au.com.fujitsu.walkbuddies.util.DataProvider;
import au.com.fujitsu.walkbuddies.util.FeedItem;
import au.com.fujitsu.walkbuddies.util.MyRecyclerViewAdapter;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<String> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar;
        toolbar = (Toolbar)findViewById(R.id.main_top_toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            toolbar.setNavigationIcon(R.drawable.hamb);
            String title = "               "+toolbar.getTitle().toString();
            SpannableString s = new SpannableString(title);
            s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(s);

            ImageButton settingsButton = (ImageButton) findViewById(R.id.toolbar_home_button);
            settingsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(),HomeActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    public void navigateToChildView(View view) {
        Intent intent = new Intent(this,ViewChild_MB.class);
        startActivity(intent);
    }

    public void navigateToStartWalk(View view) {
        Intent intent = new Intent(this,KidsWalkGroups.class);
        startActivity(intent);
    }

    public void navigateToGroupsView(View view) {
        Intent intent = new Intent(this,ViewGroupsActivity.class);
        startActivity(intent);
    }

}
