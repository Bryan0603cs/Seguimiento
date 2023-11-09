package com.seguimiento2;

import java.util.List;

public interface Prestamo {
    void registrarPrestamo(PrestamoRegistro prestamo);
    void registrarDevolucion(PrestamoRegistro prestamo);
    List<PrestamoRegistro> obtenerPrestamosPorLibro(Libro libro);
}


