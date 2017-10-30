package thelawsofphysics.physicsapp;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


class ListAdapter extends BaseAdapter {

    private LayoutInflater mInflator;
    private String[] list;
    private Context myContext;

    ListAdapter(Context c, String[] l)
    {
        list = l;
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myContext = c;
    }
    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflator.inflate(R.layout.list_detail, null);
        TextView equationTextView = (TextView) v.findViewById(R.id.equationTextView);

        String text = list[position];
        clickableText(equationTextView, text);

        return v;
    }

    private void clickableText(TextView view, String line)
    {
        SpannableStringBuilder textSpan = new SpannableStringBuilder("");
        String[] clickable = line.split(" ");
        for (final String aClickable : clickable) {
            textSpan.append(aClickable);
            textSpan.setSpan(new SpecialClickableSpan(aClickable,myContext), textSpan.length() - aClickable.length(), textSpan.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            textSpan.append(" ");
        }
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setText(textSpan, TextView.BufferType.SPANNABLE);
    }
}

