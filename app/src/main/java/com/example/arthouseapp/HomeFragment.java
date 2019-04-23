package com.example.arthouseapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    static final String[] titleArr = new String[] {"Title One", "Title Two", "Title Three", "Title Four", "Title Five"};
    static final String[] authorArr = new String[] {"Person One", "Person Two", "Person Three", "Person Four", "Person Five"};
    static final String[] dateArr = new String[] {"1-1-1", "2-2-2", "3-3-3", "4-4-4", "5-5-5"};
    static final String[] descArr = new String[] {"Description One", "Description Two", "Description Three", "Description Four", "Description Five"};
    static final String[] imageArr = new String[] {"pic1", "pic2", "pic3", "pic4", "pic5"};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, null);

        ListView listView = (ListView)view.findViewById(R.id.homeList);
        listView.setAdapter(new MobileArrayAdapter(getActivity(), imageArr));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle b = new Bundle();

                b.putString("fileName", imageArr[i]);
                b.putString("title", titleArr[i]);
                b.putString("author", authorArr[i]);
                b.putString("date", dateArr[i]);
                b.putString("desc", descArr[i]);
                Intent myIntent = new Intent(view.getContext(), ArtInfo.class);
                myIntent.putExtras(b);
                startActivity(myIntent);

            }
        });


        return view;
    }
}