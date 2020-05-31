package com.shahar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<IOTItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView rec_view = (RecyclerView) findViewById(R.id.rec_view);

        items = new ArrayList<IOTItem>(); // stores all the IOT items that will be displayed in the list
        ItemAdapter iAdapter = new ItemAdapter(items); // handles the list view

        rec_view.setAdapter(iAdapter);
        rec_view.setLayoutManager(new LinearLayoutManager(this));


        //Ex. of adding 3 items to the view
        items.add(new IOTItem("Refrigirator", true, R.drawable.refri, "26/6/19", "High"));
        items.add(new IOTItem("Lamp", false, R.drawable.lamp2, "5/2/20", "Low"));
        items.add(new IOTItem("TV", false, R.drawable.tv2, "20/5/15", "High"));


        //Get widgets reference from XML layout
        final TextView tView = (TextView) findViewById(R.id.tv);
        Switch sButton = (Switch) findViewById(R.id.switch_btn);

        //Set a CheckedChange Listener for Switch Button
        sButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean on){
                if(on)
                {
                    //Do something when Switch button is on/checked
                    tView.setText("Connected to the base");
                }
                else
                {
                    //Do something when Switch is off/unchecked
                    tView.setText("Disconnected");
                }
            }
        });


    }
}
