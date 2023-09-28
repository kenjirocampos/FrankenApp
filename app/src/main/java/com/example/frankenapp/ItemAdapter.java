package com.example.frankenapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewFolder>{
    private List<Item> ItemList;
    private Context context;

    public ItemAdapter(Context context){this.context = context;}
    public void setData(List<Item> itemList){
        this.ItemList = itemList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewFolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull ItemViewFolder holder, int position) {
        Item item = ItemList.get(position);
        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float estrellas, boolean usuario) {
               item.setEstrellas(estrellas);
            }
        });
        holder.textView.setText(item.getTitulo());
    }
    @Override
    public int getItemCount() {
        return ItemList.size();
    }
    class ItemViewFolder extends RecyclerView.ViewHolder{
        RatingBar ratingBar;
        TextView textView;
        public ItemViewFolder(@NonNull View itemView) {
            super(itemView);
            ratingBar = itemView.findViewById(R.id.ratBar1);
            textView = itemView.findViewById(R.id.txtTitulo);
        }
    }
    public List<Item> getItemList() {
        return ItemList;
    }
}
