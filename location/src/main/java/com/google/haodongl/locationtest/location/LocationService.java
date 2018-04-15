package com.google.haodongl.locationtest.location;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class LocationService extends IntentService {

    public LocationService(){
        super("haodong's service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String data = intent.getDataString();
        Log.i("location", data);
        System.exit(0);
    }
}
