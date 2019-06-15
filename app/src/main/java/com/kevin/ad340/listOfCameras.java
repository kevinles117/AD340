package com.kevin.ad340;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class listOfCameras extends ArrayAdapter<String[]> {
    private final Context context;
    private final ArrayList<String> cameraNames;
    private final ArrayList<String> cameraImages;


    public listOfCameras(Context context, ArrayList<String> cameraNames, ArrayList<String> cameraImages) {
        super(context, R.layout.list_of_movies, (List<String[]>) cameraNames, (List<String[]>) cameraImages);
        this.context = context;
        this.cameraNames = cameraNames;
        this.cameraImages = cameraImages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.list_of_movies, parent, false);

        /*String[] movie = getItem(position);*/
        TextView movieTitle = (TextView) customView.findViewById(R.id.movieTitle);
        /*movieTitle.setText(movies[position][0]);

        TextView movieYear = (TextView) customView.findViewById(R.id.movieYear);
        movieYear.setText(movies[position][1]);

        ImageView movieImage = (ImageView) customView.findViewById(R.id.movieImage);

        Picasso p = Picasso.get();
        p.setIndicatorsEnabled(true);
        p.setLoggingEnabled(true);
        p.load(movies[position][3]).into(movieImage);*/

        return customView;

    }
}
