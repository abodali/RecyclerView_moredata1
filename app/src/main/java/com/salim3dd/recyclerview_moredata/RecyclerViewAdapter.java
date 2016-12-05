package com.salim3dd.recyclerview_moredata;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int previousPosition = 0;

    private List<List_Item> List_Item;
    private Context context;

    public RecyclerViewAdapter(List<List_Item> list_Item, Context context) {
        List_Item = list_Item;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View menu1 = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.row_item, viewGroup, false);
        return new MenuItemViewHolder(menu1);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;

        menuItemHolder.TextName.setText(List_Item.get(position).getStory());

        Picasso.with(context).load(List_Item.get(position).getImg_link()).into(menuItemHolder.imageView);

        menuItemHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, List_Item.get(position).getStory(), Toast.LENGTH_SHORT).show();

            }
        });


                if (position > previousPosition) { //scrolling DOWN
                    AnimationUtil.animate(menuItemHolder, true);

                } else { // scrolling UP

                    AnimationUtil.animate(menuItemHolder, false);
                }
                previousPosition = position;


    }


    @Override
    public int getItemCount() {
        return (null != List_Item ? List_Item.size() : 0);
    }

    protected class MenuItemViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;
        private TextView TextName;

        public MenuItemViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardView);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            TextName = (TextView) view.findViewById(R.id.TextName);
        }
    }

}
