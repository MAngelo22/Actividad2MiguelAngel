package com.example.actividad2miguelangel.UsersTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UserDbHelper extends SQLiteOpenHelper{
        public UserDbHelper(Context context) {
            super(context, UsersContract.DB_NAME, null, UsersContract.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + UsersContract.TaskEntry.TABLE + " ( " +
                    UsersContract.TaskEntry.NOMBRE_USUARIO + " TEXT NOT NULL PRIMARY KEY , " +
                    UsersContract.TaskEntry.PASSWORD_USUARIO + " TEXT NOT NULL);";

            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + UsersContract.TaskEntry.TABLE);
            onCreate(db);
        }

}
