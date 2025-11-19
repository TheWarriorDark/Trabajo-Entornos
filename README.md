# Análisis de Relaciones y Diseño OOP - Sistema de Biblioteca

## Preguntas de Análisis

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
