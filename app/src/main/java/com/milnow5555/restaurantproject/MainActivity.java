package com.milnow5555.restaurantproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

//    DatabaseReference firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        startActivity(new Intent(this,ClientMainView.class));

//        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
//        firebaseDatabase.child("Email");
    }




















//    public void addingMethod(View view) throws NullPointerException {
//        String name = textView.getText().toString();
//        String email = textView2.getText().toString();
//
//        HashMap<String,String> userDetails = new HashMap<>();
//        userDetails.put("Name",name);
//        userDetails.put("Email",email);
//
//        firebaseDatabase.push().setValue(userDetails).addOnCompleteListener(task -> {
//            if(task.isComplete()){
//                Toast.makeText(this,"Data Added",Toast.LENGTH_LONG).show();
//            }else{
//                Toast.makeText(this,"Error while adding data",Toast.LENGTH_LONG).show();
//            }
//        });
//    }
}
