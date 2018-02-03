package nyc.c4q.tariquapart2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nyc.c4q.tariquapart2.network.Data;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by MsNehisi on 2/2/18.
 */

public class GiphyDatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "doggie.db";
    private static final int DATABASE_VERSION = 1;

    private static GiphyDatabaseHelper instance;

    public static synchronized GiphyDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new GiphyDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    public GiphyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        cupboard().register(Data.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }
}
