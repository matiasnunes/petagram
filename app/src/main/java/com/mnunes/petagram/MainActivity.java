package com.mnunes.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        ArrayList<String> nombresMascota = new ArrayList<>();
        for ( Mascota mascota : mascotas )
        {
            nombresMascota.add(mascota.getNombre());
        }

    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.cat, "Maumau"));
        mascotas.add(new Mascota(R.drawable.dog, "Peche"));
        mascotas.add(new Mascota(R.drawable.hamster, "Jonstor"));
        mascotas.add(new Mascota(R.drawable.rabbit, "Coner"));
        mascotas.add(new Mascota(R.drawable.lovebird, "Rito"));

    }

    public void verMascotasLiked( View v ){
        Log.i("COSO", "Hola");
        Intent intent = new Intent(this, MascotasLiked.class );
        startActivity( intent );
    }

}