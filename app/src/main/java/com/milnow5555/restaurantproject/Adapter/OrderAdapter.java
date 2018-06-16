package com.milnow5555.restaurantproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.milnow5555.restaurantproject.Order;
import com.milnow5555.restaurantproject.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<Order> orderitems;
    private Context context;

    public OrderAdapter(List<Order> mealitems, Context context) {
        this.orderitems = mealitems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order listitem = orderitems.get(position);
        holder.textViewHead.setText(listitem.getDish(position).getName());
        holder.textViewDesc.setText(Double.toString(listitem.getDish(position).getPrice()));
        //holder.textViewTotalPrice.setText(Double.toString(listitem.getDish(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return orderitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        //public TextView textViewTotalPrice;

        public ViewHolder(View itemView){
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            //textViewTotalPrice = (TextView) itemView.findViewById(R.id.textViewTotalPrice);
        }
    }
}