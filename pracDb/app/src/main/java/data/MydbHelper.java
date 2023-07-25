package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MydbHelper extends SQLiteOpenHelper {
    public MydbHelper(@Nullable Context context) {
        super(context, "ST_table" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table ST_table(id INTEGER PRIMARY KEY,name TEXT, phoneno TEXT )";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
public void addStudents(String name, String phoneno){
       SQLiteDatabase db= this.getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put("name",name);
    cv.put("phoneno",phoneno);
    db.insert("ST_table",null,cv);
    Log.d("st_db","ADded");

}

public List<String > readstudent(){
        List<String> studentlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM ST_table";
    Cursor cursor = db.rawQuery(query,null);
if (cursor.moveToFirst()) {
    do {
        studentlist.add(cursor.getString(1));

    } while (cursor.moveToNext());
}
return studentlist;
}
public void updatePhoneno(String new_phoneno, String old_phoneno){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("phoneno",new_phoneno);
        String arg[] ={old_phoneno};
        int row = db.update("ST_table",cv,"phoneno?",arg);
        db.close();
}
public void deletePhoneno(String phoneno){
        SQLiteDatabase db = this.getWritableDatabase();
        String arg[]= {phoneno};
        db.delete("ST_table","phoneno?",arg);
}



    }

