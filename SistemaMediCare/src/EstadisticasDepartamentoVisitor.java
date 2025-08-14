public class EstadisticasDepartamentoVisitor implements Visitor{
    private int totalMedicos = 0;
    private int totalEnfermeros = 0;
    private int totalAdministrativos = 0;
    private int totalPacientesAtendidos = 0;
    private int totalPacientesCuidados = 0;
    private int totalDocumentosProcesados = 0;

    @Override
    public void visit(Medico medico) {
        totalMedicos++;
        totalPacientesAtendidos += medico.getPacientesAtendidos();
    }

    @Override
    public void visit(Enfermero enfermero) {
        totalEnfermeros++;
        totalPacientesCuidados += enfermero.getPacientesCuidados();
    }

    @Override
    public void visit(Administrativo administrativo) {
        totalAdministrativos++;
        totalDocumentosProcesados += administrativo.getDocumentosProcesados();
    }

    public void mostrarEstadisticas() {
        System.out.println("Estadísticas del Departamento:");
        System.out.println("Total de Médicos: " + totalMedicos);
        System.out.println("Total de Enfermeros: " + totalEnfermeros);
        System.out.println("Total de Administrativos: " + totalAdministrativos);
        System.out.println("Total de Pacientes Atendidos por Médicos: " + totalPacientesAtendidos);
        System.out.println("Total de Pacientes Cuidados por Enfermeros: " + totalPacientesCuidados);
        System.out.println("Total de Documentos Procesados por Administrativos: " + totalDocumentosProcesados);
    }

    public int getTotalMedicos() {
        return totalMedicos;
    }

    public int getTotalEnfermeros() {
        return totalEnfermeros;
    }

    public int getTotalAdministrativos() {
        return totalAdministrativos;
    }

    public int getTotalPacientesAtendidos() {
        return totalPacientesAtendidos;
    }

    public int getTotalPacientesCuidados() {
        return totalPacientesCuidados;
    }

    public int getTotalDocumentosProcesados() {
        return totalDocumentosProcesados;
    }
}
