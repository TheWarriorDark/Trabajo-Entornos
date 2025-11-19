package Azahara_practica;

public class SalaEstudio extends Sala {
    
    //Atributos adicionales
    private int numMesas;
    
    //Constructores
    public SalaEstudio() {
        super();
    }
    
    public SalaEstudio(String nombre, int capacidad, boolean pizarra, String tipo, 
                       boolean disponibleParaReserva, Persona personaResponsable, int numMesas) {
        super(nombre, capacidad, pizarra, tipo, disponibleParaReserva, personaResponsable);
        this.numMesas = numMesas;
    }
    
    //Setters
    public void setNumMesas(int numMesas) {
        this.numMesas = numMesas;
    }
    
    //Getters
    public int getNumMesas() {
        return numMesas;
    }
    
    //Métodos
    public void mostrarInfoMesas() {
        System.out.println("Sala: " + this.getNombre() + " Mesas: " + this.numMesas);
    }
    
    public void calcularPersonasPorMesa() {
        int personas = this.getPersonas().size();
        if (this.numMesas > 0) {
            double mediaPersonas = (double) personas / this.numMesas;
            System.out.println("Personas por mesa: " + String.format("%.2f", mediaPersonas));
        } else {
            System.out.println("No hay mesas");
        }
    }
    
    public void mostrarOcupacion() {
        System.out.println("Ocupación de " + this.getNombre());
        System.out.println("Mesas: " + this.numMesas);
        System.out.println("Personas: " + this.getPersonas().size() + "/" + this.getCapacidad());
    }
}
