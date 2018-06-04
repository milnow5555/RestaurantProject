package com.milnow5555.restaurantproject;

import java.util.*;

public class Dish {

    private String _name;
    private double _weight;
    private double _price;

    private List<String> _components;

    public double get_price() {
        return _price;
    }

    public String get_name() {
        return _name;
    }

    public List<String> get_components() {
        return _components;
    }

    public Dish(String name, double price, List<String> components) {
        _name = name;
        _price = price;
        _components = components;
    }

}
