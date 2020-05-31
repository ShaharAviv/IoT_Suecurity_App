package com.shahar;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public TextView txt;
        public ImageView img, connImg;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            itemView.setOnClickListener(this);
            //creates a new item in the list (text - image - text)
            txt = (TextView) itemView.findViewById(R.id.contact_name);
            img = (ImageView) itemView.findViewById(R.id.item_img);
            connImg = (ImageView) itemView.findViewById(R.id.conn_img);
        }

        public void onClick(View v){
            //Toast.makeText(v.getContext(), "clicked: " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            moveToActivity(v, getLayoutPosition());
        }

        //---------new code----------




    }

    private List<IOTItem> mItems;

    public void moveToActivity(View v, int pos){
        Intent i = new Intent(v.getContext(), IoT_Device.class);
        i.putExtra("JSON", mItems.get(pos).toJSON()); // sending the JSON data to the new Activity
        v.getContext().startActivity(i);
    }

    public ItemAdapter(List<IOTItem> items){
        mItems = items;
    }

    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        IOTItem contact = mItems.get(position);

        // Set item views based on your views and data model

        TextView textView = viewHolder.txt;
        ImageView img = viewHolder.img;
        ImageView connImg = viewHolder.connImg;


        textView.setText(contact.getName());
        img.setImageResource(contact.getPhotoId());

        int id_conn;
        if(contact.isConnected()){
            id_conn = R.drawable.green_dot;
        }else{
            id_conn = R.drawable.red_dot;
        }
        connImg.setImageResource(id_conn);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
