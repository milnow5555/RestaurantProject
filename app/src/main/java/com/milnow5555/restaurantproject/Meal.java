package com.milnow5555.restaurantproject;

import java.util.ArrayList;
import java.util.List;

public class Meal {

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

    public double get_weight() {
        return _weight;
    }

    public List<String> get_components() {
        return _components;
    }

    public Meal(String name, double weight, double price, List<String> components) {
        _name = name;
        _weight = weight;
        _price = price;
        _components = components;
    }

}
