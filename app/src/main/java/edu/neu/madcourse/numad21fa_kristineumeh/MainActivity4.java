package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity4 extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        constraintLayout = findViewById(R.id.constraintLayout);
        fab = findViewById(R.id.fab1);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackBar();
            }
        });
    }

    public void snackBar() {
        Snackbar snackbar = Snackbar.make(constraintLayout,"You have added a link",Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}