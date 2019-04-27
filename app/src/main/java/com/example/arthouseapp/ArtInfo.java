package com.example.arthouseapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtInfo extends AppCompatActivity { //generate info for each painting based on which is seleced
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artinfo);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Intent in = getIntent();

        Bundle b = in.getExtras();


        Context context = imageView.getContext();
        id = context.getResources().getIdentifier(b.getString("fileName"), "drawable", context.getPackageName());
        imageView.setImageResource(id);



        TextView title = (TextView)findViewById(R.id.titleOfWork);
        title.setText(b.getString("title"));

        TextView author = (TextView)findViewById(R.id.authorOfWork);
        author.setText(b.getString("author"));

        TextView date = (TextView)findViewById(R.id.dateOfWork);
        date.setText("("+b.getString("date")+")");

        TextView description = (TextView)findViewById(R.id.descOfWork);
        description.setText(b.getString("desc"));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bun = new Bundle();

                bun.putInt("fileId", id);
                Intent myIntent = new Intent(view.getContext(), ArActivity.class);
                myIntent.putExtras(bun);
                startActivity(myIntent);
            }
        });

    }
}
