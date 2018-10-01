package com.peer2pay.peer2pay.helperClasses.utils;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peer2pay.peer2pay.R;
import com.peer2pay.peer2pay.helperClasses.objects.Card;
import com.peer2pay.peer2pay.helperClasses.utils.parser.CardParser;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;
    private CardParser cardParser;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView cardView;
        public ViewHolder(View v) {
            super(v);
            cardView = v.findViewById(R.id.card_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);
        //...
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element set your dataset at this position
        // - replace the contents of the view with that element
        String cardData = mDataset[position];
        Card card = cardParser.parseCard(cardData);
        TextView id = holder.cardView.findViewById(R.id.id);
        TextView cardNumber = holder.cardView.findViewById(R.id.card_number_last_four);
        TextView expire = holder.cardView.findViewById(R.id.expire);

        //set values
        id.setText(card.getId());
        cardNumber.setText("#### #### #### 3456");
        expire.setText(card.getExpiration());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}