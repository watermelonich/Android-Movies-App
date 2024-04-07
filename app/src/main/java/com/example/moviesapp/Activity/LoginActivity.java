package com.example.moviesapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviesapp.R;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername,edPassword;
    Button BtnLogin;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.eLoginUsername);
        edPassword = findViewById(R.id.eLoginPassword);
        BtnLogin = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewRegister);

//        BtnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    public void onLogin(View view){
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        Database db = new Database(getApplicationContext(),null);
        if(username.length() == 0 || password.length() == 0){
            Toast.makeText(getApplicationContext(),"Please fill all the details",Toast.LENGTH_SHORT).show();
        }
        else{
            System.out.println(db.login(username,password));
            if(db.login(username,password) == 1){
                Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("username",username);
                //to save our data with key and value
                editor.apply();
                Intent intent = new Intent(LoginActivity.this,MovieActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(),"Invalid username and password",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onRegister(View view){
//        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        startActivity(new Intent(LoginActivity.this,Movies_AdminPanel.class));
    }
}