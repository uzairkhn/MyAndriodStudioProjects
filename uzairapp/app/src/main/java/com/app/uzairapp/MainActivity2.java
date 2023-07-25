package com.app.uzairapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.uzairapp.R;

public class MainActivity2 extends AppCompatActivity {

    EditText Name, Email, Password, Phone_No, Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Password= findViewById(R.id.Password);
        Phone_No = findViewById(R.id.Phone_No);
        Address= findViewById(R.id.Address);


    }

    public void Create(View view)
    {
        SharedPreferences sp = getSharedPreferences("userdata", MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();

        spEditor.putString("Name", Name.getText().toString());
        spEditor.putString("Email", Email.getText().toString());
        spEditor.putString("Password", Password.getText().toString());
        spEditor.putString("Phone_No", Phone_No.getText().toString());
        spEditor.putString("Address", Address.getText().toString());

        if(spEditor.commit())
        {
            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show();
        }
    }

    public void Login1(View view) {
        Intent s = new Intent(this, MainActivity.class);
        startActivity(s);
    }
}