package com.shahar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class IoT_Device extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot);

        ImageView img = findViewById(R.id.iot_img);
        TextView bigtxt = findViewById(R.id.big_txt);
        TextView txt1 = findViewById(R.id.txt1);
        TextView txt2 = findViewById(R.id.txt2);
        TextView txt3 = findViewById(R.id.txt3);

        try{
            JSONObject item = new JSONObject(getIntent().getExtras().getString("JSON")); // gets the IOT item as JSON
            //sets all the view components to the JSON values
            img.setImageResource(item.getInt("photo_id"));
            bigtxt.setText(item.getString("name"));
            String conn = item.getBoolean("connected") ? "Connected" : "Not Connected";
            txt1.setText("Status: " + conn);
            txt2.setText("Start time: " + item.getString("start_time"));
            txt3.setText("Security Level: " + item.getString("security_lvl"));
        }catch(Exception e) {}
    }
}
