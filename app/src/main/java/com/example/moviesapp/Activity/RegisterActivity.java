package com.example.moviesapp.Activity;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviesapp.R;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edPassword,edEmail,edConfirm;
    Button BtnRegister;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.eRegisterUsername);
        edPassword = findViewById(R.id.eRegisterPassword);
        edEmail = findViewById(R.id.eRegisterEmail);
        edConfirm = findViewById(R.id.eRegisterConfPassword);
        BtnRegister = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),null);

                if(username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0){
                    Toast.makeText(getApplicationContext(),"Please fill all the details", LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm) == 0){
                        if(isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Registered successfully",LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class) );
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Password must contain atleast 8 characters having letter,digit and special symbol",LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password and Confirm Password didn't match", LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String passwordhere){
        int f1 = 0,f2 = 0,f3 = 0;
        if(passwordhere.length() < 8){
            return false;
        }
        else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }

            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }

            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c > 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }

            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}