package com.example.formulaone.recycleagain;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by chetan_rane on 5/31/2017.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder> {

    private final List<Source> sources;

    ChannelAdapter(List<Source> sources) {
        this.sources = sources;
    }

    @Override
    public int getItemCount(){
        return this.sources.size();
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_channel_card, viewGroup, false);
        ChannelViewHolder channelViewHolder = new ChannelViewHolder(view);
        return channelViewHolder;
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder channelViewHolder, int i) {
        channelViewHolder.channelTitle.setText(sources.get(i).getName());
        channelViewHolder.channelCategory.setText(sources.get(i).getCategory());
        channelViewHolder.channelDesc.setText(sources.get(i).getDescription());
        channelViewHolder.channelURL.setText(sources.get(i).getUrl());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder{
        CardView channelCardView;
        TextView channelTitle, channelCategory, channelURL, channelDesc;

        ChannelViewHolder(View itemView) {
            super(itemView);

            channelCardView = (CardView) itemView.findViewById(R.id.channelCardView);
            channelTitle = (TextView) itemView.findViewById(R.id.channelTitle);
            channelCategory = (TextView) itemView.findViewById(R.id.channelCategory);
            channelURL = (TextView) itemView.findViewById(R.id.channelURL);
            channelDesc = (TextView) itemView.findViewById(R.id.channelDesc);

        }
    }
}

