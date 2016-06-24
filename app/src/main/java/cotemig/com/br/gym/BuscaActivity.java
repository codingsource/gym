package cotemig.com.br.gym;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by peterthomas on 08/06/16.
 */
public class BuscaActivity extends Activity {

    private static DBHelper dbHelper = null;
    SQLiteDatabase BancodeDados = null;
    String NomeBanco = "academia";

    EditText editText = (EditText) findViewById(R.id.editText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca);

        ArrayList<String> dados = new ArrayList<String>();
        DBManager dbManager = new DBManager(this);

        dados = dbManager.getallDados();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        final ListView listView = (ListView) findViewById(R.id.listViewAcademias);
        listView.setAdapter(adapter);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                //quando o texto é alterado chamamos o filtro.
                adapter.getFilter().filter(s.toString());
            }

            public void onItemClick (AdapterView<?> arg0, View arg1, int Posicao, long arg3){
                    GravaDados(Posicao);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    // Criar lógica para pegar o id do listView, buscar no banco de dados e inserir na tabela de localizacao
    public void GravaDados (int Posicao){
        BancodeDados = openOrCreateDatabase(NomeBanco, MODE_WORLD_READABLE, null);
        Cursor c = BancodeDados.rawQuery("Select id, nome, latitude, longitude from dados where id = '"+Posicao+"'", null);

        //SQLiteDatabase db = dbHelper.
    }

    public void Limpar(View view) {
        editText.setText("");
    }
}
