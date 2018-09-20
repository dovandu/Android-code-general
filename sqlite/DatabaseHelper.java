package vn.com.giait.tracnghiemlaixe.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vn.com.giait.tracnghiemlaixe.model.Bode;

/**
 * Created by VisH on 16-10-2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DBNAME = "thilaixe450.sqlite";
    public static final String DBLOCATION = "data/data/vn.com.giait.tracnghiemlaixe/databases/";
    private final Context mContext;
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper (Context context){
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase(){
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen()){
            return;
        }
        sqLiteDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase(){
        if (sqLiteDatabase !=null){
            sqLiteDatabase.close();
        }
    }

    public List<Bode> getListBode(){
        Bode bode = null;
        List<Bode> bodeList = new ArrayList<>();
        openDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BODE450", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            bode = new Bode(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getInt(6),cursor.getInt(7),cursor.getInt(8), cursor.getInt(9), cursor.getString(10));
            bodeList.add(bode);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return bodeList;
    }
}