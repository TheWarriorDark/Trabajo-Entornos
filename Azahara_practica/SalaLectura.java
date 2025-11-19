package Azahara_practica;

import java.util.ArrayList;
import java.util.List;

public class SalaLectura extends Sala {
    
    //Atributos adicionales
    private List<Libro> listaLibros;
    
    //Constructores
    public SalaLectura() {
        super();
        this.listaLibros = new ArrayList<>();
    }
    
    public SalaLectura(String nombre, int capacidad, boolean pizarra, String tipo, 
                       boolean disponibleParaReserva, Persona personaResponsable) {
        super(nombre, capacidad, pizarra, tipo, disponibleParaReserva, personaResponsable);
        this.listaLibros = new ArrayList<>();
    }
    
    //Setters
    public void addLibro(Libro libro) {
        this.listaLibros.add(libro);
    }
    
    public void removeLibro(Libro libro) {
        this.listaLibros.remove(libro);
    }
    
    //Getters
    public List<Libro> getListaLibros() {
        return listaLibros;
    }
    
    //Métodos
    public void mostrarLibrosDisponibles() {
        System.out.println("Libros en " + this.getNombre() + " (" + this.listaLibros.size() + ")");
        if (this.listaLibros.isEmpty()) {
            System.out.println("No hay libros");
        } else {
            for (Libro libro : this.listaLibros) {
                System.out.println("- " + libro.getTitulo());
            }
        }
    }
    
    public void prestarLibro(Usuario usuario, Libro libro) {
        if (this.listaLibros.contains(libro)) {
            usuario.pedirPrestamo(libro);
            this.listaLibros.remove(libro);
            System.out.println("Libro prestado desde " + this.getNombre());
        } else {
            System.out.println("Libro no disponible en esta sala");
        }
    }
    
    public void devolverLibroSala(Libro libro) {
        this.listaLibros.add(libro);
        System.out.println("Libro devuelto a " + this.getNombre());
    }
}
