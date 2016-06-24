package cotemig.com.br.gym;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBManager {

    private static DBHelper dbHelper = null;

    public DBManager (Context context){
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }
    }

    public ArrayList<String> getallDados() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT nome FROM dados";
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<String> dados = null;
        if (cursor != null && cursor.moveToFirst()){
            dados = new ArrayList<String>();

            do {
                dados.add(cursor.getString(0));
            } while ( cursor.moveToNext());
        }

        return dados;
    }
}
