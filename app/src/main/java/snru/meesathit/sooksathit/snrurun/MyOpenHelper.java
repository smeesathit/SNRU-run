package snru.meesathit.sooksathit.snrurun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 17/5/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    public static final String database_name = "Snru.db";
    public static final int database_version = 1;

    public static final String create_user_table = "create table userTABLE ("
          + "_id integer primary key, "
          + "Name text, "
          + "User text, "
          + "Password text, "
          + "Avata text);";

    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
