package com.milnow5555.restaurantproject;

import android.view.View;

import com.milnow5555.restaurantproject.Database.ISendData;

import java.util.*;

public class Order {

    private List<Dish> _dishes;
    private String _state;
    private Long _id;
    private int _table;


    public Order(List<Dish> meals) {
        _dishes = meals;
    }

    public Order(List<Dish> meals, String state, int table) {
        _dishes = meals;
        _state = state;
        _table=table;
    }

    public void addMeal(String name, double price,List<String> components)
    {
        _dishes.add(new Dish(name,price,components));
    }

    public double getOrderCost()
    {
        double cost=0;
        for(Dish meal: _dishes)
        {
            cost+= meal.getPrice();
        }
        return cost;
    }

    public void removeMeal(String name)
    {
        for(Dish meal: _dishes)
        {
            if(meal.getName()==name)
            {
                _dishes.remove(meal);
                break;
            }
        }
    }

    public Dish getDish(int position){
        return _dishes.get(position);
    }
    public void makeOrder(ISendData sendData)
    {
        sendData.setValueInFireBase(this);
    }
}