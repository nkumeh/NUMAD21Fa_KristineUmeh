package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button let_a = findViewById(R.id.letter_a);
        Button let_b = findViewById(R.id.letter_b);
        Button let_c = findViewById(R.id.letter_c);
        Button let_d = findViewById(R.id.letter_d);
        Button let_e = findViewById(R.id.letter_e);
        Button let_f = findViewById(R.id.letter_f);

        let_a.setOnClickListener(this) ;
        let_b.setOnClickListener(this);
        let_c.setOnClickListener(this);
        let_d.setOnClickListener(this);
        let_e.setOnClickListener(this);
        let_f.setOnClickListener(this);

        textView = findViewById(R.id.pressed);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.letter_a:
                textView.setText(R.string.clickA);
                break;
            case R.id.letter_b:
                textView.setText(R.string.clickB);
                break;
            case R.id.letter_c:
                textView.setText(R.string.clickC);
                break;
            case R.id.letter_d:
                textView.setText(R.string.clickD);
                break;
            case R.id.letter_e:
                textView.setText(R.string.clickE);
                break;
            case R.id.letter_f:
                textView.setText(R.string.clickF);
                break;
            default:
                textView.setText(R.string.pressed);
                break;
        }
    }
}