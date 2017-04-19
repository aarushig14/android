package com.example.agupta1409.rachitbday.db;

import android.provider.BaseColumns;

/**
 * Created by a.gupta1409 on 17-07-2016.
 */
public class Table extends Db_table {
    public static final String TABLE_NAME = "SMMHBC";

    public interface Columns extends BaseColumns {
        String FLAG = "flag";
        String NAME = "name";
        String MESSAGE = "message";
        String IMAGE = "image";
    }

    public static final String TABLE_CREATE_CMD = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + LBR
            + Columns.FLAG + TYPE_INT + COMMA
            + Columns.NAME + TYPE_VARCHAR + "(15)" + COMMA
            + Columns.MESSAGE + TYPE_VARCHAR + "(300)" + COMMA
            + Columns.IMAGE + TYPE_INT_PK
            + RBR + SEMI_COLON
            ;

    public static final String RIA_MSG = "Ranchoooo \uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\n" +
            "\n" +
            "Happy birthday aalsi bestie, oh sorry, dps bestie!!! \uD83C\uDF89\uD83C\uDF82\uD83C\uDF8A\n" +
            "\n" +
            "Dekh hum Delhi quota wale Moradabad toh aa nahi paayenge toh apne dil mein tujhe yaad rakhke " +
            "tujhse August mein badi wali treat lenge don't worry \uD83D\uDE0A\uD83D\uDE0A\n" +
            "\n" +
            "You're a great guy and I'm glad to have had the chance to know you. Meri bakwas sunne ke liye and " +
            "advice dene ke liye thank you. Tu best hai yaar tere saath bohot mazze aate hai \uD83D\uDE0D\uD83D\uDE0D\n" +
            "\n" +
            "Happy birthday once again and I hope all your wishes come true and you have a great year ahead. " +
            "Love you Rancho ❤\uD83D\uDE18\n" +
            "\n" +
            "PS: Apoorvi committed ho gayi \uD83D\uDE02\uD83D\uDE02";


    public static final String MANSI_MSG = "Rancho pancho..tu mera favourite hai..tujhe sab pata hai mere baare mai aur mujhe tere.." +
            "and there are somethings u have promised me..you ll fulfill that mister warna bahot punches parenge.." +
            "love you so much kutte..you are my all time..har weekend..har friday dinner bc..tu mera constant hai mann.." +
            "par zyada udna matt..aur zyada marna matt..ab toh juniors bhi aa jayenge..mai jab tujhse milungi toh ek surprise dungi.." +
            "abi ke liye itna hi...a very happy happy birthday \uD83D\uDE18\uD83D\uDE18\uD83D\uDE18";

    public static final String TANVEER_MSG = "Rachooo Bc! \n" +
            "\" +\n" +
            "                \"Wishing you an amazing birthday bro. \\uD83C\\uDF89 \\uD83D\\uDC83\\n\" +\n" +
            "                \"Hamare Smmh ka nashedi and one of the very few people who listen to real music apart from the mainstream crap. Respect for that.\\uD83D\\uDE02\\n\" +\n" +
            "                \"Chal it's your day. Enjoy kario, have a blast and take care.\\uD83D\\uDE18\\n\" +\n" +
            "                \"And college khulne ke baad party chahiye bc!";

}
