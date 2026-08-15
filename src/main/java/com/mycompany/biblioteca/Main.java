package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Aquí irá el menú (Fase 8)
    }

static void crearCliente() {
    System.out.println("\n--- Crear Cliente ---");
    System.out.print("ID: ");
    String id = sc.nextLine();
    System.out.print("Nombre: ");
    String nombre = sc.nextLine();
    System.out.print("Teléfono: ");
    String telefono = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();

    Cliente cliente = new Cliente(id, nombre, telefono, email);
    clientes.add(cliente);
    System.out.println("Cliente creado exitosamente.");
}

static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

static Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }


static void actualizarCliente() {
        System.out.println("\n--- Actualizar Cliente ---");
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        String id = sc.nextLine();

        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (" + cliente.getNombre() + "): ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo teléfono (" + cliente.getTelefono() + "): ");
        String telefono = sc.nextLine();
        System.out.print("Nuevo email (" + cliente.getEmail() + "): ");
        String email = sc.nextLine();

        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);

        System.out.println("Cliente actualizado exitosamente.");
    }


static void eliminarCliente() {
        System.out.println("\n--- Eliminar Cliente ---");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String id = sc.nextLine();

        Cliente cliente = buscarCliente(id);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        clientes.remove(cliente);
        System.out.println("Cliente eliminado exitosamente.");
    }

static void crearLibro() {
        System.out.println("\n--- Crear Libro ---");
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Año de publicación: ");
        String anioPublicacion = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();

        Libro libro = new Libro(codigo, titulo, anioPublicacion, autor);
        libros.add(libro);
        System.out.println("Libro creado exitosamente.");
    }


static void listarLibros() {
        System.out.println("\n--- Lista de Libros ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }

static Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

static void actualizarLibro() {
        System.out.println("\n--- Actualizar Libro ---");
        System.out.print("Ingrese el código del libro a actualizar: ");
        String codigo = sc.nextLine();

        Libro libro = buscarLibro(codigo);
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.print("Nuevo título (" + libro.getTitulo() + "): ");
        String titulo = sc.nextLine();
        System.out.print("Nuevo año de publicación (" + libro.getAnioPublicacion() + "): ");
        String anioPublicacion = sc.nextLine();
        System.out.print("Nuevo autor (" + libro.getAutor() + "): ");
        String autor = sc.nextLine();

        libro.setTitulo(titulo);
        libro.setAnioPublicacion(anioPublicacion);
        libro.setAutor(autor);

        System.out.println("Libro actualizado exitosamente.");
    }



static void crearPrestamo() {
        System.out.println("\n--- Registrar Préstamo ---");
        System.out.print("ID del cliente: ");
        String idCliente = sc.nextLine();
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Código del libro: ");
        String codigoLibro = sc.nextLine();
        Libro libro = buscarLibro(codigoLibro);
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible para préstamo.");
            return;
        }

        System.out.print("ID del préstamo: ");
        String idPrestamo = sc.nextLine();

        Prestamo prestamo = new Prestamo(idPrestamo, cliente, libro, LocalDate.now(), "activo");
        prestamos.add(prestamo);
        libro.setDisponible(false);

        System.out.println("Préstamo registrado exitosamente.");
    }


}

