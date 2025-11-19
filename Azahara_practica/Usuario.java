package Azahara_practica;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    
    //Atributos adicionales
    private int numSocio;
    private List<Libro> listaLibrosPrestados;
    
    //Constructores
    public Usuario() {
        super();
        this.listaLibrosPrestados = new ArrayList<>();
    }
    
    public Usuario(String nombre, String apellidos, String dni, int edad, long telefono, 
                   String email, String profesion, int anyosExperiencia, int numSocio) {
        super(nombre, apellidos, dni, edad, telefono, email, profesion, anyosExperiencia);
        this.numSocio = numSocio;
        this.listaLibrosPrestados = new ArrayList<>();
    }
    
    //Setters
    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }
    
    //Getters
    public int getNumSocio() {
        return numSocio;
    }
    
    public List<Libro> getListaLibrosPrestados() {
        return listaLibrosPrestados;
    }
    
    //Métodos
    public void pedirPrestamo(Libro libro) {
        if (libro.getDisponible_reserva()) {
            this.listaLibrosPrestados.add(libro);
            libro.setDisponible_reserva(false);
            System.out.println("Préstamo: Usuario " + this.getNombre() + " (" + this.numSocio + ") toma " + libro.getTitulo());
        } else {
            System.out.println("Libro no disponible");
        }
    }
    
    public void devolverPrestamo(Libro libro) {
        if (this.listaLibrosPrestados.remove(libro)) {
            libro.setDisponible_reserva(true);
            System.out.println("Devolución: Usuario " + this.getNombre() + " devuelve " + libro.getTitulo());
        } else {
            System.out.println("Libro no en préstamo");
        }
    }
    
    public void mostrarPrestamosPendientes() {
        System.out.println("Préstamos de " + this.getNombre() + " (Socio #" + this.numSocio + ")");
        if (this.listaLibrosPrestados.isEmpty()) {
            System.out.println("No tiene préstamos");
        } else {
            for (Libro libro : this.listaLibrosPrestados) {
                System.out.println("- " + libro.getTitulo());
            }
        }
    }
    
    public void mostrarInfoUsuario() {
        System.out.println("USUARIO: " + this.getNombre());
        this.mostrarInfo();
        System.out.println("Socio: " + this.numSocio);
        System.out.println("Préstamos: " + this.listaLibrosPrestados.size());
    }
}
