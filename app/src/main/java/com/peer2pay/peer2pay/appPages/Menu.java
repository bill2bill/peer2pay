package com.peer2pay.peer2pay.appPages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.peer2pay.peer2pay.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void pay(View view){
        Intent pay_intent = new Intent(this, Pay.class);
        startActivity(pay_intent);
    }

    public void receive(View view){
        Intent receive_intent = new Intent(this, Receive.class);
        startActivity(receive_intent);
    }

    public void cards(View view){
        Intent cards_intent = new Intent(this, ConfigureCards.class);
        startActivity(cards_intent);
    }
}
