package com.milnow5555.restaurantproject.Database;

public interface ISendData {

    public void setValueInFireBase(Object data);
    public void getValueFromFireBase(String objectName);
}
