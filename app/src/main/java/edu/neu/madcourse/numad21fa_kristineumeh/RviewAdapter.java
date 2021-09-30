package edu.neu.madcourse.numad21fa_kristineumeh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RviewAdapter extends RecyclerView.Adapter<RviewHolder>{
    private final ArrayList<LinkCard> listOfLinks;
    private LinkClickListener linkListener;

    public RviewAdapter(ArrayList<LinkCard> listOfLinks) {
        this.listOfLinks = listOfLinks;
    }

    public void setLinkListener(LinkClickListener linkListener) {
        this.linkListener = linkListener;
    }

    @NonNull
    @Override
    public RviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_card, parent, false);
        return new RviewHolder(view, linkListener);
    }

    @Override
    public void onBindViewHolder(RviewHolder holder, int position) {
        LinkCard currentLink = listOfLinks.get(position);

        holder.linkName.setText(currentLink.getLinkName());
        holder.linkUrl.setText(currentLink.getLinkUrl());
    }

    @Override
    public int getItemCount() {
        return listOfLinks.size();
    }

}
