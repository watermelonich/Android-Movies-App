package com.example.moviesapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.moviesapp.R;

public class IntroActivity extends AppCompatActivity {
    Button btnGet;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        btnGet = findViewById(R.id.buttonGetIn);
        iv = findViewById(R.id.shapeableImageView);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,LoginActivity.class));
            }
        });
    }
}