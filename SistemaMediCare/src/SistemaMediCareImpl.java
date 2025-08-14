import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaMediCareImpl implements SistemaMediCare{
    private List<Empleado> empleados;
    private Map<String, Double> sueldosBase;

    public SistemaMediCareImpl() {
        this.empleados = new ArrayList<>();
        this.sueldosBase = new HashMap<>();
        cargarDatos();
    }

    private void cargarDatos() {
        cargarSueldosBase();
        cargarMedicos();
        cargarEnfermeros();
        cargarAdministrativos();
    }

    private void cargarSueldosBase() {
        try (
            BufferedReader br = new BufferedReader(new FileReader("sueldos_base.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                sueldosBase.put(datos[0], Double.parseDouble(datos[1]));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los sueldos base: " + e.getMessage());
        }
    }

    private void cargarMedicos() {
        try (
            BufferedReader br = new BufferedReader(new FileReader("medicos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Medico medico = new Medico(datos[0], datos[1], sueldosBase.get("Medico"), datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
                empleados.add(medico);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los médicos: " + e.getMessage());
        }
    }

    private void cargarEnfermeros() {
        try (
            BufferedReader br = new BufferedReader(new FileReader("enfermeros.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Enfermero enfermero = new Enfermero(datos[0], datos[1], sueldosBase.get("Enfermero"), datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
                empleados.add(enfermero);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los enfermeros: " + e.getMessage());
        }
    }

    private void cargarAdministrativos() {
        try (
            BufferedReader br = new BufferedReader(new FileReader("administrativos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Administrativo administrativo = new Administrativo(datos[0], datos[1], sueldosBase.get("Administrativo"), datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
                empleados.add(administrativo);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los administrativos: " + e.getMessage());
        }
    }


    @Override
    public void aplicarVisitor(Visitor visitor) {
        for (Empleado empleado : empleados) {
            empleado.accept(visitor);
        }
    }

    @Override
    public void ejecutarOperaciones() {
        System.out.println("Ejecutando operaciones del sistema MediCare...");
        //1. Calcular nomina total
        System.out.println("1. Calcular nómina total:");
        CalculadoraNominaVisitor calculadoraNomina = new CalculadoraNominaVisitor();
        aplicarVisitor(calculadoraNomina);
        System.out.println("Nómina total: " + calculadoraNomina.getNominaTotal());

        //2. Reporte de productividad
        System.out.println("2. Reporte de productividad:");
        ReporteProductividadVisitor reporteProductividad = new ReporteProductividadVisitor();
        aplicarVisitor(reporteProductividad);
        System.out.println("Reporte de productividad generado.");
        reporteProductividad.mostrarReportes();

        //3.Estadísticas por departamento
        System.out.println("3. Estadísticas por departamento:");
        EstadisticasDepartamentoVisitor estadisticasDepartamento = new EstadisticasDepartamentoVisitor();
        aplicarVisitor(estadisticasDepartamento);
        System.out.println("Estadísticas por departamento generadas.");
        estadisticasDepartamento.mostrarEstadisticas();

        // 4. Evaluación de bonificaciones especiales
        System.out.println("4. Evaluación de bonificaciones especiales:");
        EvaluadorBonificacionesVisitor evaluadorBonificaciones = new EvaluadorBonificacionesVisitor();
        aplicarVisitor(evaluadorBonificaciones);
        System.out.println("Bonificaciones especiales evaluadas.");
        evaluadorBonificaciones.mostrarEmpleadosDestacados();

        // 5. Reporte de costos
        System.out.println("5. Reporte de costos:");
        ReporteCostosVisitor reporteCostos = new ReporteCostosVisitor();
        aplicarVisitor(reporteCostos);
        System.out.println("Reporte de costos generado.");
        reporteCostos.mostrarCostos();


    }
}
