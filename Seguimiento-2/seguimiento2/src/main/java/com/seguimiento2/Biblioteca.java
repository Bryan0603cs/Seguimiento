package com.seguimiento2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Biblioteca implements Prestamo {
    private List<Libro> libros;
    private List<Cliente> clientes;
    private Collection<PrestamoRegistro> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        clientes = new ArrayList<>();
        prestamos = new LinkedList<>();
    }
  
    // implementa el método "obtener prestamos por libro" de la interfaz, para generar una lista de prestamos con un libro dado
    @Override
    public List<PrestamoRegistro> obtenerPrestamosPorLibro(Libro libro) {
        return prestamos.stream()
                .filter(prestamo -> prestamo.getLibro() == libro)
                .collect(Collectors.toList());
    }

    // permite obtener el listado del método anterior, dado un libro

    public Collection<PrestamoRegistro> getPrestamosPorLibro(Libro libro) {
        return Collections.unmodifiableCollection(obtenerPrestamosPorLibro(libro));
    }

    // permite buscar libros, dado el nombre de un autor
    public List<Libro> buscarLibrosPorAutor(String autor) {
        return libros.stream()
                .filter(libro -> libro.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    // permite buscar libros, dado el título del libro
    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.<Libro>toList());
    }

    // Permite registrar un libro en la lista de libros de la biblioteca
    public void registrarLibros(Libro libro) {
        validarLibroExiste(libro);
        libros.add(libro);
    }

    // Permite eliminar un libro de la biblioteca
    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    // Valida la existencia de un libro, antes de registrarlo
    private void validarLibroExiste(Libro libro) {
        boolean existeLibro = libros.stream()
                .anyMatch(l -> l.getTitulo().equals(libro.getTitulo()));
        assert !existeLibro : "El libro ya está registrado";
}

    // Permite registrar un cliente de la biblioteca
   public void registrarCliente(Cliente cliente) {
        validarClienteExiste(cliente);
        clientes.add(cliente);
    }


    //Valida la existencia del cliente a registrar, para que, en el caso de que ya exista registrado dicho clinete, no se permita volver a registrarlo
    private void validarClienteExiste(Cliente cliente) {
        boolean existeCliente = clientes.stream()
                .anyMatch(l -> l.getNombre().equals(cliente.getNombre()));
        assert !existeCliente : "El libro ya está registrado";
}   
    // Permite eliminar un cliente de la lista de la biblioteca
    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    // implementa el método "registrar prestamo" de la interfaz, para poder registrar el prestamo de un libro de la biblioteca y lo manda a la coleccion "prestamos"
    @Override
    public void registrarPrestamo(PrestamoRegistro prestamo) {
        if(esValidoPrestar(prestamo.getLibro())){
            prestamos.add(prestamo);
        }
        else
        {
            System.out.println("no más existen ejemplares disponibles de este libro para prestar");}
    }

    // permite validar el prestamo de un libro, dependiendo de la cantidad de ejemplares registrados y de la cantidad de ejemplares prestados de un libro    
    public boolean esValidoPrestar(Libro libro) {
        int cantidadEjemplares = libro.getEjemplaresDisponibles();
        int cantidadPrestados = (int) prestamos.stream()
                .filter(registro -> registro.getLibro().equals(libro))
                .filter(registro -> registro.getFechaDevolucion().equals(null))
                .count();

        return cantidadPrestados < cantidadEjemplares;
    }

    // Devuelve la lista de prestamos de la biblioteca
    public Collection<PrestamoRegistro> getPrestamos (){
        return Collections.unmodifiableCollection(prestamos);
    }

    // implementa el método "registrar devolucion" de la interfaz, para poder registrar el la devolucion de un libro de la biblioteca 
    //y cambia la fecha de devolucion en el listado de prestamos, de null a la fecha en que se entregó
    @Override
    public void registrarDevolucion(PrestamoRegistro prestamo) {
        validarDevolucion(prestamo);
        prestamo.setFechaDevolucion(LocalDate.now());
    }

    // busca un el registro de un prestamo, dado el libro y la fecha del prestamo
    private Optional<PrestamoRegistro> buscarPrestamo (Libro libro, LocalDate FechaPrestamo) {
        Predicate <PrestamoRegistro> condicion1 = registro->registro.getLibro().equals(libro);
        Predicate <PrestamoRegistro> condicion2 = registro->registro.getFechaPrestamo().equals(FechaPrestamo);
        return prestamos.stream().filter(condicion1.and(condicion2)).findAny();
} 

    // valida que el prestamo si exista y que no se halla registrado fecha de devolucion, para poder registrar la devolucion
    private void validarDevolucion (PrestamoRegistro prestamo) {
        boolean existePrestamo = buscarPrestamo(prestamo.getLibro(), prestamo.getFechaPrestamo()).isPresent();
        assert existePrestamo && prestamo.getFechaDevolucion().equals(null) : " El préstamo no está registrado";
    }

    // pone en una coleccion los prestamos registrados dado un cliente
    private Collection<PrestamoRegistro> prestamoCliente (Cliente cliente) {
        Predicate <PrestamoRegistro> condicion1 = registro->registro.getCliente().equals(cliente);
        return prestamos.stream().filter(condicion1).toList();
}

    // devuelve la coleccion de prestamos registrados de un cliente
    public Collection<PrestamoRegistro> getPrestamoCliente(Cliente cliente) {
        return prestamoCliente(cliente);
}
}

