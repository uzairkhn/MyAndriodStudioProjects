package com.app.podcastappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    EditText name, emailet , passwordet , address, phone_no;
    Button Signup, Login;
    String password,email;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name_signup);
        emailet = findViewById(R.id.email_signup);
        passwordet = findViewById(R.id.password_signup);
        address = findViewById(R.id.address_signup);
        phone_no = findViewById(R.id.phoneno_signup);
        Login = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(v -> {
            onBackPressed();
        });
    }
    public void signup(View view) {
        mAuth.createUserWithEmailAndPassword(email = emailet.getText().toString(), password = passwordet.getText().toString())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {

                        Toast.makeText(getApplicationContext(), "Sign up Successfully", Toast.LENGTH_SHORT).show();

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}