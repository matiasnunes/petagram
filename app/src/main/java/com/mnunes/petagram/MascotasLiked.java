package com.mnunes.petagram;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasLiked extends AppCompatActivity {

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_liked);

        Toolbar toolbar = findViewById(R.id.miActionBar);

        setSupportActionBar(toolbar);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasLiked);

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


        mascotas.add(new Mascota(R.drawable.rabbit, "Coner"));
        mascotas.add(new Mascota(R.drawable.lovebird, "Rito"));
        mascotas.add(new Mascota(R.drawable.cat, "Maumau"));
        mascotas.add(new Mascota(R.drawable.hamster, "Jonstor"));
        mascotas.add(new Mascota(R.drawable.dog, "Peche"));

    }
}
