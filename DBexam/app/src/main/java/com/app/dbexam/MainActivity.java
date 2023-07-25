package com.app.dbexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.dbexam.data.MyDBHelper;
import com.app.dbexam.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDBHelper db = new MyDBHelper(this);
        db.deleteTable();

        List<String> studentList = db.readStudent();
        ListView lv = findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                studentList);

        lv.setAdapter(adapter);
    }
}