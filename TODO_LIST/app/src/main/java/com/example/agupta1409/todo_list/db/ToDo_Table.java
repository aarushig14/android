package com.example.agupta1409.todo_list.db;

import android.provider.BaseColumns;

public class ToDo_Table extends db {

    public static final String TABLE_NAME = "ToDoTable";

    public interface Columns extends BaseColumns{
        String ID = "id";
        String TASK_NAME = "task_name";
        String STATUS = "status";
        String DATE_ADDED = "date_added";
    }

    public static final String TABLE_CREATE_COMMND = "CREATE TABLE " + TABLE_NAME
            + " " + LBR
            + Columns.ID + TYPE_INT_PRIMARY + COMMA
            + Columns.TASK_NAME + TYPE_STRING + COMMA
            + Columns.DATE_ADDED + TYPE_DATE + COMMA
            + Columns.STATUS + TYPE_STRING
            + RBR + ";" ;
}
