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

    static final String[] images =
            new String[] {"pic1", "pic2"};

    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String url= "http://arthousegalleria.com";
        Document doc;
        try{
            doc = Jsoup.connect(url).get();
        }catch (IOException e){
            e.printStackTrace();
            doc = null;
        }
        if( doc != null) {
            Elements links = doc.select("a[href]");
        }

        View view = inflater.inflate(R.layout.fragment_home, null);

        ListView listView = (ListView)view.findViewById(R.id.homeList);
        listView.setAdapter(new MobileArrayAdapter(getActivity(), images));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Item0.i = i;
                Intent myIntent = new Intent(view.getContext(), Item0.class);
                startActivity(myIntent);

            }
        });


        return view;
    }
}