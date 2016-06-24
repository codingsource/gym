package cotemig.com.br.gym;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    private static int DV_VERSION = 1;
    private static String DB_NAME = "academia";

    private static String TABLES_DADOS =
            "CREATE TABLE dados("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nome TEXT,"+
            "categoria TEXT,"+
            "regiao TEXT,"+
            "preco NUMERIC(10,2),"+
            "latitude TEXT,"+
            "longitude TEXT"+");";

    private static String TABLES_LOCALIZACAO =
            "CREATE TABLE localizacao("+
                    "id INTEGER PRIMARY KEY,"+
                    "nome TEXT,"+
                    "latitude TEXT,"+
                    "longitude TEXT"+");";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DV_VERSION);
    }

    @Override // Quando o banco de dadcos é criado
    public void onCreate(SQLiteDatabase db) {
        //Cria a tabela no banco de dados academia

        db.execSQL(TABLES_LOCALIZACAO);
        db.execSQL(TABLES_DADOS);
        //Já crio o banco com as empresas
        // caso apareçam novas empresas será feito um parte administrativa web para inserir as novas empresas no banco de dados
        //Professor essa parte não será feita pelo app.
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Malhação','Malhação','Centro','69,99','-19.935758','-13.934599');");
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Fitness','Luta','Sul','79,99','-19.970890','-23.965421');");
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Smart','All','Norte','89,99','-19.814257','-33.960590');");
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Ação','Malhação','Centro','69,99','-19.935758','-43.934599');");
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Academia Transpira','Luta','Sul','79,99','-19.970890','-53.965421');");
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Artes Marciais e Malhação','All','Norte','89,99','-19.814257','-63.960590');");
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Fortes','Malhação','Centro','69,99','-19.935758','-73.934599');");
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Bombados','Luta','Sul','79,99','-19.970890','-83.965421');");
            db.execSQL("INSERT INTO dados (nome,categoria,regiao,preco,latitude,longitude) Values ('Dance/Fight','All','Norte','89,99','-19.814257','-93.960590');");
    }

    @Override // Quando existe uma atualização
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoAtual) {

    }
}
