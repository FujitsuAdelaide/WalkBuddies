package au.com.fujitsu.walkbuddies.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import au.com.fujitsu.walkbuddies.R;

/**
 * Created by bulgarisa on 28/11/2016.
 */

public class ParentListAdapter extends ArrayAdapter<Parent> {

    public ParentListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ParentListAdapter(Context context, int resource, List<Parent> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.parent_row, null);
        }

        Parent parentItem = getItem(position);

        if (parentItem != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.categoryId);
            TextView tt3 = (TextView) v.findViewById(R.id.description);

            if (tt1 != null) {
                tt1.setText(parentItem.getParentName());
            }

            if (tt2 != null) {
                tt2.setText(parentItem.getParentAddress());
            }

            if (tt3 != null) {
                tt3.setText(parentItem.getParentMobile());
            }
        }

        return v;
    }
}
