package com.example.arthouseapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class HomeFragment extends Fragment {
// we are working to use our SQL database in order to pull directly from the website. We stopped webscraping because it was too slow
    static final String[] titleArr = new String[] {"starlight", "i don't know when to explain", "search & ranger rescue logs", "143", "Title Five"};
    static final String[] authorArr = new String[] {"fiona jones", "fiona jones", "fiona jones", "o k a n u c k u n", "chinatown stropky"};
    static final String[] dateArr = new String[] {"2018", "2018", "2018", "2019", "5-5-5"};
    static final String[] descArr = new String[] {
            "a series of small booklets, starlight explores the relationship between silhouette, color, and space. model is jess palmisciano.",
            "\"I Don't Know When to Explain\" is part of the Rework Project assigned for Senior Seminar that challenged students to take an original project and to learn from previous mistakes to recreate the project. I used my original project,\"I Don't Know How to Explain\" to create a project that expanded on the ideas from the original project. \"I Don't Know When to Explain \" is composed of 57+ prints that feature 20+ models covered in black light powders.",
            "This story involved the idea of a man journeying through canyons that bear similarities to the Bryce Canyons in Utah. These illustrations were heavily inspired by the myths of Bryce Canyon, as well as Claire Hummel's studies into the Bryce Canyon arches & landscapes.",
            "",
            ""
    };
    static final String[] imageArr = new String[] {"pic1", "pic4", "pic3", "pic2", "pic5"};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, null);

        ListView listView = (ListView)view.findViewById(R.id.homeList);
        listView.setAdapter(new ImageListAdapter(getActivity(), imageArr));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { //generate info screen

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