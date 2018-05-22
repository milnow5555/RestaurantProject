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

    public FireBaseConnection(String path/*"nazwa segmentu w bazie np zamównienia albo posiłki"*/)
    {
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("ścieżka do firebase");
        childRef=ref.child(path);
    }

    public void setValueInFireBase(Object data)
    {
        childRef.push().setValue(data);
    }

    public Map<String,Object> getValueFromFireBase()
    {
        final Map<String,Object> map;
        childRef.addListenerForSingleValueEvent(new ValueEventListener() {
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

    public Object getChangeValueFromFireBase(String className)
    {
        final Object obj;
        Class clas=Class.foName(objectName);
        childRef.addValueEventListener(new ValueEventListener() {
            @java.lang.Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                obj=dataSnapshot.getValue(clas);
            }

            @java.lang.Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        return obj;
    }
}
