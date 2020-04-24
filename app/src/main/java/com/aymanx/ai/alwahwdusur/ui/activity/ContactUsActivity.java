package com.aymanx.ai.alwahwdusur.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.aymanx.ai.alwahwdusur.R;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        TextView myLink = findViewById(R.id.my_link);
        myLink.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
