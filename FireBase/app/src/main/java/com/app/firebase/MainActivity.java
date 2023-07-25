package com.app.firebase;

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

public class MainActivity extends AppCompatActivity {

    EditText emailet, paswordet;
    Button Login, Signup;
    String email, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailet = findViewById(R.id.login_email);
        paswordet = findViewById(R.id.login_password);
        Login = findViewById(R.id.login);
        Signup = findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(v -> {

            Login();
        });

        Signup.setOnClickListener(v -> {

            Intent i = new Intent(this, Signup.class);
            finish();
            startActivity(i);
        });

    }

    private void Login() {

        mAuth.signInWithEmailAndPassword(email = emailet.getText().toString(), password = paswordet.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(getApplicationContext(),Userdetail.class);
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

