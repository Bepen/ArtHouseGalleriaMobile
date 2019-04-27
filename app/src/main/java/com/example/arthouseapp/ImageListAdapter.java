package com.example.arthouseapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class ImageListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public ImageListAdapter(Context context, String[] values) {
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


        int id = context.getResources().getIdentifier(s, "drawable", context.getPackageName());
        imageView.setImageResource(id); //generate feed

        return rowView;
    }
}