package com.example.agupta1409.announcements.myDb;

import android.provider.BaseColumns;

import static android.content.RestrictionEntry.TYPE_BOOLEAN;

/**
 * Created by a.gupta1409 on 23-01-2017.
 */

public class User_Table extends Db_table {

    public static final String TABLE_NAME = "User_Table";

    public interface Columns extends BaseColumns {
        String USER_ID = "user_id";
        String PASSWORD = "password";
        String SEEN = "seen";
        String COMMENT = "comment";
    }

    public static final String TABLE_CREATE_CMD = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + OPEN_BRACKET
            + Columns.USER_ID + TYPE_CHAR + "(10)" + TYPE_PRIMARY_KEY + COMMA
//            + Columns.DATE + TYPE_DATE + COMMA
//            + Columns.TIME + TYPE_TIME + COMMA
            + Columns.PASSWORD + TYPE_VARCHAR + "(255)" + COMMA
            + Columns.COMMENT + TYPE_VARCHAR + "(255)" + COMMA
            + Columns.SEEN + TYPE_BOOLEAN
            + CLOSE_BRACKET
            + SEMI_COLON ;
}
