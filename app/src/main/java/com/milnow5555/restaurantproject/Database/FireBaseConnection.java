package com.milnow5555.restaurantproject.Database;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.lang.*;

import java.util.*;

public class FireBaseConnection implements ISendData {

    final FirebaseDatabase database;
    DatabaseReference ref;
    DatabaseReference childRef;
    Map<String,Object> map;

    public FireBaseConnection(String path/*"nazwa segmentu w bazie np zamównienia albo posiłki"*/)
    {
        database=FirebaseDatabase.getInstance();
        ref=database.getReference();
        childRef=ref.child(path);
    }

    public void setValueInFireBase(Object data)
    {
        childRef.push().setValue(data);
    }

    public Map<String,Object> getValueFromFireBase(String firstNode)
    {
        DatabaseReference firstRef=FirebaseDatabase.getInstance().getReference(firstNode);

        firstRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @java.lang.Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                map= (Map<String,Object>) dataSnapshot.getValue();
            }

            @java.lang.Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return map;
    }

    public Object getChangeValueFromFireBase(String className) throws ClassNotFoundException {
        final Object[] obj = new Object[1];
        Class clas=Class.forName(className);
        childRef.addValueEventListener(new ValueEventListener() {
            @java.lang.Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                obj[0] =dataSnapshot.getValue(clas);
            }

            @java.lang.Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        return obj[0];
    }

    public Object getChangeValueFromFireBase(String firstNode,String className) throws ClassNotFoundException {
        DatabaseReference firstRef=childRef.child(firstNode);
        final Object[] obj = new Object[1];
        Class clas=Class.forName(className);
        firstRef.addValueEventListener(new ValueEventListener() {
            @java.lang.Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                obj[0] =dataSnapshot.getValue(clas);
            }

            @java.lang.Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        return obj[0];
    }

    public Object getChangeValueFromFireBase(String firstNode,String secondNode,String className) throws ClassNotFoundException {
        DatabaseReference firstRef=childRef.child(firstNode);
        DatabaseReference secondRef=firstRef.child(secondNode);
        final Object[] obj = new Object[1];
        Class clas=Class.forName(className);
        secondRef.addValueEventListener(new ValueEventListener() {
            @java.lang.Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                obj[0] =dataSnapshot.getValue(clas);
            }

            @java.lang.Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        return obj[0];
    }
}