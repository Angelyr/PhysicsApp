package thelawsofphysics.physicsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


class ListAdapter extends BaseAdapter {

    private LayoutInflater mInflator;
    private String[] equations;

    ListAdapter(Context c, String[] e)
    {
        equations = e;
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return equations.length;
    }

    @Override
    public Object getItem(int position) {
        return equations[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflator.inflate(R.layout.list_detail, null);
        TextView equationTextView = (TextView) v.findViewById(R.id.equationTextView);

        String equation = equations[position];
        equationTextView.setText(equation);

        return v;
    }
}
