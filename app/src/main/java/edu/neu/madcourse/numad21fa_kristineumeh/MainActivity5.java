package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity5 extends AppCompatActivity {
    private ArrayList<LinkCard> listOfLinks = new ArrayList<>();

    private RecyclerView recyclerView;
    private RviewAdapter rviewAdapter;
    private RecyclerView.LayoutManager rLayManager;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_LINKS = "NUMBER_OF_LINKS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        init(savedInstanceState);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });

    }

    private void init(Bundle savedInstanceState) {
        initialLinkData(savedInstanceState);
        createRecyclerView();
    }

    private void createRecyclerView() {
        rLayManager = new LinearLayoutManager(this);

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

    private void initialLinkData(Bundle savedInstanceState) {
        LinkCard link1 = new LinkCard("Gmail", "Example description", false);
        listOfLinks.add(link1);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        int size = listOfLinks == null ? 0 : listOfLinks.size();
        outState.putInt(NUMBER_OF_LINKS, size);

    }

    private void addItem(int position) {
        listOfLinks.add(position, new LinkCard( "No Logo item", "Item id: " + Math.abs(new Random().nextInt(100000)), false));
        Snackbar.make(recyclerView,"Action Successful",Snackbar.LENGTH_SHORT).show();

        rviewAdapter.notifyItemInserted(position);
    }

}