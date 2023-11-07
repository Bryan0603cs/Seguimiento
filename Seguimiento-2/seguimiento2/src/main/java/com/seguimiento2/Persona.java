package com.seguimiento2;

public abstract class Persona {
    public String nombre;
    public String apellido;
    public int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public abstract String getNombre();
    public abstract void setNombre(String nombre);
    public abstract String getApellido();
    public abstract void setApellido(String apellido);
    public abstract int getEdad();
    public abstract void setEdad(int edad); 
}
