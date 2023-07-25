package com.app.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Name,Email,Password;
    }

    public void Signup(View view)
    {
        EditText Name = (EditText) findViewById(R.id.et1);
        EditText Email = (EditText) findViewById(R.id.et2);
        EditText Password= (EditText) findViewById(R.id.et3);
        String Nametxt = Name.getText().toString();
        String Passwordtxt = Password.getText().toString();
        String Emailtxt = Email.getText().toString();


        MyDatabaseHelper dbhelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("EName",Nametxt);
        cv.put("EPassword",Passwordtxt);
        cv.put("EEmail",Emailtxt);

        long rowID = db.insert("U",null, cv);

    }
}