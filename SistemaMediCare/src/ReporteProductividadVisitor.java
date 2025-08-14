import java.util.ArrayList;
import java.util.List;

public class ReporteProductividadVisitor implements Visitor{
    List<String> reportes = new ArrayList<>();

    @Override
    public void visit(Medico medico) {
        double productividad = medico.getPacientesAtendidos() / (double)medico.getAñosExperiencia();
        String reporte = "Médico: " + medico.getNombre() + ", Productividad: " + productividad + " pacientes/año de experiencia.";
        reportes.add(reporte);
    }

    @Override
    public void visit(Enfermero enfermero) {
        double productividad = enfermero.getPacientesCuidados() / (double)enfermero.gethorasTrabajadas();
        String reporte = "Enfermero: " + enfermero.getNombre() + ", Productividad: " + productividad + " pacientes/hora trabajada.";
        reportes.add(reporte);
    }

    @Override
    public void visit(Administrativo administrativo) {
        double productividad = administrativo.getDocumentosProcesados() / (double)administrativo.getHorasTrabajadas();
        String reporte = "Administrativo: " + administrativo.getNombre() + ", Productividad: " + productividad + " documentos/hora trabajada.";
        reportes.add(reporte);
    }

    public List<String> getReportes() {
        return reportes;
    }

    public void mostrarReportes() {
        for(String reporte : reportes) {
            System.out.println(reporte);
        }
    }
}
