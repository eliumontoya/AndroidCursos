package com.example.myapplication2.clases.cursoApp;

public class TaskCategory {
          private int id;

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskCategory(String nombre) {
        this.nombre = nombre;
    }

    public TaskCategory(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
