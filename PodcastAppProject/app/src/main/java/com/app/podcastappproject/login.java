package com.app.podcastappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText emailet,passwordet;
    Button Login , Signup;
    String email, password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      emailet =findViewById(R.id.input_email);
      passwordet = findViewById(R.id.input_password);
      Login = findViewById(R.id.login);
      Signup = findViewById(R.id.sign_up);
      mAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(v -> {

            login(v);
        });

        Signup.setOnClickListener(v -> {

            Intent i = new Intent(login.this, signup.class);
            startActivity(i);
        });
//check if the user is currently logged in or not/
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(login.this, HomeActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }


    }

    public void login(View view) {


        mAuth.signInWithEmailAndPassword(email = emailet.getText().toString(), password = passwordet.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                           Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                           finish();
                           startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }




    }
