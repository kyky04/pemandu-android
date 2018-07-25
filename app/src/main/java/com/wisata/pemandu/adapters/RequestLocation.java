package com.wisata.pemandu.adapters;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.wisata.pemandu.R;

import io.reactivex.annotations.NonNull;

public class RequestLocation extends AppCompatActivity {
    private static final String TAG = RequestLocation.class.getSimpleName();
    private static final int REQUEST_LOCATION_PERMISSION = 34;
    private FusedLocationProviderClient mFusedLocationClient;


    protected Location mLastLocation;


    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        } else {
            Log.d(TAG, "getLocation: permissions granted");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                // If the permission is granted, get the location,
                // otherwise, show a Toast
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    Toast.makeText(this,
                            R.string.permission_denied_explanation,
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

//    mFusedLocationClient.getLastLocation().addOnSuccessListener(
//      new OnSuccessListener<Location>() {
//        @Override
//        public void onSuccess(Location location) {
//            if (location != null) {
//                mLastLocation = location;
//                mLocationTextView.setText(
//                        getString(R.string.location_text,
//                                mLastLocation.getLatitude(),
//                                mLastLocation.getLongitude(),
//                                mLastLocation.getTime()));
//            } else {
//                mLocationTextView.setText(R.string.no_location);
//            }
//        }
}
