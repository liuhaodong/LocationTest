package com.google.haodongl.locationtest.location;

import android.Manifest;
import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class LocationService extends IntentService {

  private FusedLocationProviderClient mFusedLocationClient;

  public LocationService() {
    super("haodong's service");
  }

  @Override
  protected void onHandleIntent(@Nullable Intent intent) {
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling
      //    ActivityCompat#requestPermissions
      // here to request the missing permissions, and then overriding
      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
      //                                          int[] grantResults)
      // to handle the case where the user grants the permission. See the documentation
      // for ActivityCompat#requestPermissions for more details.
//      return;
    }


    this.mFusedLocationClient =
        LocationServices.getFusedLocationProviderClient(getApplicationContext());
    mFusedLocationClient.getLastLocation().addOnCompleteListener(location -> {
      Log.i("location", location.getResult().toString());
    });
    Log.i("location", "success");
  }
}
