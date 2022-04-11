package com.example.datastorage.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datastorage.R;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        usernameEdit = (EditText) findViewById(R.id.Username);
        passwordEdit = (EditText) findViewById(R.id.Password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button) findViewById(R.id.Login);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if(isRemember){
            String username = pref.getString("username", "");
            String password = pref.getString("password", "");
            usernameEdit.setText(username);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ((EditText) findViewById(R.id.Username)).getText().toString();
                String password = ((EditText) findViewById(R.id.Password)).getText().toString();
                if(username.equals("admin")&&password.equals("admin")){
                    editor = pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("remember_password", true);
                        editor.putString("username", username);
                        editor.putString("password", password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "username or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}