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

public class ChildListAdapter extends ArrayAdapter<Child> {

    public ChildListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ChildListAdapter(Context context, int resource, List<Child> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.child_row, null);
        }

        Child childItem = getItem(position);

        if (childItem != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.categoryId);
            TextView tt3 = (TextView) v.findViewById(R.id.description);

            if (tt1 != null) {
                tt1.setText(childItem.getChildName());
            }

            if (tt2 != null) {
                tt2.setText(childItem.getChildCharacter());
            }

            if (tt3 != null) {
                tt3.setText(childItem.getChildAge());
            }
        }

        return v;
    }
}
