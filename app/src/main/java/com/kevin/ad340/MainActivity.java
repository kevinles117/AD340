package com.kevin.ad340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about_app:
                Intent E = new Intent(MainActivity.this, About.class);

                startActivity(E);
                //Toast.makeText(this,"item 1 selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void displayMovies(View v) {
        Intent intent = new Intent(this, DisplayZombieMovies.class);
        startActivity(intent);
    }

}


class MySimpleArrayAdapter extends ArrayAdapter<String[]> {
    private final Context context;
    private final String[][] values;

    public MySimpleArrayAdapter(Context context, String[][] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.movierow, parent, false);
        TextView titleView = (TextView) rowView.findViewById(R.id.movieTitle);
        TextView yearView = (TextView) rowView.findViewById(R.id.yearTitle);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageMovie);
        titleView.setText(values[position][0]);
        yearView.setText(values[position][1]);
        // change the icon for Windows and iPhone
        //String s = values[position];
        //if (s.startsWith("iPhone")) {
        //    imageView.setImageResource(R.drawable.no);
        //} else {
        //    imageView.setImageResource(R.drawable.ok);
        //}

        return rowView;
    }


}