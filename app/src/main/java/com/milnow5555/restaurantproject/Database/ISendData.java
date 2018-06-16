package com.milnow5555.restaurantproject.Database;

import java.util.Map;

public interface ISendData {

    public void setValueInFireBase(Object data);
    public Map<String, Object> getValueFromFireBase(String objectName);
}
