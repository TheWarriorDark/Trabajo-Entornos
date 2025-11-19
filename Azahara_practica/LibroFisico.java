package Azahara_practica;

public class LibroFisico extends Libro {
    
    //Atributos adicionales
    private int numPaginas;
    private String ubicacion;
    
    //Constructores
    public LibroFisico() {
        super();
    }
    
    public LibroFisico(String titulo, String isbn, String editorial, String idioma, 
                       int numPaginas, int anyo, boolean disponible, String ubicacion) {
        super(titulo, isbn, editorial, idioma, numPaginas, anyo, disponible);
        this.ubicacion = ubicacion;
    }
    
    //Setters
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    //Getters
    public String getUbicacion() {
        return ubicacion;
    }
    
    //Métodos
    public void mostrarInfoFisico() {
        System.out.println("LIBRO FÍSICO");
        this.mostrarInfo();
        System.out.println("Ubicación: " + this.ubicacion);
    }
    
    public void localizarLibro() {
        System.out.println("\"" + this.getTitulo() + "\" en " + this.ubicacion);
    }
}
