package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Nnemka's Mobile App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    }
}
