public class Medico extends Empleado{
    private String especialidad;
    private int añosExperiencia;
    private int pacientesAtendidos;

    public Medico(String nombre, String rut, Double sueldoBase, String especialidad, int añosExperiencia, int pacientesAtendidos) {
        super(nombre, rut, sueldoBase);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.pacientesAtendidos = pacientesAtendidos;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getAñosExperiencia() {
        return añosExperiencia;
    }
    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }
    public void setPacientesAtendidos(int pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

}
