package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
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

public class RecyclerViewLists extends AppCompatActivity implements DialogBox.DialogueBoxListener {

    private ArrayList<LinkCard> listOfLinks = new ArrayList<>();

    private RecyclerView recyclerView;
    private RviewAdapter rviewAdapter;
    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_links);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        constraintLayout = findViewById(R.id.constraintLayout);

        FloatingActionButton fab = findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                DialogBox dialogBox = new DialogBox();
                dialogBox.show(getSupportFragmentManager(), "Dialogue Box");;
            }
        });
    }


    public void snackBar() {
        Snackbar snackbar = Snackbar.make(constraintLayout, "Action Successful", Snackbar.LENGTH_SHORT);
        snackbar.show();

    }

    private void init(Bundle savedInstanceState) {
        createRecyclerView();
    }

    private void createRecyclerView() {
        RecyclerView.LayoutManager rLayManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        rviewAdapter = new RviewAdapter(listOfLinks);
        LinkClickListener listCLickListener = new LinkClickListener() {
            @Override
            public void clickItem(int position) {
                listOfLinks.get(position).clickItem(position);

                rviewAdapter.notifyItemChanged(position);
            }
        };
        rviewAdapter.setLinkListener(listCLickListener);

        recyclerView.setAdapter(rviewAdapter);
        recyclerView.setLayoutManager(rLayManager);
    }

    private void addItem(int position) {

        listOfLinks.add(position, new LinkCard( "No Logo item", "Item id: " + Math.abs(new Random().nextInt(100000)), false));
        Snackbar.make(recyclerView,"Action Successful",Snackbar.LENGTH_SHORT).show();

        rviewAdapter.notifyItemInserted(position);
    }

    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        }

    });

    @Override
    public void applyText(String linkName, String linkUrl) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}