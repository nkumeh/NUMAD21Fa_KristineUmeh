package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        textView = findViewById(R.id.textView);

        Button letter_a = findViewById(R.id.letter_a);
        Button letter_b = findViewById(R.id.letter_b);
        Button letter_c = findViewById(R.id.letter_c);
        Button letter_d = findViewById(R.id.letter_d);
        Button letter_e = findViewById(R.id.letter_e);
        Button letter_f = findViewById(R.id.letter_f);

        letter_a.setOnClickListener(this);
        letter_b.setOnClickListener(this);
        letter_c.setOnClickListener(this);
        letter_d.setOnClickListener(this);
        letter_e.setOnClickListener(this);
        letter_f.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.letter_a:
                textView.setText(R.string.letter_a);
                break;
            case R.id.letter_b:
                textView.setText(R.string.letter_b);
                break;
            case R.id.letter_c:
                textView.setText(R.string.letter_c);
                break;
            case R.id.letter_d:
                textView.setText(R.string.letter_d);
                break;
            case R.id.letter_e:
                textView.setText(R.string.letter_e);
                break;
            case R.id.letter_f:
                textView.setText(R.string.letter_f);
                break;
        }
    }
}