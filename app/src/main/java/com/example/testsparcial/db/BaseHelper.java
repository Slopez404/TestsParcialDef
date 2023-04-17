package com.example.testsparcial.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {

    private static  final int DATABASE_VERSION = 1;
    private static final String ID_COLUMNA  = "id";
    private static final String USUARIO_COLUMNA  = "usuario";
    private static final String PASSWORD_COLUMNA = "password";
    private static  final String DATABASE_NOMBRE = "productos.db";
    private static final String TABLE_NOMBRE = "info";
    public static  final String TABLE_PRODUCTO = "t_productos.db";



    public BaseHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCTO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "producto TEXT NOT NULL," +
                "cantidad INT NOT NULL,)" );
        ;
    }

    
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PRODUCTO);
        onCreate(sqLiteDatabase);

    }
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {ID_COLUMNA};
        String selection = USUARIO_COLUMNA + " = ?" + " AND " + PASSWORD_COLUMNA + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NOMBRE, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
    public boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USUARIO_COLUMNA, username);
        values.put(PASSWORD_COLUMNA, password);

        long result = db.insert(TABLE_NOMBRE, null, values);
        return (result != -1);
    }
}
