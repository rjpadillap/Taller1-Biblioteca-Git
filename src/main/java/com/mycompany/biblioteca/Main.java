package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
            System.out.println("--- Clientes ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("--- Libros ---");
            System.out.println("6. Crear libro");
            System.out.println("7. Listar libros");
            System.out.println("8. Buscar libro");
            System.out.println("9. Actualizar libro");
            System.out.println("10. Eliminar libro");
            System.out.println("--- Préstamos ---");
            System.out.println("11. Registrar préstamo");
            System.out.println("12. Registrar devolución");
            System.out.println("13. Listar préstamos activos");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: createClient(); break;
                case 2: listClients(); break;
                case 3:
                    System.out.print("ID del cliente a buscar: ");
                    Client c = findClient(sc.nextLine());
                    System.out.println(c != null ? c : "Cliente no encontrado.");
                    break;
                case 4: updateClient(); break;
                case 5: deleteClient(); break;
                case 6: createBook(); break;
                case 7: listBooks(); break;
                case 8:
                    System.out.print("Código del libro a buscar: ");
                    Book b = findBook(sc.nextLine());
                    System.out.println(b != null ? b : "Libro no encontrado.");
                    break;
                case 9: updateBook(); break;
                case 10: deleteBook(); break;
                case 11: createLoan(); break;
                case 12: returnLoan(); break;
                case 13: listLoans(); break;
                case 0: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }

    static void createClient() {
        System.out.println("\n--- Crear Cliente ---");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.print("Teléfono: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Client client = new Client(id, name, phone, email);
        clients.add(client);
        System.out.println("Cliente creado exitosamente.");
    }

    static void listClients() {
        System.out.println("\n--- Lista de Clientes ---");
        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Client c : clients) {
                System.out.println(c);
            }
        }
    }

    static Client findClient(String id) {
        for (Client c : clients) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    static void updateClient() {
        System.out.println("\n--- Actualizar Cliente ---");
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        String id = sc.nextLine();

        Client client = findClient(id);
        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (" + client.getName() + "): ");
        String name = sc.nextLine();
        System.out.print("Nuevo teléfono (" + client.getPhone() + "): ");
        String phone = sc.nextLine();
        System.out.print("Nuevo email (" + client.getEmail() + "): ");
        String email = sc.nextLine();

        client.setName(name);
        client.setPhone(phone);
        client.setEmail(email);

        System.out.println("Cliente actualizado exitosamente.");
    }

    static void deleteClient() {
        System.out.println("\n--- Eliminar Cliente ---");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String id = sc.nextLine();

        Client client = findClient(id);
        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        clients.remove(client);
        System.out.println("Cliente eliminado exitosamente.");
    }

    static void createBook() {
        System.out.println("\n--- Crear Libro ---");
        System.out.print("Código: ");
        String code = sc.nextLine();
        System.out.print("Título: ");
        String title = sc.nextLine();
        System.out.print("Año de publicación: ");
        String publicationYear = sc.nextLine();
        System.out.print("Autor: ");
        String author = sc.nextLine();

        Book book = new Book(code, title, publicationYear, author);
        books.add(book);
        System.out.println("Libro creado exitosamente.");
    }

    static void listBooks() {
        System.out.println("\n--- Lista de Libros ---");
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    static Book findBook(String code) {
        for (Book b : books) {
            if (b.getCode().equals(code)) {
                return b;
            }
        }
        return null;
    }

    static void updateBook() {
        System.out.println("\n--- Actualizar Libro ---");
        System.out.print("Ingrese el código del libro a actualizar: ");
        String code = sc.nextLine();

        Book book = findBook(code);
        if (book == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.print("Nuevo título (" + book.getTitle() + "): ");
        String title = sc.nextLine();
        System.out.print("Nuevo año de publicación (" + book.getPublicationYear() + "): ");
        String publicationYear = sc.nextLine();
        System.out.print("Nuevo autor (" + book.getAuthor() + "): ");
        String author = sc.nextLine();

        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setAuthor(author);

        System.out.println("Libro actualizado exitosamente.");
    }

    static void deleteBook() {
        System.out.println("\n--- Eliminar Libro ---");
        System.out.print("Ingrese el código del libro a eliminar: ");
        String code = sc.nextLine();

        Book book = findBook(code);
        if (book == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        books.remove(book);
        System.out.println("Libro eliminado exitosamente.");
    }

    static void createLoan() {
        System.out.println("\n--- Registrar Préstamo ---");
        System.out.print("ID del cliente: ");
        String clientId = sc.nextLine();
        Client client = findClient(clientId);
        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Código del libro: ");
        String bookCode = sc.nextLine();
        Book book = findBook(bookCode);
        if (book == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("El libro no está disponible para préstamo.");
            return;
        }

        System.out.print("ID del préstamo: ");
        String loanId = sc.nextLine();

        Loan loan = new Loan(loanId, client, book, LocalDate.now(), "activo");
        loans.add(loan);
        book.setAvailable(false);

        System.out.println("Préstamo registrado exitosamente.");
    }

    static void returnLoan() {
        System.out.println("\n--- Registrar Devolución ---");
        System.out.print("ID del préstamo: ");
        String loanId = sc.nextLine();

        Loan foundLoan = null;
        for (Loan l : loans) {
            if (l.getLoanId().equals(loanId)) {
                foundLoan = l;
                break;
            }
        }

        if (foundLoan == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        if (foundLoan.getStatus().equals("devuelto")) {
            System.out.println("Este préstamo ya fue devuelto.");
            return;
        }

        foundLoan.setStatus("devuelto");
        foundLoan.getBook().setAvailable(true);

        System.out.println("Devolución registrada exitosamente.");
    }

    static void listLoans() {
        System.out.println("\n--- Lista de Préstamos Activos ---");
        boolean hasActive = false;
        for (Loan l : loans) {
            if (l.getStatus().equals("activo")) {
                System.out.println(l);
                hasActive = true;
            }
        }
        if (!hasActive) {
            System.out.println("No hay préstamos activos.");
        }
    }
    
}