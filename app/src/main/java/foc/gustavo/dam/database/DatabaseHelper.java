package foc.gustavo.dam.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper  {

    private static final int sDATABASE_VERSION_1_0 = 1;

    private static final String sDATABASE_NAME = "dam.db";
    private static final int sDATABASE_VERSION = sDATABASE_VERSION_1_0;

    private static final String[] sDATABASE_CREATE = {  };

    public DatabaseHelper(Context context) {
        super(context, sDATABASE_NAME, null, sDATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        for(String table : sDATABASE_CREATE)
            database.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch(oldVersion) {
            case sDATABASE_VERSION_1_0:
        }
    }

}