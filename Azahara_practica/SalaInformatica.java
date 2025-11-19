package Azahara_practica;

public class SalaInformatica extends Sala {
    
    //Atributos adicionales
    private int numEquipos;
    
    //Constructores
    public SalaInformatica() {
        super();
    }
    
    public SalaInformatica(String nombre, int capacidad, boolean pizarra, String tipo, 
                           boolean disponibleParaReserva, Persona personaResponsable, int numEquipos) {
        super(nombre, capacidad, pizarra, tipo, disponibleParaReserva, personaResponsable);
        this.numEquipos = numEquipos;
    }
    
    //Setters
    public void setNumEquipos(int numEquipos) {
        this.numEquipos = numEquipos;
    }
    
    //Getters
    public int getNumEquipos() {
        return numEquipos;
    }
    
    //Métodos
    public void mostrarInfoEquipos() {
        System.out.println("Sala: " + this.getNombre() + " Equipos: " + this.numEquipos);
    }
    
    public void verificarEquiposDisponibles() {
        int personasPresentes = this.getPersonas().size();
        int equiposDisponibles = this.numEquipos - personasPresentes;
        System.out.println("Equipos disponibles: " + equiposDisponibles + "/" + this.numEquipos);
    }
    
    public void mostrarOcupacion() {
        System.out.println("Ocupación de " + this.getNombre());
        System.out.println("Equipos: " + this.numEquipos);
        System.out.println("En uso: " + this.getPersonas().size() + "/" + this.numEquipos);
    }
}
