package com.aymanx.ai.alwahwdusur.ui.activity;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.aymanx.ai.alwahwdusur.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    Animation upToDownAnimation;
    Animation myTransitionAnimation;
    TextView title;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        title = findViewById(R.id.title);
        upToDownAnimation = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        title.setAnimation(upToDownAnimation);
        img = findViewById(R.id.splash_id);
        myTransitionAnimation = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        title.setAnimation(myTransitionAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, WelcomeActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}
