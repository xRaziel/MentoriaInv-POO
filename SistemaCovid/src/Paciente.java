public abstract class Paciente {

    protected String idPaciente;
    protected String nombrePaciente;
    protected Comuna comuna;

    public Paciente(String idPaciente, String nombrePaciente, Comuna comuna) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.comuna = comuna;
    }

    public abstract String getTipoPaciente();

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
}
