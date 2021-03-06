package com.kevin.ad340;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import com.squareup.picasso.Picasso;


public class MovieDetailActivity extends AppCompatActivity {
    //note that you can pass a stringArray intent message
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();
        //pulling elements values from key on Bundle
        String ImageUrlReceived = bundle.getString("ImageURL");
        String TitleReceived = bundle.getString("Title");
        String YearReceived = bundle.getString("Year");
        String DirectReceived = bundle.getString("Director");
        String DescReceived = bundle .getString("Description");


        //creating layout elements
        ImageView image = (ImageView) findViewById(R.id.LargeMovieImage);
        TextView title = (TextView)findViewById(R.id.movieTitle);
        TextView year = (TextView)findViewById(R.id.movieYear);
        TextView director = (TextView)findViewById(R.id.movieDirector);
        TextView description = (TextView)findViewById(R.id.movieDescription);
        description.setMovementMethod(new ScrollingMovementMethod());

        //setting text variables to the fields

        title.setText(TitleReceived);
        year.setText(YearReceived);
        director.setText(DirectReceived);
        description.setText(DescReceived);
        //setting image URL
        Picasso.get().load(ImageUrlReceived).into(image);
    }
}
