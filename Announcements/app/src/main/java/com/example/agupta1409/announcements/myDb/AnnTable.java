package com.example.agupta1409.announcements.myDb;

import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by a.gupta1409 on 03-09-2016.
 */
public class AnnTable extends Db_table {

    public static final String TABLE_NAME = "Announ_Table";

    public interface Columns extends BaseColumns {
        String MSG_ID = "msg_id";
        String DATE = "date";
        String TIME = "time";
        String MSG = "msg";
        String SEEN = "seen";
    }

    public static final String TABLE_CREATE_CMD = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + OPEN_BRACKET
            + Columns.MSG_ID + TYPE_CHAR + "(10)" + TYPE_PRIMARY_KEY + COMMA
//            + Columns.DATE + TYPE_DATE + COMMA
//            + Columns.TIME + TYPE_TIME + COMMA
            + Columns.MSG + TYPE_VARCHAR + "(255)" + COMMA
            + Columns.SEEN + TYPE_INT
            + CLOSE_BRACKET
            + SEMI_COLON ;

}

