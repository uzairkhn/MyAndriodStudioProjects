package com.app.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Userdetail extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView name_text,emailTxt,addressTxt,phoneTxt;
    DatabaseReference myRef;
    FirebaseDatabase db = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);
        mAuth = FirebaseAuth.getInstance();

        myRef = db.getReference("Users");

        TextView uId = findViewById(R.id.user_id);
        uId.setText(mAuth.getUid());

        name_text =findViewById(R.id.name);
        emailTxt = findViewById(R.id.email);
        addressTxt = findViewById(R.id.address);
        phoneTxt = findViewById(R.id.phone_number);
        Button signOut = findViewById(R.id.signOut);

        readFB();

        signOut.setOnClickListener(view ->{
            mAuth.signOut();
            Intent i = new Intent(this,MainActivity.class);
            finish();
            startActivity(i);
        });
    }

    public void readFB(){
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String name = dataSnapshot.child(mAuth.getUid()).child("name").getValue().toString();
                String email = dataSnapshot.child(mAuth.getUid()).child("email").getValue().toString();
                String address = dataSnapshot.child(mAuth.getUid()).child("Address").getValue().toString();
                String phoneNumber = dataSnapshot.child(mAuth.getUid()).child("phone_no").getValue().toString();


                //Setting data in text
                name_text.setText(name);
                emailTxt.setText(email);
                addressTxt.setText(address);
                phoneTxt.setText(phoneNumber);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
}
