package expense.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.*;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user_login";
    public static final String USER_LOGIN_TABLE = "Login";
    public static final String COL_USERNAME = "USERNAME";
    public static final String COL_PASSWORD = "PASSWORD";

    private static final String CREATE_TABLE_LOGIN = "CREATE TABLE "
            + USER_LOGIN_TABLE + " (" + COL_USERNAME
            + " TEXT PRIMARY KEY NOT NULL," + COL_PASSWORD
            + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        Log.d("table", CREATE_TABLE_LOGIN);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LOGIN);
        db.execSQL("INSERT INTO " + USER_LOGIN_TABLE+ " (USERNAME, PASSWORD ) VALUES ('Jenkins2', '1234');");
        db.execSQL("INSERT INTO " + USER_LOGIN_TABLE+ " (USERNAME, PASSWORD ) VALUES ('Shakira', 'HipsDontLie27');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_LOGIN_TABLE);
        onCreate(db);
    }

    public void insertInfo (String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_PASSWORD, password);
        db.insert(USER_LOGIN_TABLE, null, contentValues);
    }

    public Boolean doesUserExist(String username)
    {
        boolean found = false;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;

        String query = "SELECT * FROM " + USER_LOGIN_TABLE;
        cursor= db.rawQuery(query, null);

        if (cursor.getCount() == 0)
        {
            return false;
        }
        else
        {
            while (cursor.moveToNext())
            {
                if (cursor.getString(1) == username)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean verifyPassword(String username, String password)
    {

        boolean found = false;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor ;

        String query = "SELECT " + username + " FROM " + USER_LOGIN_TABLE;
        cursor= db.rawQuery(query, null);

        if (cursor.getCount() == 0)
        {
            return false;
        }
        else
        {
            while (cursor.moveToNext())
            {
                if (cursor.getString(2) == password)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
