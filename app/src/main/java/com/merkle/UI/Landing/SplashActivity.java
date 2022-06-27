package com.merkle.UI.Landing;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.merkle.R;
import com.merkle.UI.Main.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedprefs = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        String username = sharedprefs.getString("username", null);
        String password = sharedprefs.getString("password", null);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username != null && password != null) {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }
        }, 2000);
    }

    @Override
    public void onBackPressed() {

    }
}
