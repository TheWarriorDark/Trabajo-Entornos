package Azahara_practica;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    //Atributos
    private String nombre;
    private String direccion;
    private int horarioApertura;
    private int horarioCierre;
    private List<Libro> libros;
    private List<Sala> salas;

    //Constructores
    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    public Biblioteca(String nombre, String direccion, int horarioApertura, int horarioCierre) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.libros = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHorarioApertura(int horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public void setHorarioCierre(int horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getHorarioApertura() {
        return horarioApertura;
    }

    public int getHorarioCierre() {
        return horarioCierre;
    }

    //Métodos para gestionar Libros
    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }

    public void removeLibro(Libro libro) {
        this.libros.remove(libro);
    }

    public List<Libro> getLibros() {
        return this.libros;
    }

    //Métodos para gestionar Salas
    public void addSala(Sala sala) {
        this.salas.add(sala);
    }

    public void removeSala(Sala sala) {
        this.salas.remove(sala);
    }

    public List<Sala> getSalas() {
        return this.salas;
    }

    //Método para mostrar libros disponibles
    public void mostrarLibrosDisponibles() {
        System.out.println("\n--- Libros disponibles en " + this.nombre + " ---");
        if (this.libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (Libro libro : this.libros) {
                if (libro.getDisponible_reserva()) {
                    libro.mostrarInfo();
                }
            }
        }
    }

    //Método para mostrar salas disponibles
    public void mostrarSalasDisponibles() {
        System.out.println("\n--- Salas disponibles (sin personas) en " + this.nombre + " ---");
        if (this.salas.isEmpty()) {
            System.out.println("No hay salas en la biblioteca.");
        } else {
            boolean hayDisponibles = false;
            for (Sala sala : this.salas) {
                if (sala.getPersonas().isEmpty()) {
                    System.out.println("  - " + sala.getNombre() + " (Capacidad: " + sala.getCapacidad() + ", Personas: 0)");
                    hayDisponibles = true;
                }
            }
            if (!hayDisponibles) {
                System.out.println("No hay salas disponibles (todas tienen personas).");
            }
        }
    }

    //Método para mostrar todas las salas con número de personas
    public void mostrarSalas() {
        System.out.println("\n--- Todas las salas en " + this.nombre + " ---");
        if (this.salas.isEmpty()) {
            System.out.println("No hay salas registradas en la biblioteca.");
        } else {
            for (Sala sala : this.salas) {
                int numPersonas = sala.getPersonas().size();
                System.out.println("  - " + sala.getNombre() + " (Capacidad: " + sala.getCapacidad() + ", Personas: " + numPersonas + "/" + sala.getCapacidad() + ")");
            }
        }
    }

    //Método para contar el total de personas en todas las salas
    public int totalPersonas() {
        int total = 0;
        for (Sala sala : this.salas) {
            total += sala.getPersonas().size();
        }
        return total;
    }

    //Método para mostrar el total de personas en todas las salas
    public void mostrarTotalPersonas() {
        int total = totalPersonas();
        System.out.println("\nTotal de personas en todas las salas de " + this.nombre + ": " + total);
    }

    //Método para buscar libro por título
    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : this.libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    //Método para mostrar toda la biblioteca
    public void mostrarBiblioteca() {
        System.out.println("\n========== BIBLIOTECA: " + this.nombre.toUpperCase() + " ==========");
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Horario: " + this.horarioApertura + ":00 - " + this.horarioCierre + ":00");
        
        System.out.println("\n--- LIBROS (" + this.libros.size() + ") ---");
        if (this.libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro libro : this.libros) {
                libro.mostrarInfo();
            }
        }
        
        System.out.println("\n--- SALAS (" + this.salas.size() + ") ---");
        if (this.salas.isEmpty()) {
            System.out.println("No hay salas registradas.");
        } else {
            for (Sala sala : this.salas) {
                sala.mostrarInfo();
            }
        }
        System.out.println("==========================================\n");
    }

    //Método para saber si está abierta la biblioteca a una hora dada
    public void estaAbierta(int hora) {
        if (hora >= this.horarioApertura && hora < this.horarioCierre) {
            System.out.println("A las " + hora + ":00, la biblioteca está abierta.");
        } else {
            System.out.println("A las " + hora + ":00, la biblioteca está cerrada.");
        }
    }
    //Método para mostrar info de la biblioteca
    public void mostrarInfo() {
        System.out.println("Biblioteca: " + this.nombre + " - " + this.direccion +
                           ". Abierto de " + this.horarioApertura + ":00 a " + this.horarioCierre + ":00.");
    }
}