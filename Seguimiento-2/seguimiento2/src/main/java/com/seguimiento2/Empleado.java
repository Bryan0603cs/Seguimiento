package com.seguimiento2;

public class Empleado extends Persona{
    private CargoEmpleado cargo;

    public Empleado(String nombre, String apellido, int edad, CargoEmpleado cargo) {
        super(nombre, apellido, edad);

        assert cargo != null : "El cargo es requerido";

        this.cargo = cargo;
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


    public CargoEmpleado getCargo() {
        return cargo;
    }

    public void setCargo(CargoEmpleado cargo) {
        this.cargo = cargo;
    }
}
