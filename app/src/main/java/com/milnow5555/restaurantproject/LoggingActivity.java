package com.milnow5555.restaurantproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoggingActivity extends AppCompatActivity {

    String testName = "Pioter";
    String testSurname = "Kowolski";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);
    }

    public void verify(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("loggedName",testName);
        returnIntent.putExtra("loggedSurname",testSurname);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

}
