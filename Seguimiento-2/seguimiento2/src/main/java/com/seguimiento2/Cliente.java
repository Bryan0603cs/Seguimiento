package com.seguimiento2;

import java.util.Collection;


public class Cliente extends Persona{
    private String numeroCliente;
    private Biblioteca biblioteca;
    private Collection<PrestamoRegistro> prestamos;
    

    public Cliente(String nombre, String apellido, int edad, String numeroCliente) {
        super(nombre, apellido, edad);
        assert numeroCliente != null : "El número del cliente es requerido";
        this.numeroCliente = numeroCliente;
        this.prestamos = biblioteca.getPrestamoCliente(this);
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    // devuelve la coleccion de prestamos registrados de un cliente
    public Collection<PrestamoRegistro> getPrestamos(){
        return this.prestamos;
    }
}
