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

    static final String[] titleArr = new String[] {"starlight", "Title Two", "search & ranger rescue logs", "i don't know when to explain", "Title Five"};
    static final String[] authorArr = new String[] {"fiona jones", "Person Two", "fiona jones", "fiona jones", "Person Five"};
    static final String[] dateArr = new String[] {"2018", "2-2-2", "2018", "2018", "5-5-5"};
    static final String[] descArr = new String[] {
            "a series of small booklets, starlight explores the relationship between silhouette, color, and space. model is jess palmisciano.",
            "Description Two",
            "This story involved the idea of a man journeying through canyons that bear similarities to the Bryce Canyons in Utah. These illustrations were heavily inspired by the myths of Bryce Canyon, as well as Claire Hummel's studies into the Bryce Canyon arches & landscapes.",
            "\"I Don't Know When to Explain\" is part of the Rework Project assigned for Senior Seminar that challenged students to take an original project and to learn from previous mistakes to recreate the project. I used my original project,\"I Don't Know How to Explain\" to create a project that expanded on the ideas from the original project. \"I Don't Know When to Explain \" is composed of 57+ prints that feature 20+ models covered in black light powders.",
            "Description Five"
    };
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
                b.putString("author", "artist: "+authorArr[i]);
                b.putString("date", dateArr[i]);
                b.putString("desc", "description: "+descArr[i]);
                Intent myIntent = new Intent(view.getContext(), ArtInfo.class);
                myIntent.putExtras(b);
                startActivity(myIntent);

            }
        });


        return view;
    }
}