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

public class HomeFragment extends Fragment {

    static final String[] images =
            new String[] {"pic1", "pic2"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_home, null);

        //String[] homeItems = {"Test1", "Test2"};

        ListView listView = (ListView)view.findViewById(R.id.homeList);
        listView.setAdapter(new MobileArrayAdapter(getActivity(), images));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent myIntent = new Intent(view.getContext(), Item0.class);
                    startActivity(myIntent);

                }
                if(i == 1){
                    Intent myIntent = new Intent(view.getContext(), Item1.class);
                    startActivity(myIntent);
                }
            }
        });


        return view;
    }
}