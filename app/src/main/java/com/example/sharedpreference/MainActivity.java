package com.example.sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private SharedPreferencesConfig PreferencesConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Hello toast", Toast.LENGTH_SHORT).show();

        PreferencesConfig = new SharedPreferencesConfig(getApplicationContext());

        username = findViewById(R.id.edit_1);
        password = findViewById(R.id.edit_2);

        if (PreferencesConfig.readLoginStatus()) {
            startActivity(new Intent(this, SuccessActivity.class));
            finish();
        }
    }

    public void login(View view) {
        String Username = username.getText().toString();
        String Password = password.getText().toString();
        if (Username.equals(getResources().getString(R.string.User_name)) && Password.equals(getResources().getString(R.string.Pass_word))) {
            startActivity(new Intent(this, SuccessActivity.class));
            PreferencesConfig.writeLoginStatus(true);
            finish();
        } else {
            Toast.makeText(this, "Login failed...Try again", Toast.LENGTH_SHORT).show();
            ;
            username.setText("");
            password.setText("");
        }
    }
}
