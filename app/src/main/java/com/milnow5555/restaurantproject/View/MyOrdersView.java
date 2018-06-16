package com.milnow5555.restaurantproject.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.milnow5555.restaurantproject.Adapter.MealAdapter;
import com.milnow5555.restaurantproject.Dish;
import com.milnow5555.restaurantproject.Order;
import com.milnow5555.restaurantproject.R;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersView extends AppCompatActivity {

    private MyMealsView MM;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Order orderItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adapter = new MealAdapter(Order._dishes,this);
        recyclerView.setAdapter(adapter);
    }



}
