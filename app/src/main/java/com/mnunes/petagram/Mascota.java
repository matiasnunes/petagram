package com.mnunes.petagram;

public class Mascota {

    public Mascota(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes = 0;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    private int foto;
    private String nombre;
    private int likes;
}
