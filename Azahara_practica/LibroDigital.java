package Azahara_practica;

public class LibroDigital extends Libro {
    
    //Atributos adicionales
    private String formato;
    private double tamañoMB;
    
    //Constructores
    public LibroDigital() {
        super();
    }
    
    public LibroDigital(String titulo, String isbn, String editorial, String idioma, 
                        int numPaginas, int anyo, boolean disponible, String formato, double tamañoMB) {
        super(titulo, isbn, editorial, idioma, numPaginas, anyo, disponible);
        this.formato = formato;
        this.tamañoMB = tamañoMB;
    }
    
    //Setters
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    public void setTamañoMB(double tamañoMB) {
        this.tamañoMB = tamañoMB;
    }
    
    //Getters
    public String getFormato() {
        return formato;
    }
    
    public double getTamañoMB() {
        return tamañoMB;
    }
    
    //Métodos
    public void mostrarInfoDigital() {
        System.out.println("LIBRO DIGITAL");
        this.mostrarInfo();
        System.out.println("Formato: " + this.formato + " - Tamaño: " + this.tamañoMB + " MB");
    }
    
    public void descargarLibro() {
        if (this.getDisponible_reserva()) {
            System.out.println("Descargando \"" + this.getTitulo() + "\" (" + this.formato + ", " + this.tamañoMB + " MB)");
        } else {
            System.out.println("Libro no disponible");
        }
    }
}
