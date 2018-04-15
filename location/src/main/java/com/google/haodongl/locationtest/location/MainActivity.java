package com.google.haodongl.locationtest.location;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ActivityCompat.requestPermissions(this, new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 1);

    Button startButton = findViewById(R.id.button);
    startButton.setOnClickListener(
        (v) -> {
          Log.i("main_activity", "test message");
          startLocationService();
        });
  }

  private void startLocationService() {
    Intent locationServiceIntent = new Intent(this.getApplicationContext(), LocationService.class);
    locationServiceIntent.setData(Uri.EMPTY);
    getApplicationContext().startService(locationServiceIntent);
  }

  @Override
  protected void onStart() {
    super.onStart();
  }
}
