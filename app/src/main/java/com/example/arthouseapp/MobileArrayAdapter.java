package com.example.arthouseapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MobileArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MobileArrayAdapter(Context context, String[] values) {
        super(context, R.layout.list_mobile, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_mobile, parent, false);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);


        // Change icon based on name
        String s = values[position];

        System.out.println(s);

        Context context = imageView.getContext();
        ///imageView.setAdjustViewBounds(true);

        Item0.titleArr = new String[] {"Title One", "Person Two"};
        Item0.authorArr = new String[] {"Person One", "Person Two"};
        Item0.dateArr = new String[] {"1-1-1", "2-2-2"};
        Item0.descArr = new String[] {"Description One", "Description Two"};
        Item0.imageArr = new String[] {"pic1", "pic2"};

        int id = context.getResources().getIdentifier(s, "drawable", context.getPackageName());
        imageView.setImageResource(id);

        return rowView;
    }
}