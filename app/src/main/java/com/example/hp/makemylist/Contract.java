package com.example.hp.makemylist;

import android.provider.BaseColumns;

public class Contract {

    private Contract(){}

    public static final class Entry implements BaseColumns{

        public static final  String TABLE_NAME ="List";
        public static final  String COLUMN_NAME ="name";
        public static final  String COLUMN_AMOUNT="amount";
        public static final String COLUMN_TIMESTAMP="timestamp";
      }
}
