package com.peer2pay.peer2pay.appPages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.peer2pay.peer2pay.helperClasses.management.CardManagement;
import com.peer2pay.peer2pay.helperClasses.management.FileManagement;
import com.peer2pay.peer2pay.helperClasses.MyAdapter;
import com.peer2pay.peer2pay.R;

import java.util.Map;

public class Cards extends AppCompatActivity {
    CardManagement cardManagement;
    MyAdapter mAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        mRecyclerView = findViewById(R.id.recyclerView);

        //Get list of stored cards
        cardManagement = new CardManagement(getApplicationContext());
        Map<String, ?> cards = cardManagement.getAllCards();
        String[] data = cards.values().toArray(new String[0]);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void add_card(View view){
        Intent add_card_intent = new Intent(this, AddCard.class);
        startActivity(add_card_intent);
    }
}
