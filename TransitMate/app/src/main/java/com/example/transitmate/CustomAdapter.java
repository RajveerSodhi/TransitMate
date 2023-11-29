package com.example.transitmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<ChatItem> chatList;
    private SelectListener listener;

    public CustomAdapter(Context context, List<ChatItem> chatList, SelectListener listener) {
        this.context = context;
        this.chatList = chatList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.messages_list_item, parent, false);

        return new CustomViewHolder(v);

//        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.messages_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.chatName.setText(chatList.get(position).getName());
        int id = context.getResources().getIdentifier("drawable/" + (chatList.get(position).getImgResource()), null, context.getPackageName());
        holder.chatImg.setImageResource(id);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(chatList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return (chatList != null)? chatList.size(): 0;
    }
}
