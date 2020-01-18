package com.example.actividad2miguelangel.UsersTable;

import android.provider.BaseColumns;

public class UsersContract {

        public static final String DB_NAME = "UsersTable";
        public static final int DB_VERSION = 1;

        public class TaskEntry implements BaseColumns {
            public static final String TABLE = "users";

            public static final String NOMBRE_USUARIO = "name";
            public static final String PASSWORD_USUARIO = "password";
        }
}
