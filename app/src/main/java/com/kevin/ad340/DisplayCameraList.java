package com.kevin.ad340;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DisplayCameraList extends AppCompatActivity {
    ArrayList<String> cameraNames;
    ArrayList<String> cameraImages;
    String[][] cameras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        get_json();
        setContentView(R.layout.activity_displaycameralist);
        /*ImageView imageView = findViewById(R.id.movieImage);*/

        ListAdapter myAdapter = new listOfCameras(this, cameraNames);
        ListView myView = (ListView) findViewById(R.id.listViewCameras);
        myView.setAdapter(myAdapter);

        myView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                                           @Override
                                           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                               Intent intent = new Intent(DisplayCameraList.this, CameraDetailActivity.class);
                                               startActivity(intent);
                                           }
                                       }
        );
    }

    public void get_json() {
        String json;
        try {
            InputStream is = getAssets().open("traffic_cameras_merged.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                cameraNames.add(obj.getString("cameralabel"));
                if(TextUtils.isEmpty(obj.getString("imageurl"))) {
                    cameraImages.add(null);
                } else {
                    cameraImages.add(obj.getString("imageurl"));
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
