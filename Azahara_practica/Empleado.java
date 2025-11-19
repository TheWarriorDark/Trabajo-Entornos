package Azahara_practica;

public class Empleado extends Persona {
    
    //Atributos adicionales
    private String puesto;
    private double sueldo;
    
    //Constructores
    public Empleado() {
        super();
    }
    
    public Empleado(String nombre, String apellidos, String dni, int edad, long telefono, 
                    String email, String profesion, int anyosExperiencia, String puesto, double sueldo) {
        super(nombre, apellidos, dni, edad, telefono, email, profesion, anyosExperiencia);
        this.puesto = puesto;
        this.sueldo = sueldo;
    }
    
    //Setters
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //Getters
    public String getPuesto() {
        return puesto;
    }
    
    public double getSueldo() {
        return sueldo;
    }
    
    //Métodos
    public void realizarAtencion(Usuario usuario) {
        System.out.println(this.getNombre() + " (" + this.puesto + ") atiende a " + usuario.getNombre());
    }
    
    public void registrarDevolucion(Usuario usuario, Libro libro) {
        usuario.devolverPrestamo(libro);
        System.out.println(this.getNombre() + " registra devolución");
    }
    
    public void procesarPrestamo(Usuario usuario, Libro libro) {
        usuario.pedirPrestamo(libro);
        System.out.println(this.getNombre() + " procesa préstamo");
    }
    
    public void mostrarInfoEmpleado() {
        System.out.println("EMPLEADO: " + this.getNombre());
        this.mostrarInfo();
        System.out.println("Puesto: " + this.puesto);
        System.out.println("Sueldo: " + String.format("%.2f", this.sueldo) + "€");
    }
    
    public void aplicarAumento(double porcentaje) {
        double aumento = this.sueldo * (porcentaje / 100);
        this.sueldo += aumento;
        System.out.println("Aumento a " + this.getNombre() + ": " + String.format("%.2f", aumento) + "€");
        System.out.println("Nuevo sueldo: " + String.format("%.2f", this.sueldo) + "€");
    }
}
