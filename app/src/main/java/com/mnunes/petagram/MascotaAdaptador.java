package com.mnunes.petagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    public MascotaAdaptador( ArrayList<Mascota> mascotas ) { this.mascotas = mascotas; }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(( parent.getContext())).inflate(R.layout.activity_detalle_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                        mascota.setLikes( mascota.getLikes() + 1 );
                        mascotaViewHolder.tvLikes.setText( String.valueOf(mascota.getLikes()));
            }
        });
    }

    @Override
    public int getItemCount() { return mascotas.size(); };

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            btnLike = (ImageButton) itemView.findViewById(R.id.imgButton);
        }
    }
}


