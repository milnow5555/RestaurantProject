package com.milnow5555.restaurantproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClientMainView extends AppCompatActivity {

    String name = "dzban";
    String surname;
    Boolean ClientLogged = false;
    @BindView(R.id.nameText)
    TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_main_view);
        ButterKnife.bind(this);
        checkName();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkName();
    }

    public void checkName(){

        if(!ClientLogged){
            nameText.setText("Dzban");
        }else{
            nameText.setText(name);
        }
        Log.i("Msg",name);
    }
    public void loginFunction(View view){
       startActivityForResult(new Intent(this,LoggingActivity.class),1);
   }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                name = data.getStringExtra("loggedName");
                surname = data.getStringExtra("loggedSurname");
                ClientLogged = true;
            }
        }
    }
}
