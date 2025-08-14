import java.util.ArrayList;
import java.util.List;

public class EvaluadorBonificacionesVisitor implements Visitor{

    private List<String> empleadosDestacados = new ArrayList<>();

    @Override
    public void visit(Medico medico) {
        if(medico.getAñosExperiencia() > 5 && medico.getPacientesAtendidos() > 100) {
            String mensaje = "Médico destacado: " + medico.getNombre() + " con " + medico.getAñosExperiencia() + " años de experiencia y " + medico.getPacientesAtendidos() + " pacientes atendidos.";
            empleadosDestacados.add(mensaje);
        }
    }

    @Override
    public void visit(Enfermero enfermero) {
        if(enfermero.gethorasTrabajadas() > 170 && enfermero.getPacientesCuidados() > 40){
            String mensaje = "Enfermero destacado: " + enfermero.getNombre() + " con " + enfermero.gethorasTrabajadas() + " horas trabajadas y " + enfermero.getPacientesCuidados() + " pacientes cuidados.";
            empleadosDestacados.add(mensaje);
        }
    }

    @Override
    public void visit(Administrativo administrativo) {
        if(administrativo.getHorasTrabajadas() > 150 && administrativo.getDocumentosProcesados() > 200){
            String mensaje = "Administrativo destacado: " + administrativo.getNombre() + " con " + administrativo.getHorasTrabajadas() + " horas trabajadas y " + administrativo.getDocumentosProcesados() + " documentos procesados.";
            empleadosDestacados.add(mensaje);
        }
    }

    public void mostrarEmpleadosDestacados() {
        for(String mensaje : empleadosDestacados) {
            System.out.println(mensaje);
        }
    }

    public List<String> getEmpleadosDestacados() {
        return empleadosDestacados;
    }
}
