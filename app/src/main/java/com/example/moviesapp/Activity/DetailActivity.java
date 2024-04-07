package com.example.moviesapp.Activity;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moviesapp.R;

public class DetailActivity extends AppCompatActivity {

    ImageView arrowBack,addFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        arrowBack = findViewById(R.id.arrowBack);
        addFav = findViewById(R.id.addFav);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this,MovieActivity.class);
                startActivity(intent);
            }
        });

        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Added to favourites", LENGTH_SHORT).show();
            }
        });
    }
}