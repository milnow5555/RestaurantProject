package com.milnow5555.restaurantproject;

import java.util.ArrayList;
import java.util.List;
import com.milnow5555.restaurantproject.Database.;

public class Order {

    private List<Meal> _meals;
    private String _state;
    private Long _id;
    private int _table;



    public Order(List<Meal> meals, String state, Long id,int table) {
        _meals = meals;
        _state = state;
        _id = id;
        _table=table;
    }

    public void addMeal(String name,double weight, double price,List<String> components)
    {
        _meals.add(new Meal(name,weight,price,components));
    }

    public double getOrderCost()
    {
        double cost=0;
        for(Meal meal:_meals)
        {
            cost+= meal.get_price();
        }
        return cost;
    }

    public void removeMeal(String name)
    {
        for(Meal meal:_meals)
        {
            if(meal.get_name()==name)
            {
                _meals.remove(meal);
                break;
            }
        }
    }

    public void makeOrder(ISendData sendData)
    {
        sendData.setValueInFireBase(this);
    }
}