package com.mycompany.biblioteca;

public class Libro extends Material {
    private String autor;
    private boolean disponible;

    public Libro(String codigo, String titulo, String anioPublicacion, String autor) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.disponible = true;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                ", autor='" + autor + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
