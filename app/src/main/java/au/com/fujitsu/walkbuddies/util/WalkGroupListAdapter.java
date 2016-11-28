package au.com.fujitsu.walkbuddies.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.ClipData.Item;
import android.widget.TextView;

import java.util.List;

import au.com.fujitsu.walkbuddies.R;

/**
 * Created by bulgarisa on 28/11/2016.
 */

public class WalkGroupListAdapter extends ArrayAdapter<WalkGroup> {

    public WalkGroupListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public WalkGroupListAdapter(Context context, int resource, List<WalkGroup> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.walk_group_row, null);
        }

        WalkGroup wgItem = getItem(position);

        if (wgItem != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.categoryId);
            TextView tt3 = (TextView) v.findViewById(R.id.description);

            if (tt1 != null) {
                tt1.setText(wgItem.getGroupName());
            }

            if (tt2 != null) {
                tt2.setText(wgItem.getSchool());
            }

            if (tt3 != null) {
                tt3.setText(wgItem.getSuburb());
            }
        }

        return v;
    }
}
