package com.example.android.test_category;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class main_category extends AppCompatActivity {

    private FusedLocationProviderClient clint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category);

        clint = LocationServices.getFusedLocationProviderClient(this);

        Button get = findViewById(R.id.get);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(main_category.this, ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                clint.getLastLocation().addOnSuccessListener(main_category.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if(location!=null){
                            TextView put=findViewById(R.id.put);
                            put.setText(location.toString());

                        }
                    }
                });
            }
        });
    }

    private void requestpermissin(){
        ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION},1);
    }
}
