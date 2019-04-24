package com.kevin.ad340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    protected Button myButton;

    String toast1 = "Toast 1 Worked!";
    String toast2 = "Toast 2 Worked!";
    String toast3 = "Toast 3 Worked!";
    String toast4 = "Toast 4 Worked!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button)findViewById(R.id.button1);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMovies(v);
            }
        });

        myButton = (Button)findViewById(R.id.button2);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), toast2, Toast.LENGTH_LONG).show();
            }
        });

        myButton = (Button)findViewById(R.id.button3);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), toast3, Toast.LENGTH_LONG).show();
            }
        });

        myButton = (Button)findViewById(R.id.button4);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), toast4, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void displayMovies(View v) {
        Intent intent = new Intent(this, DisplayZombieMovies.class);
        startActivity(intent);
    }
}
