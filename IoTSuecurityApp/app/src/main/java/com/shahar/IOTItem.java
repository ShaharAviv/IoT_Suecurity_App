package com.shahar;

import android.widget.ImageView;

import org.json.JSONObject;

public class IOTItem {
    private String name;
    private boolean connected;
    private int photo_id;
    private String start_time;
    private String security_lvl;

    public IOTItem(String name, boolean connected, int id) {
        this.name = name;
        this.connected = connected;
        this.photo_id = id;
    }

    public IOTItem(String name, boolean connected, int photo_id, String start_time, String security_lvl) {
        this.name = name;
        this.connected = connected;
        this.photo_id = photo_id;
        this.start_time = start_time;
        this.security_lvl = security_lvl;
    }

    public String toJSON(){
        JSONObject js = new JSONObject();
        try{
            js.put("name", getName());
            js.put("connected", isConnected());
            js.put("photo_id", getPhotoId());
            js.put("start_time",  getStartTime());
            js.put("security_lvl", getSecurityLvl());
        }catch(Exception e){}
        return js.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setSecurity_lvl(String security_lvl) {
        this.security_lvl = security_lvl;
    }

    public void setId(int id) {photo_id = id;}

    public int getPhotoId(){return photo_id;}

    public String getStartTime(){return start_time;}

    public String getSecurityLvl(){return security_lvl;}
}
