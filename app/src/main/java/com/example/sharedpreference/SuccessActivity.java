package com.example.sharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {

    private SharedPreferencesConfig PreferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        PreferenceConfig=new SharedPreferencesConfig(getApplicationContext());
    }

    public void logout(View view) {
        PreferenceConfig.writeLoginStatus(false);
        startActivity(new Intent(this,MainActivity.class));
    }
}
