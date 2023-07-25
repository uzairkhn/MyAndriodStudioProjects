package com.app.dbexam.data;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

        import com.app.dbexam.model.Student;

        import java.util.ArrayList;
        import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context) {
        super(context, "students_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE students_table(id INTEGER PRIMARY KEY, name TEXT, phone TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(String name, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("phone", phone);

        db.insert("students_table", null, cv);
        Log.d("uzairDB", "Added successfully");
        db.close();
    }


    public List<String> readStudent() {
        List<String> studentList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM students_table";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                studentList.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return studentList;
    }

    public void updateStudent(String newName, String oldName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", newName);

        String args[] = {oldName};

        int rows = db.update("students_table",cv, "name=?", args);
        db.close();
    }

    public void deleteStudent(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] arg = {name};

        db.delete("students_table","name=?",arg);

    }

    public void deleteTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM students_table");
        db.execSQL("DROP TABLE students_table");
        this.onCreate(db);
    }
}
