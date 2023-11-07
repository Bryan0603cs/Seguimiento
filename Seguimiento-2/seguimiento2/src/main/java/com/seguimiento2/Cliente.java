package com.seguimiento2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private int numeroCliente;
    private List<PrestamoRegistro> prestamos;

    public Cliente(String nombre, String apellido, int edad, int numeroCliente) {
        super(nombre, apellido, edad);
        this.numeroCliente = numeroCliente;
        this.prestamos = new ArrayList<>();
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

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public List<PrestamoRegistro> getPrestamos() {
        return prestamos;
    }

    public void prestarLibro(Libro libro, Biblioteca biblioteca, LocalDate FechaPrestamo) {
        if (biblioteca.prestarLibro(this, libro)) {
            prestamos.add(new PrestamoRegistro(libro, this,FechaPrestamo));
        }
    }

    public void devolverLibro(Libro libro, Biblioteca biblioteca) {
        if (biblioteca.devolverLibro(this, libro)) {
            prestamos.removeIf(prestamo -> prestamo.getLibro() == libro);
        }
    }
    
}
