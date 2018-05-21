package com.milnow5555.restaurantproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.milnow5555.restaurantproject.View.ClientMainView;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth authorisation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        authorisation = FirebaseAuth.getInstance();
        if (authorisation.getCurrentUser() != null) authorisation.signOut();

        startActivity(new Intent(this,ClientMainView.class));

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
