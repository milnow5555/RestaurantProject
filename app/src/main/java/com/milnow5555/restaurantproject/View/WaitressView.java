package com.milnow5555.restaurantproject.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.milnow5555.restaurantproject.Adapter.WaitressAdapter;
import com.milnow5555.restaurantproject.Dish;
import com.milnow5555.restaurantproject.R;

import java.util.ArrayList;
import java.util.List;

public class WaitressView extends Fragment{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Dish> mealitems;

    public WaitressView() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_my_waitress_view, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mealitems = new ArrayList<>();
        for(int i=0 ;i<20;i++){
            Dish item = new Dish("Meal" + i,100,null);
            mealitems.add(item);
        }

        adapter = new WaitressAdapter(mealitems);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return rootView;
    }
}
