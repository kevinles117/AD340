package com.kevin.ad340;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.kevin.ad340.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
