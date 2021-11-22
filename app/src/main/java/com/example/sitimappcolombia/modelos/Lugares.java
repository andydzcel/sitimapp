package com.example.sitimappcolombia.modelos;

public class Lugares {
    private int id_lug;
    private String nombre;
    private String descripcion;
    private Double longitud;
    private Double latitud;
    private String categoria;
    private float calificacion;

    public Lugares(){

    }

    public int getId_lug() {
        return id_lug;
    }

    public void setId_lug(int id_lug) {
        this.id_lug = id_lug;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
}
