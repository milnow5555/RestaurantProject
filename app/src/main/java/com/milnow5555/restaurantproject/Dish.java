package com.milnow5555.restaurantproject;


import java.util.List;

public class Dish {
    private String _name;
    private double _weight;
    private double _price;
    private boolean isSelected;

    private List<String> _components;

    public double getPrice() {
        return _price;
    }

    public String getName() {
        return _name;
    }

    public List<String> getComponents() {
        return _components;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Dish(String name, double price, List<String> components) {
        _name = name;
        _price = price;
        _components = components;
    }
}
