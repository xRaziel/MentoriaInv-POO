public class Enfermero extends Empleado{
    private String turno;
    private int horasTrabajadas;
    private int pacientesCuidados;

    public Enfermero(String nombre, String rut, Double sueldoBase, String turno, int horasTrabajadas, int pacientesCuidados) {
        super(nombre, rut, sueldoBase);
        this.turno = turno;
        this.horasTrabajadas = horasTrabajadas;
        this.pacientesCuidados = pacientesCuidados;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    public int gethorasTrabajadas() {
        return horasTrabajadas;
    }
    public void sethorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    public int getPacientesCuidados() {
        return pacientesCuidados;
    }
    public void setPacientesCuidados(int pacientesCuidados) {
        this.pacientesCuidados = pacientesCuidados;
    }
}
