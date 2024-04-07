package com.example.moviesapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviesapp.R;


public class Movies_AdminPanel extends AppCompatActivity {
    EditText name,desc,rating,duration;
    String n,d,r,dur;
    Database db = new Database(getApplicationContext(),null);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_admin_panel);
        name = (EditText) findViewById(R.id.MovName);
        desc = (EditText) findViewById(R.id.MovDesc);
        rating = (EditText) findViewById(R.id.MovRating);
        duration = (EditText) findViewById(R.id.MovDuration);
    }

    public void onMoviesAdd(View view){
        n = name.getText().toString();
        d = desc.getText().toString();
        r = rating.getText().toString();
        dur = duration.getText().toString();

        db.addMovie(n,d,r,dur);

    }
}