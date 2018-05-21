package com.milnow5555.restaurantproject.Domain;

import java.util.ArrayList;



public class Client implements User {

    private String Name;
    private String Surname;
    ArrayList<String> orderedMeals;

    public String getDetails() {
        return getName() + " " + getSurname();
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }


    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) {
        Name = name;
    }

}
