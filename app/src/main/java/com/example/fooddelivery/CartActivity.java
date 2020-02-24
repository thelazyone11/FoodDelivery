package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private RecyclerView cartRecyclerView;
    private RecyclerView.Adapter cartAdapter;
    private RecyclerView.LayoutManager cartLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ImageView backCartToHome = findViewById(R.id.backCartToHome);

        Button checkOutButton = findViewById(R.id.btnPlaceOrder);

        backCartToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dialog to confire Order
                ViewDialog alert = new ViewDialog();
                alert.showDialog(CartActivity.this, "Confire Your Order?");
            }
        });


        ArrayList<CartList>  cartList = new ArrayList<>();
        cartList.add(new CartList("Food item 1"));
        cartList.add(new CartList("Food item 2"));
        cartList.add(new CartList("Food item 3"));

        cartRecyclerView =  findViewById(R.id.cart_Recycler);
        cartRecyclerView.setHasFixedSize(true);
        cartLayoutManager = new LinearLayoutManager(this);
        cartAdapter = new CartItemAdapter(cartList);
        cartRecyclerView.setLayoutManager(cartLayoutManager);
        cartRecyclerView.setAdapter(cartAdapter);


    }
    public class ViewDialog {

        public void showDialog(Activity activity, String msg){
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.order_confire_dialog_layout);

            TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
            text.setText(msg);

            Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog_cancle);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            Button dialogButton2 =dialog.findViewById(R.id.btn_dialog_ok);
            dialogButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CartActivity.this,OrderStatusActivity.class);
                    startActivity(intent);
                }
            });

            dialog.show();

        }
    }
}
