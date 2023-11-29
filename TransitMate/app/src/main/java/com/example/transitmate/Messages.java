package com.example.transitmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Messages extends Fragment implements SelectListener {
    RecyclerView recyclerView;
    List<ChatItem> chatList;
    CustomAdapter customAdapter;

    public Messages() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        displayItems();

        return view;
    }

    private void displayItems() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 1));
        chatList = new ArrayList<>();

        chatList.add(new ChatItem("Rio Asher", "lenny"));
        chatList.add(new ChatItem("Marlin Kutler", "marlin"));

        customAdapter = new CustomAdapter(this.getActivity(), chatList, this);
        recyclerView.setAdapter(customAdapter);

    }

    @Override
    public void onItemClicked(ChatItem chatItem) {
        startActivity(new Intent(this.getActivity(), ChatActivity.class));
    }
}