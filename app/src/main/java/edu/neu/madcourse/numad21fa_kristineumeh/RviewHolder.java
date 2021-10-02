package edu.neu.madcourse.numad21fa_kristineumeh;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RviewHolder extends RecyclerView.ViewHolder {

    public TextView linkName;
    public TextView linkUrl;


    public RviewHolder(View linkView, final LinkClickListener linkListener ) {
        super(linkView);
        linkName = linkView.findViewById(R.id.linkName);
        linkUrl = linkView.findViewById(R.id.linkUrl);

        linkView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (linkListener != null){
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION){
                        linkListener.clickItem(position);
                    }
                }
            }
        });

    }
}
