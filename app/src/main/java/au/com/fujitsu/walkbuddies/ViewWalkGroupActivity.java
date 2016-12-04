package au.com.fujitsu.walkbuddies;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import au.com.fujitsu.walkbuddies.util.Child;
import au.com.fujitsu.walkbuddies.util.ChildListAdapter;
import au.com.fujitsu.walkbuddies.util.DataProvider;
import au.com.fujitsu.walkbuddies.util.Parent;
import au.com.fujitsu.walkbuddies.util.ParentListAdapter;
import au.com.fujitsu.walkbuddies.util.WalkGroup;
import au.com.fujitsu.walkbuddies.util.WalkGroupListAdapter;

public class ViewWalkGroupActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_walk_group);

        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.main_top_toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            toolbar.setNavigationIcon(R.drawable.hamb);
            String title =  toolbar.getTitle().toString();
            SpannableString s = new SpannableString(title);
            s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(s);

            ImageButton settingsButton = (ImageButton) findViewById(R.id.toolbar_home_button);
            settingsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                    startActivity(intent);
                }
            });
        }

        String wgName = getIntent().getExtras().get("WALK_GROUP_NAME").toString();

        DataProvider dp = DataProvider.getInstance();
        WalkGroup wg = dp.findWalkGroupByName(wgName);

        TextView wgNameTV = (TextView) findViewById(R.id.walk_group_name);
        try {
            wgNameTV.setText(wg.getGroupName());
        } catch (Exception e) {
        }

        TextView wgSchoolTV = (TextView) findViewById(R.id.walk_group_school);
        try {
            wgSchoolTV.setText(wg.getSchool());
        } catch (Exception e) {
        }

        TextView wgSuburbTV = (TextView) findViewById(R.id.walk_group_suburb);
        try {
            wgSuburbTV.setText("Drop Zone Address: " + wg.getDropzoneAddress() + " - Preferred start walk time: " + wg.getMorningTime());
        } catch (Exception e) {
        }

        TextView wgAdminTV = (TextView) findViewById(R.id.walk_group_admin);
        try {
            wgAdminTV.setText(wg.getGroupAdmin().getParentName() + " - " + wg.getGroupAdmin().getParentMobile());
        } catch (Exception e) {
        }

        try {
            if (wg.getChildList().size() > 0) {
             /*   ListView lv2 = (ListView)findViewById(R.id.wgd_childs_list_view);
                ChildListAdapter adapterChilds = new ChildListAdapter(
                        this, android.R.layout.simple_list_item_1, wg.getChildList());
                    lv2.setAdapter(adapterChilds);*/

                LinearLayout lL = (LinearLayout) findViewById(R.id.linear_childs);

                for (int i = 0; i < wg.getChildList().size(); i++) {

                    TextView tv = new TextView(this);
                    tv.setGravity(Gravity.CENTER);
                    tv.setTypeface(null, Typeface.BOLD);
                    if(i == 0) {
                        tv.setBackgroundResource(R.drawable.ava_m_1);
                    } else if(i == 1) {
                        tv.setBackgroundResource(R.drawable.ava_m_2);
                    } else if(i == 2) {
                        tv.setBackgroundResource(R.drawable.ava_m_3);
                    }else if(i == 3) {
                        tv.setBackgroundResource(R.drawable.ava_m_4);
                    }else if(i == 4) {
                        tv.setBackgroundResource(R.drawable.ava_m_5);
                    }else if(i == 5) {
                        tv.setBackgroundResource(R.drawable.ava_m_6);
                    }else {
                        tv.setBackgroundResource(R.drawable.ava_m_7);
                    }
                    tv.setHeight(80);
                    tv.setId(i);
                    tv.setTextColor(Color.DKGRAY);
                    tv.setText(((Child)wg.getChildList().get(i)).getChildName()+" - "+
                               ((Child)wg.getChildList().get(i)).getChildCharacter());

                    //Integer a = tv.hashCode();
                    //map.put(a, authorNames.get(i));

                   /* tv.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            System.out.println("Clicked "+ map.get(v.hashCode()) );
                        }
                    });*/

                    lL.addView(tv);

                }
            }
        } catch (Exception e) {
        }

        try {
           if (wg.getParentList().size() > 0) {
          /*      ListView lv3 = (ListView) findViewById(R.id.wgd_adults_list_view);
                ParentListAdapter adapterParents = new ParentListAdapter(
                        this, android.R.layout.simple_list_item_1, wg.getParentList());
                lv3.setAdapter(adapterParents);*/

               LinearLayout lL = (LinearLayout) findViewById(R.id.linear_parents);

               for (int i = 0; i < wg.getChildList().size(); i++) {

                   TextView tv2 = new TextView(this);
                   tv2.setGravity(Gravity.CENTER);
                   tv2.setTextColor(Color.DKGRAY);
                   tv2.setTypeface(null, Typeface.BOLD);
                   if(i == 0) {
                       tv2.setBackgroundResource(R.drawable.ava_m_7);
                   } else if(i == 1) {
                       tv2.setBackgroundResource(R.drawable.ava_m_6);
                   } else if(i == 2) {
                       tv2.setBackgroundResource(R.drawable.ava_m_5);
                   }else if(i == 3) {
                       tv2.setBackgroundResource(R.drawable.ava_m_4);
                   }else if(i == 4) {
                       tv2.setBackgroundResource(R.drawable.ava_m_3);
                   }else if(i == 5) {
                       tv2.setBackgroundResource(R.drawable.ava_m_2);
                   }else {
                       tv2.setBackgroundResource(R.drawable.ava_m_1);
                   }
                   tv2.setHeight(80);
                   tv2.setId(i);
                   tv2.setText(((Parent)wg.getParentList().get(i)).getParentName()+" - "+
                           (((Parent)wg.getParentList().get(i))).getParentMobile());

                   lL.addView(tv2);
               }
            }
        } catch (Exception e) {
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ViewWalkGroup Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
