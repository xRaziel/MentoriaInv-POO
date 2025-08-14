public class ReporteCostosVisitor implements Visitor{
    private double costoMedicos = 0;
    private double costoEnfermeros = 0;
    private double costoAdministrativos = 0;

    @Override
    public void visit(Medico medico) {
        double sueldo = medico.getSueldoBase();
        sueldo += medico.getAñosExperiencia() + 50000;
        sueldo += medico.getPacientesAtendidos() + 5000;

        if(medico.getAñosExperiencia() > 10){
            sueldo += 300000;
        }
        costoMedicos += sueldo;
    }

    @Override
    public void visit(Enfermero enfermero) {
        double sueldo = enfermero.getSueldoBase();
        if(enfermero.getTurno().equalsIgnoreCase("noche")) {
            sueldo += 200000; // Bonificación por turno nocturno
        }
        sueldo += enfermero.getPacientesCuidados() * 3000; // Sueldo por pacientes cuidados
        if (enfermero.gethorasTrabajadas() > 170) {
            sueldo += 150000; // Horas extras
        }
        costoEnfermeros += sueldo;
    }

    @Override
    public void visit(Administrativo administrativo) {
        double sueldo = administrativo.getSueldoBase();
        sueldo += administrativo.getDocumentosProcesados() * 1000; // Sueldo por documentos procesados

        if(administrativo.getHorasTrabajadas() > 150) {
            sueldo += 100000; // Bonificación por horas trabajadas extras
        }
        costoAdministrativos += sueldo;
    }
    
    public void mostrarCostos() {
        System.out.println("Reporte de Costos del Departamento:");
        System.out.println("Costo Total de Médicos: " + costoMedicos);
        System.out.println("Costo Total de Enfermeros: " + costoEnfermeros);
        System.out.println("Costo Total de Administrativos: " + costoAdministrativos);
        System.out.println("Costo Total del Departamento: " + (costoMedicos + costoEnfermeros + costoAdministrativos));
    }

    public double getCostoMedicos() {
        return costoMedicos;
    }

    public double getCostoEnfermeros() {
        return costoEnfermeros;
    }

    public double getCostoAdministrativos() {
        return costoAdministrativos;
    }
}
