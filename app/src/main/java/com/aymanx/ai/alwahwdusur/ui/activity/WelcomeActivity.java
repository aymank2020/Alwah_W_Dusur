package com.aymanx.ai.alwahwdusur.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aymanx.ai.alwahwdusur.R;

public class WelcomeActivity extends AppCompatActivity
                                    implements View.OnClickListener {

    Button loginButton, registerButton,learmMoreButton , loginByGmailButton;
    EditText emailET,passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //TextView
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        //Button
        loginButton         = findViewById(R.id.login_btn);
        loginByGmailButton  = findViewById(R.id.login_using_gmail_btn);
        registerButton      = findViewById(R.id.join_us);
        learmMoreButton     = findViewById(R.id.learn_more);
        //OnClickListener
        loginButton.setOnClickListener(this);
        loginByGmailButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        learmMoreButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.login_btn:
                //write a Code
                startActivity(new Intent(this,CategoryActivity.class));
                break;
            case  R.id.login_using_gmail_btn:
                //write a Code
                startActivity(new Intent(this,CategoryActivity.class));
                break;
            case  R.id.join_us:
                //write a Code
                startActivity(new Intent(this,RegistrationActivity.class));
                break;
            case  R.id.learn_more:
                //write a Code
                startActivity(new Intent(this,ContactUsActivity.class));
                break;
        }

    }
}
