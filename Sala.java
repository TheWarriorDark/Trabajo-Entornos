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

    //Metodos
    public void estaDisponible() {
        if (this.disponibleParaReserva) {
            System.out.println("La sala se encuentra disponible para su reserva.");
        } else {
            System.out.println("La sala no se encuentra disponible para su reserva.");
        }
    }

    public void tienePizarra() {
        if (this.pizarra) {
            System.out.println("La sala dispone de pizarra.");
        } else {
            System.out.println("La sala no dispone de pizarra.");
        }
    }

    public void informacion() {
        String textoPizarra = this.pizarra ? "dispone" : "no dispone";
        String textoDisponible = this.disponibleParaReserva ? "está" : "no está";

        System.out.println("Sala: " + this.nombre + " - " + this.capacidad + ". " +
                           "Se utiliza para " + this.tipo + ", " + textoPizarra + " de pizarra y " +
                           textoDisponible + " disponible para su reserva.");
    }

    public void mostrarInfo() {
        String textoPizarra = this.pizarra ? "dispone" : "no dispone";
        String textoDisponible = this.disponibleParaReserva ? "está" : "no está";

        System.out.println("Sala: " + this.nombre + " - " + this.capacidad + ". " +
                           "Se utiliza para " + this.tipo + ", " + textoPizarra + " de pizarra y " +
                           textoDisponible + " disponible para su reserva.");
    }

    //Métodos para gestionar Personas en la Sala
    public void entrarPersona(Persona p) {
        if (this.personas.size() < this.capacidad) {
            this.personas.add(p);
            System.out.println("La persona " + p.getNombre() + " ha entrado a la sala.");
        } else {
            System.out.println("No se puede añadir la persona. La sala está llena (capacidad: " + this.capacidad + ").");
        }
    }

    public void salirPersona(Persona p) {
        if (this.personas.remove(p)) {
            System.out.println("La persona " + p.getNombre() + " ha salido de la sala.");
        } else {
            System.out.println("La persona " + p.getNombre() + " no estaba en la sala.");
        }
    }

    public void mostrarPersonas() {
        System.out.println("\n--- Personas en la sala " + this.nombre + " (" + this.personas.size() + "/" + this.capacidad + ") ---");
        if (this.personas.isEmpty()) {
            System.out.println("No hay personas en la sala.");
        } else {
            for (Persona persona : this.personas) {
                System.out.println("  - " + persona.getNombre() + " " + persona.getApellidos());
            }
        }
    }

    public List<Persona> getPersonas() {
        return this.personas;
    }
}