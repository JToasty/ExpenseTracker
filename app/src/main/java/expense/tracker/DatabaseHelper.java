package expense.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

    //Child Table for total transactions
    public static final String TRANSACTIONS_TABLE = "transactions";
    public static final String COL_TRANSACTION = "TRANSACT";
    public static final String COL_TYPE = "TYPE";
    public static final String COL_AMOUNT = "AMOUNT";
    public static final String COL_CURRENCY = "CURRENCY";
    public static final String COL_DESC = "DESCRIPTION";


    public static final String strSeparator = "__,__";
    //Child Table for transactions
    /*
     *Transactions
     * name    type    amount     currency     desc
     * Leroy   array{}
     */

    public static String username = "";
    private static final String CREATE_TABLE_LOGIN = "CREATE TABLE IF NOT EXISTS "
            + USER_LOGIN_TABLE + " ("
            + COL_USERNAME + " VARCHAR PRIMARY KEY NOT NULL,"
            + COL_PASSWORD + " VARCHAR)";


    private static final String CREATE_TABLE_IncomeExpense = "CREATE TABLE IF NOT EXISTS "
            + INCOME_EXPENSE_TABLE + " ("
            + COL_USERNAME + " VARCHAR,"
            + COL_INCOME + " REAL DEFAULT 0.0,"
            + COL_EXPENSE + " REAL DEFAULT 0.0)";

    private static final String CREATE_TABLE_TRANSACTIONS = "CREATE TABLE IF NOT EXISTS " + TRANSACTIONS_TABLE + " ("
            + COL_USERNAME + " VARCHAR,"
            + COL_TRANSACTION + " VARCHAR,"
            + COL_TYPE + " VARCHAR,"
            + COL_AMOUNT + " REAL,"
            + COL_CURRENCY + " VARCHAR,"
            + COL_DESC + " VARCHAR)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        Log.d("table", CREATE_TABLE_LOGIN);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LOGIN);
        db.execSQL(CREATE_TABLE_IncomeExpense);
        db.execSQL(CREATE_TABLE_TRANSACTIONS);

        db.execSQL("INSERT INTO " + USER_LOGIN_TABLE + " (USERNAME, PASSWORD ) VALUES ('Jenkins2', '1234')");
        db.execSQL("INSERT INTO " + INCOME_EXPENSE_TABLE + " (USERNAME, INCOME, EXPENSE ) VALUES ('Jenkins2', 6000.00, 1560.99 )");
        db.execSQL("INSERT INTO " + TRANSACTIONS_TABLE + " (USERNAME, TRANSACT, TYPE, AMOUNT, CURRENCY, DESCRIPTION ) VALUES ('Jenkins2', 'Expense', 'Food', '100.00', 'USD', 'Test 123' )");

        db.execSQL("INSERT INTO " + USER_LOGIN_TABLE + " (USERNAME, PASSWORD ) VALUES ('Shakira', 'HipsDontLie27')");
        db.execSQL("INSERT INTO " + USER_LOGIN_TABLE + " (USERNAME, PASSWORD ) VALUES ('Admin', '4321')");
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

    public String getIncome()
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
                    return c.getString(incomeIndex);
                }
            }while(c.moveToNext());
        }
        return "0";
    }

    public String getExpense()
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
                    return c.getString(expenseIndex);
                }
            }while(c.moveToNext());
        }
        c.close();
        return "0";
    }

    public void addExpense(String username, String type, String amount, String currency, String description)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;

        ArrayList<String> newType;
        ArrayList<String> newAmount;
        ArrayList<String> newCurrency;
        ArrayList<String> newDesc;

        String query = "SELECT * FROM " + TRANSACTIONS_TABLE + " WHERE USERNAME = '" + username + "'";

        c = db.rawQuery(query, null);

        int nameIndex = c.getColumnIndex(COL_USERNAME);
        int typeIndex = c.getColumnIndex(COL_TYPE);
        int amountIndex = c.getColumnIndex(COL_AMOUNT);
        int currencyIndex = c.getColumnIndex(COL_CURRENCY);
        int descIndex = c.getColumnIndex(COL_DESC);

        c.moveToFirst();
        if(c != null && c.getCount() != 0)
        {
            do{
                if( (username.equals(c.getString(nameIndex))))
                {
                    //convert String to aray to arraylist, add new element, convert to String and save
                    newType = new ArrayList<>(Arrays.asList(convertStringToArray(c.getString(typeIndex))));
                    newAmount = new ArrayList<>(Arrays.asList(convertStringToArray(c.getString(amountIndex))));
                    newCurrency = new ArrayList<>(Arrays.asList(convertStringToArray(c.getString(currencyIndex))));
                    newDesc = new ArrayList<>(Arrays.asList(convertStringToArray(c.getString(descIndex))));
                    newType.add(type);
                    newAmount.add(amount);
                    newCurrency.add(currency);
                    newDesc.add(description);

                    ContentValues contentValues = new ContentValues();
                    contentValues.put(COL_TYPE,convertArrayToString(newType));
                    contentValues.put(COL_AMOUNT,convertArrayToString(newAmount));
                    contentValues.put(COL_CURRENCY,convertArrayToString(newCurrency));
                    contentValues.put(COL_DESC,convertArrayToString(newDesc));

                    db.update(TRANSACTIONS_TABLE, contentValues, "USERNAME = " + username + "AND TRANSACT = EXPENSE",null);
                    return;
                }
            }while(c.moveToNext());
        }
        c.close();
    }

    public void addIncome(String username, String type, String amount, String currency, String description)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;

        ArrayList<String> newType;
        ArrayList<String> newAmount;
        ArrayList<String> newCurrency;
        ArrayList<String> newDesc;

        String query = "SELECT * FROM " + TRANSACTIONS_TABLE + " WHERE USERNAME = '" + username + "'";

        c = db.rawQuery(query, null);

        int nameIndex = c.getColumnIndex(COL_USERNAME);
        int typeIndex = c.getColumnIndex(COL_TYPE);
        int amountIndex = c.getColumnIndex(COL_AMOUNT);
        int currencyIndex = c.getColumnIndex(COL_CURRENCY);
        int descIndex = c.getColumnIndex(COL_DESC);

        c.moveToFirst();
        if(c != null && c.getCount() != 0)
        {
            do{
                if( (username.equals(c.getString(nameIndex))))
                {
                    //convert String to array to arraylist, add new element, convert to String and save
                    newType = new ArrayList<>(Arrays.asList(convertStringToArray(c.getString(typeIndex))));
                    newAmount = new ArrayList<>(Arrays.asList(convertStringToArray(c.getString(amountIndex))));
                    newCurrency = new ArrayList<>(Arrays.asList(convertStringToArray(c.getString(currencyIndex))));
                    newDesc = new ArrayList<>(Arrays.asList(convertStringToArray(c.getString(descIndex))));
                    newType.add(type);
                    newAmount.add(amount);
                    newCurrency.add(currency);
                    newDesc.add(description);

                    ContentValues contentValues = new ContentValues();
                    contentValues.put(COL_TYPE,convertArrayToString(newType));
                    contentValues.put(COL_AMOUNT,convertArrayToString(newAmount));
                    contentValues.put(COL_CURRENCY,convertArrayToString(newCurrency));
                    contentValues.put(COL_DESC,convertArrayToString(newDesc));

                    db.update(TRANSACTIONS_TABLE, contentValues, "USERNAME = " + username + "AND TRANSACT = INCOME" + username,null);
                    return;
                }
            }while(c.moveToNext());
        }
        c.close();
    }

    public String[][] getTransactions(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;

        String query = "SELECT * FROM " + TRANSACTIONS_TABLE + " WHERE USERNAME = '" + username + "'";

        c = db.rawQuery(query, null);
        int nameIndex = c.getColumnIndex(COL_USERNAME);
        int typeIndex = c.getColumnIndex(COL_TYPE);
        int amountIndex = c.getColumnIndex(COL_AMOUNT);
        int currencyIndex = c.getColumnIndex(COL_CURRENCY);
        int descIndex = c.getColumnIndex(COL_DESC);


        c.moveToFirst();
        if(c != null && c.getCount() != 0)
        {
            do{
                Log.i("table", "Sucessful start of loop");
                if( (username.equals(c.getString(nameIndex))))
                {
                    String[][] all = {
                            convertStringToArray(c.getString(typeIndex)),
                            convertStringToArray(c.getString(amountIndex)),
                            convertStringToArray(c.getString(currencyIndex)),
                            convertStringToArray(c.getString(descIndex))
                    };
                    return all;
                }
            }while(c.moveToNext());
        }
        c.close();
        return new String[0][0];
    }

    private static String[] convertStringToArray(String str){
        String[] arr = str.split(strSeparator);
        return arr;
    }

    private static String convertArrayToString(ArrayList<String> array) {
        String str = "";
        for (int i = 0; i < array.size(); i++) {
            str = str + array.get(i);
            if (i < array.size() - 1) {
                str = str + strSeparator;
            }

        }
        return str;
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
        c.close();
        return false;
    }
}
