package com.milnow5555.restaurantproject;

import java.util.*;

public class Order {

    private List<Dish> _dishes;
    private String _state;
    private Long _id;
    private int _table;



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
            cost+= meal.get_price();
        }
        return cost;
    }

    public void removeMeal(String name)
    {
        for(Dish dish: _dishes)
        {
            if(dish.get_name()==name)
            {
                _dishes.remove(dish);
                break;
            }
        }
    }

    public void makeOrder(ISendData sendData)
    {
        sendData.setValueInFireBase(this);
    }
}