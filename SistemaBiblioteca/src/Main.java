import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA UNIVERSITARIA ===\n");

        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // 1. Agregar materiales
        System.out.println("1. AGREGANDO MATERIALES...");
        sistema.agregarMaterial(new Libro("L001", "Algoritmos y Estructuras de Datos", "Cormen", 2020));
        sistema.agregarMaterial(new Libro("L002", "Programación en Java", "Deitel", 2019));
        sistema.agregarMaterial(new Revista("R001", "Nature", "Editorial Nature", 2023));
        sistema.agregarMaterial(new Revista("R002", "Science", "AAAS", 2023));
        sistema.agregarMaterial(new Tesis("T001", "IA en Diagnóstico Médico", "García López", 2023));
        sistema.agregarMaterial(new Tesis("T002", "Redes Neuronales Cuánticas", "Rodríguez", 2022));
        System.out.println("Materiales agregados exitosamente.\n");

        // 2. Registrar usuarios
        System.out.println("2. REGISTRANDO USUARIOS...");
        sistema.registrarUsuario(new Estudiante("E001", "Juan Pérez", "juan.perez@universidad.edu"));
        sistema.registrarUsuario(new Estudiante("E002", "María González", "maria.gonzalez@universidad.edu"));
        sistema.registrarUsuario(new Profesor("P001", "Dr. Carlos Smith", "carlos.smith@universidad.edu"));
        sistema.registrarUsuario(new Investigador("I001", "Dra. Ana Torres", "ana.torres@universidad.edu"));
        System.out.println("Usuarios registrados exitosamente.\n");

        // 3. Realizar préstamos
        System.out.println("3. REALIZANDO PRÉSTAMOS...");
        System.out.println(sistema.realizarPrestamo("E001", "L001"));
        System.out.println(sistema.realizarPrestamo("E001", "R001"));
        System.out.println(sistema.realizarPrestamo("P001", "L002"));
        System.out.println(sistema.realizarPrestamo("P001", "T001"));
        System.out.println(sistema.realizarPrestamo("I001", "T002"));

        // Intentar préstamo que debe fallar
        System.out.println("\n--- Probando validaciones ---");
        System.out.println(sistema.realizarPrestamo("E002", "L001")); // Material no disponible
        System.out.println();

        // 4. Buscar materiales por autor
        System.out.println("4. BÚSQUEDA POR AUTOR 'Cormen':");
        List<MaterialBibliografico> resultados = sistema.buscarMaterialesPorAutor("Cormen");
        resultados.forEach(System.out::println);
        System.out.println();

        // 5. Procesar algunas devoluciones
        System.out.println("5. PROCESANDO DEVOLUCIONES...");
        System.out.println(sistema.procesarDevolucion("E001", "R001"));
        System.out.println(sistema.procesarDevolucion("P001", "L002"));
        System.out.println();

        // 6. Verificar usuarios con retrasos (en este caso no habrá porque acabamos de crear los préstamos)
        System.out.println("6. USUARIOS CON RETRASOS:");
        List<Usuario> usuariosConRetraso = sistema.obtenerUsuariosConRetrasos();
        if (usuariosConRetraso.isEmpty()) {
            System.out.println("No hay usuarios con retrasos actualmente.");
        } else {
            usuariosConRetraso.forEach(System.out::println);
        }
        System.out.println();

        // 7. Generar reporte de estadísticas
        System.out.println("7. REPORTE DE ESTADÍSTICAS:");
        System.out.println(sistema.generarReporteEstadisticas());

        // 8. Demostración adicional - más préstamos para mostrar estadísticas
        System.out.println("8. REALIZANDO MÁS PRÉSTAMOS PARA DEMOSTRACIÓN...");
        sistema.realizarPrestamo("E002", "R002");
        sistema.realizarPrestamo("I001", "R001"); // Ahora disponible

        System.out.println("\n=== REPORTE FINAL ===");
    }
}