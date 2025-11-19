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
    private List<Persona> personas;

    //Constructores
    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public Biblioteca(String nombre, String direccion, int horarioApertura, int horarioCierre) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.libros = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.personas = new ArrayList<>();
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

    //Métodos para gestionar Personas
    public void addPersona(Persona persona) {
        this.personas.add(persona);
    }

    public void removePersona(Persona persona) {
        this.personas.remove(persona);
    }

    public List<Persona> getPersonas() {
        return this.personas;
    }

    //Método para asignar responsable a una sala (Asociación)
    public void asignarResponsable(Sala sala, Persona persona) {
        sala.setPersonaResponsable(persona);
        System.out.println("Responsable asignado: " + persona.getNombre() + " en " + sala.getNombre());
    }

    //Métodos para registrar visitas y préstamos (Dependencia)
    public void registrarVisita(Persona persona) {
        this.personas.add(persona);
        System.out.println("Visita: " + persona.getNombre());
    }

    public void registrarPrestamo(Persona persona, Libro libro) {
        if (this.libros.contains(libro) && libro.getDisponible_reserva()) {
            this.personas.add(persona);
            libro.setDisponible_reserva(false);
            System.out.println("Préstamo: " + persona.getNombre() + " toma " + libro.getTitulo());
        } else {
            System.out.println("Libro no disponible");
        }
    }

    public void devolverLibro(Persona persona, Libro libro) {
        libro.setDisponible_reserva(true);
        System.out.println("Devolución: " + persona.getNombre() + " devuelve " + libro.getTitulo());
    }

    //Método para mostrar libros disponibles
    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles en " + this.nombre);
        if (this.libros.isEmpty()) {
            System.out.println("No hay libros");
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
        System.out.println("Salas disponibles en " + this.nombre);
        if (this.salas.isEmpty()) {
            System.out.println("No hay salas");
        } else {
            boolean hayDisponibles = false;
            for (Sala sala : this.salas) {
                if (sala.getPersonas().isEmpty()) {
                    System.out.println(sala.getNombre() + " - Capacidad: " + sala.getCapacidad());
                    hayDisponibles = true;
                }
            }
            if (!hayDisponibles) {
                System.out.println("No hay salas sin personas");
            }
        }
    }

    //Método para mostrar todas las salas con número de personas
    public void mostrarSalas() {
        System.out.println("Salas en " + this.nombre);
        if (this.salas.isEmpty()) {
            System.out.println("No hay salas");
        } else {
            for (Sala sala : this.salas) {
                int numPersonas = sala.getPersonas().size();
                System.out.println(sala.getNombre() + " - Capacidad: " + sala.getCapacidad() + " - Personas: " + numPersonas + "/" + sala.getCapacidad());
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
        System.out.println("Total de personas: " + total);
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
        System.out.println("Biblioteca: " + this.nombre);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Horario: " + this.horarioApertura + ":00 - " + this.horarioCierre + ":00");
        
        System.out.println("Libros (" + this.libros.size() + ")");
        if (!this.libros.isEmpty()) {
            for (Libro libro : this.libros) {
                libro.mostrarInfo();
            }
        } else {
            System.out.println("No hay libros");
        }
        
        System.out.println("Salas (" + this.salas.size() + ")");
        if (!this.salas.isEmpty()) {
            for (Sala sala : this.salas) {
                sala.mostrarInfo();
                Persona responsable = sala.getPersonaResponsable();
                if (responsable != null) {
                    System.out.println("  Responsable: " + responsable.getNombre());
                }
            }
        } else {
            System.out.println("No hay salas");
        }
        
        System.out.println("Personas registradas (" + this.personas.size() + ")");
        if (!this.personas.isEmpty()) {
            for (Persona persona : this.personas) {
                if (persona instanceof Usuario) {
                    ((Usuario) persona).mostrarInfoUsuario();
                } else if (persona instanceof Empleado) {
                    ((Empleado) persona).mostrarInfoEmpleado();
                } else {
                    persona.mostrarInfo();
                }
            }
        } else {
            System.out.println("No hay personas");
        }
    }

    //Método para saber si está abierta la biblioteca a una hora dada
    public void estaAbierta(int hora) {
        if (hora >= this.horarioApertura && hora < this.horarioCierre) {
            System.out.println("A las " + hora + ":00, abierta");
        } else {
            System.out.println("A las " + hora + ":00, cerrada");
        }
    }
    //Método para mostrar info de la biblioteca
    public void mostrarInfo() {
        System.out.println("Biblioteca: " + this.nombre + " - " + this.direccion +
                           ". Abierto de " + this.horarioApertura + ":00 a " + this.horarioCierre + ":00.");
    }
}