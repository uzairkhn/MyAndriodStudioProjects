package com.app.pracdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import data.MydbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MydbHelper db = new MydbHelper(this);
        ListView lv= findViewById(R.id.lv);
        List<String> studentlist = db.readstudent();
        ArrayAdapter<String>ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1,studentlist);
        lv.setAdapter(ad);


    }
}