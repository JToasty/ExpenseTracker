package expense.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.*;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Primary table
    public static final String DATABASE_NAME = "user_login";
    public static final String USER_LOGIN_TABLE = "Login";
    public static final String COL_USERNAME = "USERNAME"; //primary key
    public static final String COL_PASSWORD = "PASSWORD";

    //Child Table for total income and expenses
    public static final String INCOME_EXPENSE_TABLE = "income_expense";
    public static final String COL_INCOME = "INCOME";
    public static final String COL_EXPENSE = "EXPENSE";

    public static String username = "";
    private static final String CREATE_TABLE_LOGIN = "CREATE TABLE IF NOT EXISTS "
            + USER_LOGIN_TABLE + " (" + COL_USERNAME
            + " VARCHAR PRIMARY KEY NOT NULL," + COL_PASSWORD
            + " VARCHAR)";


    private static final String CREATE_TABLE_IncomeExpense = "CREATE TABLE IF NOT EXISTS "
            + INCOME_EXPENSE_TABLE + " (" + COL_USERNAME
            + " VARCHAR," + COL_INCOME
            + " REAL DEFAULT 0.0," + COL_EXPENSE + " REAL DEFAULT 0.0)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        Log.d("table", CREATE_TABLE_LOGIN);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LOGIN);
        db.execSQL(CREATE_TABLE_IncomeExpense);
        db.execSQL("INSERT INTO " + USER_LOGIN_TABLE+ " (USERNAME, PASSWORD ) VALUES ('Jenkins2', '1234')");
        db.execSQL("INSERT INTO " + INCOME_EXPENSE_TABLE+ " (USERNAME, INCOME, EXPENSE ) VALUES ('Jenkins2', 6000.00, 1560.99 )");

        db.execSQL("INSERT INTO " + USER_LOGIN_TABLE+ " (USERNAME, PASSWORD ) VALUES ('Shakira', 'HipsDontLie27')");
        db.execSQL("INSERT INTO " + USER_LOGIN_TABLE+ " (USERNAME, PASSWORD ) VALUES ('Admin', '4321')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_LOGIN_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + INCOME_EXPENSE_TABLE);
        onCreate(db);
    }

    public void newUser (String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_PASSWORD, password);
        db.insert(USER_LOGIN_TABLE, null, contentValues);
    }

    public SQLiteDatabase getDatabase()
    {
        return this.getReadableDatabase();
    }
    public Double getIncome()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;

        String query = "SELECT * FROM " + INCOME_EXPENSE_TABLE + " WHERE USERNAME = '" + username + "'";

        c = db.rawQuery(query, null);
        int incomeIndex = c.getColumnIndex(COL_INCOME);
        int nameIndex = c.getColumnIndex(COL_USERNAME);

        c.moveToFirst();

        if(c != null && c.getCount() != 0)
        {
            do{
                Log.i("table", "Sucessful start of loop");
                if( (username.equals(c.getString(nameIndex))))
                {
                    return c.getDouble(incomeIndex);
                }
            }while(c.moveToNext());
        }
        return 0.0;
    }

    public Double getExpense()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;

        String query = "SELECT * FROM " + INCOME_EXPENSE_TABLE + " WHERE USERNAME = '" + username + "'";

        c = db.rawQuery(query, null);
        int expenseIndex = c.getColumnIndex(COL_EXPENSE);
        int nameIndex = c.getColumnIndex(COL_USERNAME);

        c.moveToFirst();
        if(c != null && c.getCount() != 0)
        {
            do{
                Log.i("table", "Sucessful start of loop");
                if( (username.equals(c.getString(nameIndex))))
                {
                    return c.getDouble(expenseIndex);
                }
            }while(c.moveToNext());
        }
        return 0.0;
    }

    public Boolean doesUserExist(String username, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;

        String query = "SELECT * FROM " + USER_LOGIN_TABLE;
        c = db.rawQuery(query, null);


        int nameIndex = c.getColumnIndex(COL_USERNAME);
        int passIndex = c.getColumnIndex(COL_PASSWORD);
        c.moveToFirst();

        Log.i("table", "Sucessful column reset");
        //----------------------Check if username and pass match---------------------------------------
        if(c != null && c.getCount() != 0)
        {
            do{
                Log.i("table", "Sucessful start of loop");
                if( (username.equals(c.getString(nameIndex)) && password.equals(c.getString(passIndex))) )
                {
                    Log.i("table", "Sucessful user/ pass comparison");
                    this.username = username;
                   return true;
                }
            }while(c.moveToNext());
        }
        return false;
    }
  /*
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
   */
}
