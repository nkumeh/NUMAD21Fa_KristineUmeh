package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class HelloWorld extends AppCompatActivity {

    private static final String TAG = "Nnemka's Mobile App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);
        Objects.requireNonNull(getSupportActionBar()).setTitle("nu inc.");
        //make button do things
        //get button
        Button button = (Button) findViewById(R.id.myFirstButton);
        //set what happens to button when clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"My Name and Email");
                Toast.makeText(getApplicationContext(),
                        "Kristine Nnemka Umeh\n" +
                                "umeh.k@northeastern.edu", Toast.LENGTH_SHORT).show();
            }
        });

        Button button2 = (Button) findViewById(R.id.mySecondButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(HelloWorld.this, BackButton.class);
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.myThirdButton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2;
                intent2 = new Intent(HelloWorld.this, RecyclerViewLists.class);
                startActivity(intent2);
            }
        });

        Button button4 = (Button) findViewById(R.id.locationButton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3;
                intent3 = new Intent(HelloWorld.this, LocationActivity.class);
                startActivity(intent3);
            }
        });
    }
}
