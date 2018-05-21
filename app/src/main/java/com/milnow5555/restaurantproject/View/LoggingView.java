package com.milnow5555.restaurantproject.View;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.milnow5555.restaurantproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoggingView extends AppCompatActivity {


    FirebaseAuth authorisation;

//    String testName = "Pioter";
//    String testSurname = "Kowolski";

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @BindView(R.id.editTextEmail)
    EditText emailText;
    @BindView(R.id.editTextPassword)
    EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);

        ButterKnife.bind(this);
        authorisation = FirebaseAuth.getInstance();
        Log.i("MSGGGGGGGGGGGGGGGGG","Tu jestem22222222222222");
    }
    @Override
    protected void onStart() {
        super.onStart();
        authorisation.getCurrentUser();
        if (authorisation.getCurrentUser() != null) {
            finish();
            Log.i("MSGGGGGGGGGGGGGGGGG","Tu jestem33333333333333");
            startActivity(new Intent(this, ClientMainView.class));
        }
    }


    public void logIn(View view) {
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        if(!verify(email, password)) return;



//        Intent returnIntent = new Intent();
//        returnIntent.putExtra("loggedName", testName);
//        returnIntent.putExtra("loggedSurname", testSurname);
//        setResult(Activity.RESULT_OK, returnIntent);
//        finish();

        progressBar.setVisibility(View.VISIBLE);
        authorisation.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            progressBar.setVisibility(View.GONE);
            if (task.isSuccessful()) {
                finish();
                Log.i("MSGGGGGGGGGGGGGGGGG","Tu jestem444444444444444444");
                Intent intent = new Intent(this, ClientMainView.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean verify(String email, String password) {

        if (email.isEmpty()) {
            emailText.setError("Email is required");
            emailText.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("Please enter a valid email");
            emailText.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            passwordText.setError("password is required");
            passwordText.requestFocus();
            return false;
        }
        if (password.length() < 6) {
            passwordText.setError("Minimum lenght of password should be 6");
            passwordText.requestFocus();
            return false;
        }
        return true;
    }

    public void signUp(View view) {
        startActivityForResult(new Intent(this, CreateUserView.class), 2);
        //TODO kolor sie zmienia na klikniecie
    }

}
