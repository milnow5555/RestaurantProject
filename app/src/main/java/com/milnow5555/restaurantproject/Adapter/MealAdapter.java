package com.milnow5555.restaurantproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.milnow5555.restaurantproject.Dish;
import com.milnow5555.restaurantproject.R;
import com.milnow5555.restaurantproject.View.MyOrdersView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder> {

    public MealAdapter(List<Dish> dishes, MyOrdersView myOrdersView) {
        this.mealitems = mealitems;
        this.context = context;
    }



    private List<Dish> mealitems;
    private Context context;

    public MealAdapter(List<Dish> mealitems, Context context) {
        this.mealitems = mealitems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meals_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Dish listitem = mealitems.get(position);
        holder.textViewHead.setText(listitem.getName());
        holder.textViewDesc.setText(Double.toString(listitem.getPrice()));

    }

    @Override
    public int getItemCount() {
        return mealitems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;


        public ViewHolder(View itemView){
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);

        }
    }
}