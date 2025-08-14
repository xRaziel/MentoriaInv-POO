public class CalculadoraNominaVisitor implements Visitor{
    private double nominaTotal = 0;

    @Override
    public void visit(Medico medico) {
        double sueldo = medico.getSueldoBase();
        sueldo += medico.getAñosExperiencia() + 50000;
        sueldo += medico.getPacientesAtendidos() + 5000;

        if(medico.getAñosExperiencia() > 10){
            sueldo += 300000;
        }
        nominaTotal += sueldo;
        System.out.println("Medico: " + medico.getNombre() + ", Sueldo: " + sueldo);
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
        nominaTotal += sueldo;
        System.out.println("Enfermero: " + enfermero.getNombre() + ", Sueldo: " + sueldo);
    }

    @Override
    public void visit(Administrativo administrativo) {
        double sueldo = administrativo.getSueldoBase();
        sueldo += administrativo.getDocumentosProcesados() * 1000; // Sueldo por documentos procesados

        if(administrativo.getHorasTrabajadas() > 150) {
            sueldo += 100000; // Bonificación por horas trabajadas extras
        }
        nominaTotal += sueldo;
        System.out.println("Administrativo: " + administrativo.getNombre() + ", Sueldo: " + sueldo);
    }

    public double getNominaTotal() {
        return nominaTotal;
    }

    public void resetNominaTotal() {
        nominaTotal = 0;
    }


}
