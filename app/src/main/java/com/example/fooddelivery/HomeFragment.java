package com.example.fooddelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private RecyclerView mRecycleview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<FoodList> foodList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_menu, container, false);


        mRecycleview =  view.findViewById(R.id.recycler_fooditem);
        mRecycleview.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new FoodItemAdapter(foodList);

        mRecycleview.setLayoutManager(mLayoutManager);
        mRecycleview.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        foodList = new ArrayList<>();
        foodList.add(new FoodList(R.drawable.ic_add_item,"Food item 1"));
        foodList.add(new FoodList(R.drawable.ic_add_item,"Food item 2"));
        foodList.add(new FoodList(R.drawable.ic_add_item,"Food item 3"));


    }


}
