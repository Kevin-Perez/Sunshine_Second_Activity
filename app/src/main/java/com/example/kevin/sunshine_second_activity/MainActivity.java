package com.example.kevin.sunshine_second_activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_forecast);


        ArrayList<Clima> datos = new ArrayList<Clima>();

        datos.add(new Clima(R.drawable.nublado, "Lunes", "Nublado","18°c/24°c"));
        datos.add(new Clima(R.drawable.soleado, "Martes", "Soleado","26°c/32°c"));
        datos.add(new Clima(R.drawable.lluvioso, "Miercoles", "Lluvioso","18°c/22°c"));
        datos.add(new Clima(R.drawable.lluvioso, "Jueves", "Lluvioso","18°c/24°c"));
        datos.add(new Clima(R.drawable.nublado, "Viernes", "Nublado","20°c/26°c"));
        datos.add(new Clima(R.drawable.tormentas, "Sabado", "Tormentas electricas","16°c/20°c"));
        datos.add(new Clima(R.drawable.soleado, "Domingo", "Soleado","24°c/30°c"));


        lista = (ListView) findViewById(R.id.ListView);
        lista.setAdapter(new ClimaAdapter(this, R.layout.fragment_main, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.dia);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Clima) entrada).getDia());

                    TextView texto_grados_entrada = (TextView) view.findViewById(R.id.temperatura);
                    if (texto_grados_entrada != null)
                        texto_grados_entrada.setText(((Clima) entrada).getTemperatura());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.clima);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Clima) entrada).getEstado());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.icono);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Clima) entrada).getIcono());
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Clima elegido = (Clima) pariente.getItemAtPosition(posicion);
                Intent clima = new Intent(MainActivity.this, SecondActivity.class);
                clima.putExtra("dia", elegido.getDia());
                clima.putExtra("temperatura", elegido.getTemperatura());
                clima.putExtra("estado", elegido.getEstado());
                startActivity(clima);
            }
        });
    }
}
