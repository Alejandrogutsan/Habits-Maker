package ca.georgebrown.comp3074.prototype2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDatabase_habits";
    public static final int DATABASE_VERSION = 1;
    public static final String col_1 = "ID";
    public static final String col_2 = "name";
    public static final String col_3 = "email";
    public static final String col_4 = "password";

    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Habits( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT UNIQUE, TYPE TEXT, DAY_COUNT INTEGER, LASTDATE DATE)"); //LASTDATE added to let checkBoxDone be use once a day - Alan
        db.execSQL("CREATE TABLE User( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL EMAIL UNIQUE, PASSWORD PASSWORD, GENDER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Habits");
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }

    public void insert_habit(String name, String type, int count, Date lastDateDone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("TYPE", type);
        contentValues.put("DAY_COUNT", count);

        //to let checkBoxDone be use once a day - Alan
        contentValues.put("LASTDATE", lastDateDone.toString());

        db.insertOrThrow("Habits", "", contentValues);
    }

    public Cursor getAllHabits() {
        SQLiteDatabase db = getReadableDatabase();
        final String query = "SELECT * FROM Habits";
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    public void delete_habit(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Habits", "NAME = ? ", new String[]{name});
    }

    public void update_habit(String name, int count) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DAY_COUNT", count);
        String whereClause = "NAME=?";
        String whereArgs[] = {name};
        db.update("Habits", contentValues, whereClause, whereArgs);
    }

    public long addUser(String name, String email, String pass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("EMAIL", email);
        contentValues.put("PASSWORD", pass);
        long res = db.insert("User", null, contentValues);
        return  res;
        //db.insertOrThrow("User", "", contentValues);
    }

    public Boolean checkUser(String email, String pass) {
        String[] columns = {col_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = col_3 + "=?" + " AND " + col_4 + "=?";
        String[] selectionArgs = {email, pass};
        Cursor cursor = db.query("User", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {return true;}
        else {return false;}
    }
}
