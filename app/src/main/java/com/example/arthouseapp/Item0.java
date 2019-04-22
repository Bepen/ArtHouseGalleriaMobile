package com.example.arthouseapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Item0 extends AppCompatActivity {

    static int i = 0;
    static String[] titleArr;
    static String[] authorArr;
    static String[] dateArr;
    static String[] descArr;
    static String[] imageArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item0);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);


        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(imageArr[i], "drawable", context.getPackageName());
        imageView.setImageResource(id);



        TextView title = (TextView)findViewById(R.id.titleOfWork);
        title.setText(titleArr[i]);

        TextView author = (TextView)findViewById(R.id.authorOfWork);
        author.setText(authorArr[i]);

        TextView date = (TextView)findViewById(R.id.dateOfWork);
        date.setText(dateArr[i]);

        TextView description = (TextView)findViewById(R.id.descOfWork);
        description.setText(descArr[i]);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ArActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
