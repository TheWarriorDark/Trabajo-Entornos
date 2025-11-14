package Azahara_practica;

import java.util.ArrayList;
import java.util.List;

//Atributos
public class Libro {
private String Titulo;
private String ISBN;
private String Editorial;
private String Idioma;
private int N_paginas;
private int Anyo;
private boolean Disponible_reserva;

//Constructores
public Libro() {
}

public Libro(String Titulo, String ISBN, String Editorial, String Idioma, int N_paginas, int Anyo, boolean Disponible_reserva) {
    this.Titulo = Titulo;
    this.ISBN = ISBN;
    this.Editorial = Editorial;
    this.Idioma = Idioma;
    this.N_paginas = N_paginas;
    this.Anyo = Anyo;
    this.Disponible_reserva = Disponible_reserva;
}

//Setters
public void setTitulo (String Titulo) {
this.Titulo = Titulo;
}
public void setISBN (String ISBN) {
this.ISBN = ISBN;
}
public void setEditorial (String Editorial) {
this.Editorial = Editorial;
}
public void setIdioma (String Idioma) {
this.Idioma = Idioma;
}
public void setN_paginas (int N_paginas) {
this.N_paginas = N_paginas;
}
public void setAnyo (int Anyo) {
this.Anyo = Anyo;
}
public void setDisponible_reserva (boolean Disponible_reserva) {
this.Disponible_reserva = Disponible_reserva;
}

//Getters
public String getTitulo () {return Titulo;
}
public String getISBN () {return ISBN;
}
public String getEditorial () {return Editorial;
}
public String getIdioma () {return Idioma;
}
public int getN_paginas () {return N_paginas;
}
public int getAnyo () {return Anyo;
}
public boolean getDisponible_reserva () {return Disponible_reserva;
}

//Metodos
public void estaDisponible()
{
    if (this.Disponible_reserva)
    {System.out.println("Está disponible el libro.");}
    else {System.out.println("No está disponible el libro.");}
}

public void esExtranjero()
{
    if (this.Idioma.equals("Español"))
    {System.out.println("Está disponible en tu idioma.");}
    else {System.out.println("No está en tu idioma.");}
}

public void informacion() {
        String disponibilidad = this.Disponible_reserva ? "Está disponible" : "No está disponible";
        System.out.println("Libro: " + this.Titulo + " - " + this.Editorial + " (" + this.Anyo + "). " +
                           this.Idioma + ", " + this.N_paginas + " páginas. " + disponibilidad + ".");
    }

public void mostrarInfo() {
        String disponibilidad = this.Disponible_reserva ? "Está disponible" : "No está disponible";
        System.out.println("Libro: " + this.Titulo + " - " + this.Editorial + " (" + this.Anyo + "). " +
                           this.Idioma + ", " + this.N_paginas + " páginas. " + disponibilidad + ".");
    }
}
