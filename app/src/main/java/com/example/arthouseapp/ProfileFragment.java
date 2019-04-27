package com.example.arthouseapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends Fragment { //hardcoded profiles just to test it out as a proof of concept

    static boolean loggedIn = false;
    static int userIndex = 0;
    static String[] userBio = {"", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio"};
    static int[] numOfArtworkOwned = {0, 13};
    static int[] activeBids = {0, 3};
    static String[] location = {"", "Rochester"};
    EditText bioBox;
    EditText locBox;
    TextView numArtwork;
    TextView numBids;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, null);

        if(!loggedIn){
            Intent myIntent = new Intent(view.getContext(), Login.class);
            startActivity(myIntent);
        }

        bioBox = (EditText) view.findViewById(R.id.bioText);
        locBox = (EditText) view.findViewById(R.id.location);

        bioBox.setText(userBio[userIndex], TextView.BufferType.EDITABLE);
        locBox.setText(location[userIndex], TextView.BufferType.EDITABLE);

        userBio[userIndex] = bioBox.getText().toString();
        location[userIndex] = locBox.getText().toString();

        numArtwork = (TextView) view.findViewById(R.id.numArtwork);
        numBids = (TextView) view.findViewById(R.id.numBids);

        numArtwork.setText("Artworks Owned: "+numOfArtworkOwned[userIndex]+"");
        numBids.setText("Active Bids: "+activeBids[userIndex]+"");





        return view;
    }
}