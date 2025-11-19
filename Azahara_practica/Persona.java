package Azahara_practica;

import java.util.ArrayList;
import java.util.List;

//Atributos
public class Persona {
private String nombre;
private String apellidos;
private String DNI;
private int edad;
private long telefono;
private String email;
private String profesion;
private int Anyos_de_experiencia;

//Constructores
public Persona() {
}

public Persona(String nombre, String apellidos, String DNI, int edad, long telefono, String email, String profesion, int Anyos_de_experiencia) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.DNI = DNI;
    this.edad = edad;
    this.telefono = telefono;
    this.email = email;
    this.profesion = profesion;
    this.Anyos_de_experiencia = Anyos_de_experiencia;
}

//Setters
public void setEdad (int edad) {
if (edad > 0) {
this.edad = edad;
} else {
this.edad = 0;
}
}
public void setNombre (String nombre) {
this.nombre = nombre;
}
public void setApellidos (String apellidos) {
this.apellidos = apellidos;
}
public void setDNI (String DNI) {
this.DNI = DNI;
}
public void setTelefono (long telefono) {
this.telefono = telefono;
}
public void setEmail (String email) {
this.email = email;
}
public void setProfesion (String profesion) {
this.profesion = profesion;
}
public void setAnyos_de_experiencia (int Anyos_de_experiencia) {
this.Anyos_de_experiencia = Anyos_de_experiencia;
}

//Getters
public String getNombre () {return nombre;
}
public String getApellidos () {return apellidos;
}
public String getDNI () {return DNI;
}
public int getEdad () {return edad;
}
public long getTelefono () {return telefono;
}
public String getEmail () {return email;
}
public String getProfesion () {return profesion;
}
public int getAnyos_de_experiencia () {return Anyos_de_experiencia;
}

//Metodos
public void estaJubilado()
{
    if (this.edad>65)
    {System.out.println("Jubilado");}
    else {System.out.println("No jubilado");}
}

public void mostrarInfo() {
    System.out.println("Persona: " + this.nombre + " " + this.apellidos + " - DNI: " + this.DNI +
                       " - Edad: " + this.edad + " - Teléfono: " + this.telefono + " - Email: " + this.email +
                       " - Profesión: " + this.profesion + " - Años: " + this.Anyos_de_experiencia);
}

}
