package com.milnow5555.restaurantproject.View;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.milnow5555.restaurantproject.R;
//import com.milnow5555.restaurantproject.Database.DatabaseService;
import com.milnow5555.restaurantproject.Domain.Client;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClientMainView extends AppCompatActivity {


   // private DatabaseService databaseService = new DatabaseService();
    private Boolean ClientLogged;

    @BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.progressBar6)
    ProgressBar progressBar6;
    private FirebaseAuth authorisation;
    private FirebaseUser firebaseUser;

    String actualName;

    @BindView(R.id.navList)
    ListView drawerList;

    private ArrayAdapter<String> drawerAdapter;

    Client client; //TODO Add data to client

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_main_view);
        ButterKnife.bind(this);
        authorisation = FirebaseAuth.getInstance();
        ClientLogged = false;
        if (authorisation.getCurrentUser() != null) {
            ClientLogged = true;
            addItemsToDrawerWhenLogged();
            displayName();
        } else {
            addItemsToDrawerWhenNotLogged();
        }

    }
    private void addItemsToDrawerWhenLogged() {
        drawerList.setAdapter(null);
        String[] osArray = { "Restaurant Menu", "Orderings", "Restaurant Info", "Log out"};
        drawerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, osArray);

        drawerList.setAdapter(drawerAdapter); //TODO Kolor czcionki z czarnego na bialy w listview (swoj wlasny adapter najlepiej)
        drawerList.setOnItemClickListener((parent, view, position, id) -> {

            if(position == 3) {
                logOut();
            }else{
                Toast.makeText(getApplicationContext(),"Do zrobienia",Toast.LENGTH_LONG).show();
            }

        });

    }
    private void addItemsToDrawerWhenNotLogged() {
        drawerList.setAdapter(null);
        String[] osArray = { "Restaurant Menu", "Orderings", "Restaurant Info", "Log in"};
        drawerAdapter = new ArrayAdapter<>(this, R.layout.textview_for_side_menu, osArray);
        drawerList.setAdapter(drawerAdapter);
        drawerList.setOnItemClickListener((parent, view, position, id) -> {

            if(position == 3) {
                Intent intent = new Intent(this, LoggingView.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Do zrobienia",Toast.LENGTH_LONG).show();
            }

        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (authorisation.getCurrentUser() == null) {
            String guest = "Guest";
            nameText.setText(guest);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(getApplicationContext(),"Client Logged", Toast.LENGTH_LONG).show();

//                name = data.getStringExtra("loggedName");
//                surname = data.getStringExtra("loggedSurname");
                ClientLogged = true;
            }
        }
    }



    public void displayName(){

        if(!ClientLogged){
            //TODO generowanie kodu stolika
            // nameText.setText("Dzban");
            Log.i("Msg","KURRRRRRRRRRRWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
        }else{

            firebaseUser = authorisation.getCurrentUser();
            if(firebaseUser!= null) {
                progressBar6.setVisibility(View.VISIBLE);
                Log.i("Msg","KURRRRRRRRRRRWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA22222222222222222222222222a");
                String uid = firebaseUser.getUid();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(uid);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        DataSnapshot name = dataSnapshot.child("Name ");
                        DataSnapshot surname = dataSnapshot.child("Name");
                        actualName = name.getValue(String.class);
                          //TODO odseparuj funkcje
                        //ToDO Dodaj progress bar
                        nameText.setText(actualName);
                        Log.i("NAMEEEEEEEEEE", "IMIEE " + actualName);
                        if(nameText.getText()!=null){
                            nameText.setVisibility(View.VISIBLE);
                            progressBar6.setVisibility(View.INVISIBLE);
                        }
                        //tu widocznosc daj
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            } else {
                Log.i("Msg","ERRRRRRRRRRRRRRRRRRRRRRRRRoooooR");
            }
        }
        Log.i("Msg","TU JESTEMMMM");
    }


    public void logOut(){
        if(authorisation.getCurrentUser() != null) {
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(getIntent());
        }
    }
    public void login(View view){
        startActivityForResult(new Intent(this,LoggingView.class),1);
    }
    public void myMeals(View view){

    }
    public void restaurantInfo(View view){

    }
}
