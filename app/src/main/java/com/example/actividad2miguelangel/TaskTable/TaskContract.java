package com.example.actividad2miguelangel.TaskTable;

import android.provider.BaseColumns;

public class TaskContract {
    public static final String DB_NAME = "com.example.actividad2miguelangel.TaskTable";
    public static final int DB_VERSION = 1;

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "tasks";

        public static final String TITULO_TAREA = "title";
    }
}