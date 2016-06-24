package cotemig.com.br.gym;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

//    EditText editText = (EditText) findViewById(R.id.editText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        editText.addTextChangedListener(new TextWatcher() {
//            // depois de terminar de escrever
//            public void afterTextChanged(Editable s) {}
//            // antes da ultima edição
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//            //edição em tempo real
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String test = editText.getText().toString();
//                Log.d("Teste",test);
//            }
//        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = new LatLng(-19.92450, -43.93524);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 13));

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions()
                .title("Belo Horizonte")
                .snippet("Hello Word!")
                .position(location)
        );

        CameraPosition cameraPosition =  CameraPosition.builder()
                .target(location)
                .zoom(13)
                .bearing(90)
                .build();
    }

    public void clickBusca(View view) {
        Intent it =  new Intent(MapsActivity.this, BuscaActivity.class);
        startActivity(it);
    }

    public void clickFiltro(View view) {
        Intent it = new Intent(MapsActivity.this, FiltroActivity.class);
        startActivity(it);
    }
}
