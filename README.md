# Preguntas de teoría

## Clases Creadas y Propósito

### 1. **Persona**
**Propósito**: Representar a cualquier persona en el sistema con información básica.

### 2. **Usuario**
**Propósito**: Representar a los clientes de la biblioteca que pueden pedir libros prestados.

### 3. **Empleado**
**Propósito**: Representar al personal de la biblioteca que gestiona libros y atiende a usuarios.

### 4. **Libro**
**Propósito**: Representar un libro genérico con información básica

### 5. **LibroFisico**
**Propósito**: Representar libros físicos que están guardados en una ubicación específica en la biblioteca.

### 6. **LibroDigital**
**Propósito**: Representar libros digitales con información de formato y tamaño de archivo.

### 7. **Sala**
**Propósito**: Representar un espacio físico en la biblioteca

### 8. **SalaLectura**
**Propósito**: Sala especializada para leer

### 9. **SalaEstudio** 
**Propósito**: Sala para estudiar en grupo con mesas para trabajar

### 10. **SalaInformatica**
**Propósito**: Sala con pcs

### 11. **Biblioteca**
**Propósito**: La clase central que gestiona todo el sistema: libros, salas, personas y sus relaciones

## Cómo Se Usan las Clases 

### Paso 1: Crear la Biblioteca
```java
Biblioteca central = new Biblioteca("Biblioteca Central", "Calle Mayor 100", 8, 22);
```

### Paso 2: Crear Libros
```java
LibroFisico libroFisico1 = new LibroFisico("Don Quijote", "ISBN-001", "Planeta", "Español", 950, 1605, true, "Estantería A-1");
LibroDigital libroDigital1 = new LibroDigital("1984", "ISBN-004", "Minotauro", "Español", 350, 1949, true, "PDF", 2.8);
central.addLibro(libroFisico1);
central.addLibro(libroDigital1);
```

### Paso 3: Crear Salas
```java
SalaLectura salaLectura = new SalaLectura("Sala de Lectura", 30, false, "Lectura", true, null);
central.addSala(salaLectura);
```

### Paso 4: Crear Personas
```java
Usuario usuario1 = new Usuario("Laura", "Fernández", "22222222D", 24, 612345678L, "laura@email.com", "Estudiante", 0, 1);
Empleado empleado1 = new Empleado("María", "Rodríguez", "87654321B", 32, 685654321L, "maria@biblioteca.es", "Bibliotecario", 8, "Bibliotecario", 1800.00);
central.addPersona(usuario1);
central.addPersona(empleado1);
```

### Paso 5: Asociar Personas a Salas
```java
central.asignarResponsable(salaLectura, empleado1);  
salaLectura.addLibro(libroFisico1);  
```

### Paso 6: Simular Actividades
```java
salaLectura.entrarPersona(usuario1);             
empleado1.procesarPrestamo(usuario1, libroFisico1);  
usuario1.mostrarPrestamosPendientes();           
```

### Paso 7: Ver Toda la Información
```java
central.mostrarBiblioteca(); 
```
## Ejemplo de ejecución

<img width="1142" height="310" alt="imagen" src="https://i.imgur.com/wwklJ2f.png" />

## Respuesta a las preguntas de la actividad 8

### a. ¿Qué tipo de relación hay entre Biblioteca y Sala? ¿Por qué?

**Tipo de relación: COMPOSICIÓN**

La relación entre Biblioteca y Sala es de **composición** porque:

- **Propiedad exclusiva**: Las salas son creadas y pertenecen únicamente a la biblioteca
- **Ciclo de vida vinculado**: Las salas no pueden existir sin una biblioteca que las contenga
 **Responsabilidad de gestión**: La biblioteca es responsable completa de crear, almacenar y eliminar las salas

### b. ¿Qué pasaría con las salas si se destruye la biblioteca?

Si se destruyera la Biblioteca:

- **Las salas desaparecerían** porque están contenidas en la lista `List<Sala> salas` de la biblioteca
- **Pérdida de contexto**: Las salas perderían su propósito sin la biblioteca

### c. ¿En qué se diferencia la agregación de la composición en tu código?

#### **COMPOSICIÓN (Biblioteca → Sala)**
```java
private List<Sala> salas;

public void addSala(Sala sala) {
    this.salas.add(sala);
}
```

**Características**:
- Las salas **no existen sin la biblioteca**
- Si la biblioteca se destruye, las salas también

#### **AGREGACIÓN (Biblioteca → Libro)**
```java
private List<Libro> libros;

public void addLibro(Libro libro) {
    this.libros.add(libro);
}
```

**Características**:
- Los libros **pueden existir sin la biblioteca**
- Si la biblioteca se destruye, los libros siguen existiendo

### d. ¿Por qué tiene sentido que LibroDigital y LibroFisico hereden de Libro?

**Respuesta: Porque comparten atributos y comportamientos comunes**

### e. ¿Qué ventaja ofrece la herencia al definir distintos tipos de personas?

- **Evita duplicación**: No repetimos Titulo, ISBN, Editorial en cada subclase
- **Polimorfismo**: Podemos tratar ambos tipos como `Libro`:
- **Comportamientos especializados**: Cada tipo implementa métodos propios:
- **Reutilización de código**: `mostrarInfo()` se hereda, evitando repetición

### f. ¿Dónde usarías @Override en tu implementación?

#### **@Override se usa cuando una clase “hija” quiere cambiar o mejorar el comportamiento de un método que ya existe en su clase “padre”. Es como decir: “Oye compilador, este método sustituye al de la clase de arriba”.**
