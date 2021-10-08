package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class RecyclerViewLists extends AppCompatActivity implements DialogBox.DialogBoxListener {

    private ArrayList<LinkCard> listOfLinks = new ArrayList<>();

    private RecyclerView rcyclerView;
    private RviewAdapter rviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_links);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                DialogBox dialogBox = new DialogBox();
                dialogBox.show(getSupportFragmentManager(), "Dialogue Box");
            }
        });
    }


    private void init(Bundle savedInstanceState) {
        createRecyclerView();
    }

    private void createRecyclerView() {
        RecyclerView.LayoutManager rLayManager = new LinearLayoutManager(this);

        rcyclerView = findViewById(R.id.recyclerView);
        rcyclerView.setHasFixedSize(true);

        rviewAdapter = new RviewAdapter(listOfLinks);
        LinkClickListener listCLickListener = new LinkClickListener() {
            @Override
            public void clickItem(int position) {
                listOfLinks.get(position).clickItem(position);

                rviewAdapter.notifyItemChanged(position);
            }
        };
        rviewAdapter.setLinkListener(listCLickListener);

        rcyclerView.setAdapter(rviewAdapter);
        rcyclerView.setLayoutManager(rLayManager);
    }

    private void addItem(int position) {

        listOfLinks.add(position, new LinkCard( "No Logo item", "Item id: " + Math.abs(new Random().nextInt(100000)), false));
        Snackbar.make(rcyclerView,"Action Successful",Snackbar.LENGTH_SHORT).show();

        rviewAdapter.notifyItemInserted(position);
    }

    @Override
    public void applyText(String linkName, String linkUrl) {

    }
}