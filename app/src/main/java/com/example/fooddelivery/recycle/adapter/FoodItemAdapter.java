package com.example.fooddelivery.recycle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;

import java.util.ArrayList;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodViewHolder> {
    private ArrayList<FoodList> mFoodList;

    public static class FoodViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.addItemButton);
            mTextView1 = itemView.findViewById(R.id.foodItemName);
        }}

    public FoodItemAdapter(ArrayList<FoodList> foodList){ mFoodList = foodList; }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_layout,parent,false);
        FoodViewHolder fvh = new FoodViewHolder(v);
        return fvh;

    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodList currentitem = mFoodList.get(position);

        holder.mImageView.setImageResource(currentitem.getmImageResource());
        holder.mTextView1.setText(currentitem.getmText1());
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }





}
