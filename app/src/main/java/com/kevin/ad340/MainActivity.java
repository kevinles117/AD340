package com.kevin.ad340;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.kevin.ad340.MESSAGE";

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

    /* Toast Method*/
    public void toastMsg(String msg){
        // creating messages for each button
        Toast b = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        b.show();
        Toast c = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        c.show();
        Toast d = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        d.show();
    }

    /* Called when the User taps the send button*/
    public void sendMessage(View view){
        // Do something in response to the button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void displayMovies(View view) {
        Intent intent = new Intent(this, DisplayZombieMovies.class);
        startActivity(intent);
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
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

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
        View rowView = inflater.inflate(R.layout.movie_detail, parent, false);
        TextView titleView = (TextView) rowView.findViewById(R.id.movieTitle);
        TextView yearView = (TextView) rowView.findViewById(R.id.movieYear);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.LargeMovieImage);
        titleView.setText(values[position][0]);
        yearView.setText(values[position][1]);

        return rowView;
    }
}
