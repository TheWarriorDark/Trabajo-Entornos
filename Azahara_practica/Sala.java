package Azahara_practica;

import java.util.ArrayList;
import java.util.List;

public class Sala {

//Atributos
    private String nombre;
    private int capacidad;
    private boolean pizarra;
    private String tipo;
    private boolean disponibleParaReserva;
    private List<Persona> personas;
    private Persona personaResponsable; // Asociación: Sala → Persona

    //Constructores
    public Sala() {
        this.personas = new ArrayList<>();
    }

    public Sala(String nombre, int capacidad, boolean pizarra, String tipo, boolean disponibleParaReserva) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pizarra = pizarra;
        this.tipo = tipo;
        this.disponibleParaReserva = disponibleParaReserva;
        this.personas = new ArrayList<>();
    }

    public Sala(String nombre, int capacidad, boolean pizarra, String tipo, boolean disponibleParaReserva, Persona personaResponsable) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pizarra = pizarra;
        this.tipo = tipo;
        this.disponibleParaReserva = disponibleParaReserva;
        this.personas = new ArrayList<>();
        this.personaResponsable = personaResponsable;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPizarra(boolean pizarra) {
        this.pizarra = pizarra;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDisponibleParaReserva(boolean disponibleParaReserva) {
        this.disponibleParaReserva = disponibleParaReserva;
    }

    public void setPersonaResponsable(Persona personaResponsable) {
        this.personaResponsable = personaResponsable;
    }
      
    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isPizarra() {
        return pizarra;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponibleParaReserva() {
        return disponibleParaReserva;
    }

    public Persona getPersonaResponsable() {
        return personaResponsable;
    }

    //Metodos
    public void estaDisponible() {
        if (this.disponibleParaReserva) {
            System.out.println("Sala disponible para reserva");
        } else {
            System.out.println("Sala no disponible");
        }
    }

    public void tienePizarra() {
        if (this.pizarra) {
            System.out.println("Tiene pizarra");
        } else {
            System.out.println("Sin pizarra");
        }
    }

    public void informacion() {
        String textoPizarra = this.pizarra ? "con" : "sin";
        String textoDisponible = this.disponibleParaReserva ? "disponible" : "no disponible";

        System.out.println("Sala: " + this.nombre + " Capacidad: " + this.capacidad + " " +
                           this.tipo + " " + textoPizarra + " pizarra " + textoDisponible);
    }

    public void mostrarInfo() {
        String textoPizarra = this.pizarra ? "con" : "sin";
        String textoDisponible = this.disponibleParaReserva ? "disponible" : "no disponible";

        System.out.println("Sala: " + this.nombre + " Capacidad: " + this.capacidad + " " +
                           this.tipo + " " + textoPizarra + " pizarra " + textoDisponible);
    }

    //Métodos para gestionar Personas en la Sala
    public void entrarPersona(Persona p) {
        if (this.personas.size() < this.capacidad) {
            this.personas.add(p);
            System.out.println(p.getNombre() + " entra a " + this.nombre);
        } else {
            System.out.println("Sala llena");
        }
    }

    public void salirPersona(Persona p) {
        if (this.personas.remove(p)) {
            System.out.println(p.getNombre() + " sale de " + this.nombre);
        } else {
            System.out.println(p.getNombre() + " no estaba en la sala");
        }
    }

    public void mostrarPersonas() {
        System.out.println("Personas en " + this.nombre + " (" + this.personas.size() + "/" + this.capacidad + ")");
        if (this.personas.isEmpty()) {
            System.out.println("No hay personas");
        } else {
            for (Persona persona : this.personas) {
                System.out.println("- " + persona.getNombre());
            }
        }
    }

    public List<Persona> getPersonas() {
        return this.personas;
    }
}