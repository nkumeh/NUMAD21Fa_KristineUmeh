package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button letter_a = findViewById(R.id.letter_a);
        Button letter_b = findViewById(R.id.letter_b);
        Button letter_c = findViewById(R.id.letter_c);
        Button letter_d = findViewById(R.id.letter_d);
        Button letter_e = findViewById(R.id.letter_e);
        Button letter_f = findViewById(R.id.letter_f);

        letter_a.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}