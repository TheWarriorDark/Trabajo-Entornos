package Azahara_practica;

public class Main {
    
    public static void main(String[] args) {
        // a. Crear Biblioteca llamada "Central"
        Biblioteca central = new Biblioteca("Biblioteca Central", "Calle Mayor 100", 8, 22);
        
        // b. Crear distintos tipos de Libro
        LibroFisico libroFisico1 = new LibroFisico("Don Quijote", "ISBN-001", "Planeta", "Español", 950, 1605, true, "Estantería A-1");
        LibroFisico libroFisico2 = new LibroFisico("Cien años de soledad", "ISBN-002", "Sudamericana", "Español", 417, 1967, true, "Estantería B-3");
        LibroFisico libroFisico3 = new LibroFisico("La casa de los espíritus", "ISBN-003", "Planeta", "Español", 396, 1982, true, "Estantería C-2");
        
        LibroDigital libroDigital1 = new LibroDigital("1984", "ISBN-004", "Minotauro", "Español", 350, 1949, true, "PDF", 2.8);
        LibroDigital libroDigital2 = new LibroDigital("El Quijote Digital", "ISBN-005", "Planeta", "Español", 950, 1605, true, "EPUB", 4.5);
        LibroDigital libroDigital3 = new LibroDigital("Programación en Java", "ISBN-006", "Anaya", "Español", 456, 2020, false, "PDF", 5.2);
        
        // Añadir libros a la biblioteca
        central.addLibro(libroFisico1);
        central.addLibro(libroFisico2);
        central.addLibro(libroFisico3);
        central.addLibro(libroDigital1);
        central.addLibro(libroDigital2);
        central.addLibro(libroDigital3);
        
        // c. Crear distintas Personas (Empleados)
        Empleado empleadoJefe = new Empleado("Antonio", "García López", "12345678A", 45, 695123456L, "antonio@biblioteca.es", "Director", 20, "Director", 2500.00);
        Empleado empleadoBibliotecario = new Empleado("María", "Rodríguez Pérez", "87654321B", 32, 685654321L, "maria@biblioteca.es", "Bibliotecario", 8, "Bibliotecario", 1800.00);
        Empleado empleadoTecnico = new Empleado("Carlos", "Martínez Silva", "11111111C", 28, 681111111L, "carlos@biblioteca.es", "Técnico", 4, "Técnico Informática", 1600.00);
        
        // d. Crear Salas de diferentes tipos
        SalaLectura salaLectura = new SalaLectura("Sala de Lectura Silenciosa", 30, false, "Lectura", true, empleadoBibliotecario);
        salaLectura.addLibro(libroFisico1);
        salaLectura.addLibro(libroFisico2);
        
        SalaEstudio salaEstudio = new SalaEstudio("Sala de Estudio Grupal", 40, true, "Estudio", true, empleadoBibliotecario, 8);
        
        SalaInformatica salaInformatica = new SalaInformatica("Sala de Informática", 20, true, "Informática", true, empleadoTecnico, 12);
        
        Sala salaConferencias = new Sala("Sala de Conferencias", 100, true, "Conferencias", true, empleadoJefe);
        
        // Añadir salas a la biblioteca
        central.addSala(salaLectura);
        central.addSala(salaEstudio);
        central.addSala(salaInformatica);
        central.addSala(salaConferencias);
        
        // Crear Usuarios
        Usuario usuario1 = new Usuario("Laura", "Fernández García", "22222222D", 24, 612345678L, "laura@email.com", "Estudiante", 0, 001);
        Usuario usuario2 = new Usuario("Pablo", "López Hernández", "33333333E", 35, 623456789L, "pablo@email.com", "Ingeniero", 5, 002);
        Usuario usuario3 = new Usuario("Sofia", "Sánchez Martín", "44444444F", 19, 634567890L, "sofia@email.com", "Estudiante", 0, 003);
        Usuario usuario4 = new Usuario("Juan", "Torres Ruiz", "55555555G", 42, 645678901L, "juan@email.com", "Profesor", 15, 004);
        
        // Añadir usuarios a la biblioteca
        central.addPersona(usuario1);
        central.addPersona(usuario2);
        central.addPersona(usuario3);
        central.addPersona(usuario4);
        
        // Añadir empleados
        central.addPersona(empleadoJefe);
        central.addPersona(empleadoBibliotecario);
        central.addPersona(empleadoTecnico);
        
        // d. Asociar personas a salas
        central.asignarResponsable(salaLectura, empleadoBibliotecario);
        central.asignarResponsable(salaEstudio, empleadoBibliotecario);
        central.asignarResponsable(salaInformatica, empleadoTecnico);
        central.asignarResponsable(salaConferencias, empleadoJefe);
        
        // Simulación de personas usando las salas
        salaLectura.entrarPersona(usuario1);
        salaEstudio.entrarPersona(usuario2);
        salaEstudio.entrarPersona(usuario3);
        salaInformatica.entrarPersona(usuario4);
        
        // Registrar préstamos
        empleadoBibliotecario.procesarPrestamo(usuario1, libroFisico1);
        empleadoBibliotecario.procesarPrestamo(usuario2, libroDigital1);
        empleadoTecnico.procesarPrestamo(usuario4, libroDigital2);
        
        // Registrar visitas
        central.registrarVisita(usuario3);
        
        System.out.println("INFORMACIÓN COMPLETA DE LA BIBLIOTECA");
        
        // e. Mostrar toda la información
        central.mostrarBiblioteca();
        
        System.out.println("\nINFORMACIÓN DETALLADA DE SALAS\n");
        
        salaLectura.mostrarPersonas();
        System.out.println();
        salaLectura.mostrarLibrosDisponibles();
        System.out.println();
        
        salaEstudio.mostrarPersonas();
        System.out.println();
        salaEstudio.mostrarOcupacion();
        System.out.println();
        
        salaInformatica.mostrarPersonas();
        System.out.println();
        salaInformatica.mostrarOcupacion();
        System.out.println();
        
        salaConferencias.mostrarPersonas();
        System.out.println();
        
        System.out.println("\nINFORMACIÓN DE USUARIOS\n");
        
        usuario1.mostrarPrestamosPendientes();
        System.out.println();
        usuario2.mostrarPrestamosPendientes();
        System.out.println();
        usuario4.mostrarPrestamosPendientes();
        System.out.println();
        
        System.out.println("\nINFORMACIÓN DE EMPLEADOS\n");
        
        empleadoJefe.mostrarInfoEmpleado();
        System.out.println();
        empleadoBibliotecario.mostrarInfoEmpleado();
        System.out.println();
        empleadoTecnico.mostrarInfoEmpleado();
    }
}
