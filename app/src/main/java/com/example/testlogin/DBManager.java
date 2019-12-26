package com.example.testlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }
    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }
    // Query insert data
    public void insert(String name, String email, String uname, String pass) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COLUMN_NAME, name);
        contentValue.put(DatabaseHelper.COLUMN_EMAIL, email);
        contentValue.put(DatabaseHelper.COLUMN_UNAME, uname);
        contentValue.put(DatabaseHelper.COLUMN_PASS, pass);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    // Query ambil/read data
    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_EMAIL,
                DatabaseHelper.COLUMN_UNAME, DatabaseHelper.COLUMN_PASS};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns,
                null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    // Query update data
    public int update(Integer _id,String name, String email, String uname, String pass) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_NAME, name);
        contentValues.put(DatabaseHelper.COLUMN_EMAIL, email);
        contentValues.put(DatabaseHelper.COLUMN_UNAME, uname);
        contentValues.put(DatabaseHelper.COLUMN_PASS, pass);

        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.COLUMN_ID + " = " + _id, null);
        return i;
    }
    // Query delete data
    public void delete(long _id) {

        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COLUMN_ID + "=" + _id, null);
    }
}
