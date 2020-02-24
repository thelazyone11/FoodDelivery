package com.example.fooddelivery.recycle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;

import java.util.ArrayList;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartViewHolder> {
    private ArrayList<CartList> cCartList;

    public static class CartViewHolder extends RecyclerView.ViewHolder{

        public TextView cTextView1;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cTextView1 = itemView.findViewById(R.id.addItemCart);
        }}

    public CartItemAdapter(ArrayList<CartList> cartList){ cCartList = cartList; }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_food_item_layout,parent,false);
        CartViewHolder cvh = new CartViewHolder(v);
        return cvh;

    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartList currentitem = cCartList.get(position);

        holder.cTextView1.setText(currentitem.getcText1());
    }

    @Override
    public int getItemCount() {
        return cCartList.size();
    }





}
