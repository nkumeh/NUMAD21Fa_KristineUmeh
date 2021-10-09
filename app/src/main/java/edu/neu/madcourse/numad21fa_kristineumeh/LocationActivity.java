package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class LocationActivity extends AppCompatActivity {

    Button locationButton;
    TextView tv1, tv2;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        locationButton = findViewById(R.id.locationButton);
        tv1 = findViewById(R.id.showLongitude);
        tv2 = findViewById(R.id.showLatitude);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(
                        LocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(LocationActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
    }

    private void getLocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new onCompleteListener<Location>(){
            @Override
                public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if(location != null){
                    Geocoder geocoder = new Geocoder(LocationActivity.this, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1);

                        tv1.setText(Html.fromHtml("<font color='#black'><b>Latitude:" +
                                "</b><br></font" + addresses.get(0).getLatitude()));
                        tv2.setText(Html.fromHtml("<font color='#black'><b>Longitude:" +
                                "</b><br></font" + addresses.get(0).getLongitude()));

                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}