package com.example.agupta1409.databases.db;

import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by a.gupta1409 on 12-07-2016.
 */
public class StudentTable extends Db_table {

    public static final String TABLE_NAME = "students";

    public interface Columns extends BaseColumns{
        String ID = "id";
        String NAME = "name";
        String AGE = "age";
        String CLASS = "class";
    }

    public static final String TABLE_CREATE_CMD = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + LBR
            + Columns.ID + TYPE_INT_PK + COMMA
            + Columns.NAME + TYPE_TEXT + COMMA
            + Columns.AGE + TYPR_INT + COMMA
            + Columns.CLASS + TYPR_INT
            + RBR + ";"
            ;
}
