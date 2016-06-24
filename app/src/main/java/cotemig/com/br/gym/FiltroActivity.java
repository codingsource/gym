package cotemig.com.br.gym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by peterthomas on 08/06/16.
 */
public class FiltroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);
    }

//    @Override
//    public void onBackPressed() {
//        Intent it = new Intent(FiltroActivity.this, MapsActivity.class);
//        startActivity(it);
//        finish();
//    }


    public void Cancelar(View v) {
//        Intent it = new Intent(FiltroActivity.this, MapsActivity.class);
//        startActivity(it);
//        finish();
        FiltroActivity.this.finish();
    }

    public void Limpar(View view) {

    }
}
