package com.example.arthouseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    String[] users = {"User1", "User2"};
    String[] passwords = {"Pass1", "Pass2"};
    int userIndex = 0;
    static TextView tryAgain;
    EditText uText;
    EditText pText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ProfileFragment.loggedIn){
            finish();
        }


        uText = (EditText) findViewById(R.id.userText);
        pText = (EditText) findViewById(R.id.passText);


        tryAgain = (TextView) findViewById(R.id.tryAgainText);


        Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ProfileFragment.loggedIn){
                    finish();
                }
                else{
                    if(tryLogin(uText.getText().toString(), pText.getText().toString())){
                        ProfileFragment.loggedIn = true;
                        ProfileFragment.userIndex = userIndex;
                        finish();
                    }else {
                        tryAgain.setText("Try Again");
                    }
                }
            }
        });
    }

    protected boolean tryLogin(String uInput, String pInput){
        for(int i = 0; i < users.length; i++){
            if(users[i].toLowerCase().equals(uInput.toLowerCase())){
                userIndex = i;
                if(pInput.equals(passwords[userIndex])){
                    return true;
                }
            }

        }


        return false;
    }
}
