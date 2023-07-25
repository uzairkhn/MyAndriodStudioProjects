package com.app.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Signup extends AppCompatActivity {

    EditText name,etemail,etpassword,address,phone_no;
    Button Login,SIgnup;
    String email,password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.signup_name);
        etemail = findViewById(R.id.signup_eamil);
        etpassword = findViewById(R.id.signup_password);
        address = findViewById(R.id.signup_address);
        phone_no = findViewById(R.id.signup_phonenb);

        Login =findViewById(R.id.login);
        SIgnup = findViewById(R.id.signup);


        SIgnup.setOnClickListener(v -> Sign_up());

        Login.setOnClickListener(v -> {
            Intent i = new Intent(this,MainActivity.class);
            finish();
            startActivity(i);
        });


    }

    private void Sign_up() {
        mAuth.createUserWithEmailAndPassword(email = etemail.getText().toString(), password = etpassword.getText().toString())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        addUserData();
                        Toast.makeText(getApplicationContext(), "User Added Successfully", Toast.LENGTH_SHORT).show();

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }


        private void addUserData() {
            DatabaseReference databaseReferece;
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            databaseReferece = db.getReference("Users").child(Objects.requireNonNull(mAuth.getUid()));

            databaseReferece.child("name").setValue(name.getText().toString());
            databaseReferece.child("email").setValue(etemail.getText().toString());
            databaseReferece.child("password").setValue(etpassword.getText().toString());
            databaseReferece.child("Address").setValue(address.getText().toString());
            databaseReferece.child("phone_no").setValue(phone_no.getText().toString());




    }}


