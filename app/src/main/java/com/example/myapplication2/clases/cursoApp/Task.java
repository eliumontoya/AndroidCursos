package com.example.myapplication2.clases.cursoApp;

public class Task {
    private String nombre;
    private boolean isFinalizado;

    public Task(String nombre, boolean isFinalizado, TaskCategory categoria) {
        this.nombre = nombre;
        this.isFinalizado = isFinalizado;
        this.categoria = categoria;
    }

    private TaskCategory categoria;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isFinalizado() {
        return isFinalizado;
    }

    public void setFinalizado(boolean finalizado) {
        isFinalizado = finalizado;
    }

    public TaskCategory getCategoria() {
        return categoria;
    }

    public void setCategoria(TaskCategory categoria) {
        this.categoria = categoria;
    }
}
