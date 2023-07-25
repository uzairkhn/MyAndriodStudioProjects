package com.app.uzairapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.uzairapp.MainActivity2;
import com.app.uzairapp.R;

public class MainActivity extends AppCompatActivity {

    EditText email,password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email =  findViewById(R.id.email);
        password = findViewById(R.id.password);
    }

    public void Login(View view)
    {
        SharedPreferences sp = getSharedPreferences("userdata",MODE_PRIVATE);

        String emailfile = sp.getString("Email","email");
        String pass = sp.getString("Password","password");

        if (email.getText().toString().equals(emailfile) && password.getText().toString().equals(pass)){
            Toast.makeText(this, "Valid Info", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Invalid Info", Toast.LENGTH_SHORT).show();

    }

    public void Signup(View view) {
        Intent  s = new Intent(this, MainActivity2.class);
        startActivity(s);
    }
}