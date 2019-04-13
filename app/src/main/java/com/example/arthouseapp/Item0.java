package com.example.arthouseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Item0 extends AppCompatActivity {

    static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item0);
        TextView textView = (TextView)findViewById(R.id.basicTextView);
        textView.setText("Hello, you have clicked on painting #" + i);
    }
}
