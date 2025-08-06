public class PacienteAsintomatico extends Paciente{

    private String fechaPCR;

    public PacienteAsintomatico(String idPaciente, String nombrePaciente, Comuna comuna, String fechaPCR) {
        super(idPaciente, nombrePaciente, comuna);
        this.fechaPCR = fechaPCR;
    }

    @Override
    public String getTipoPaciente() {
        return "Asintomático";
    }

    public String getFechaPCR() {
        return fechaPCR;
    }

    public void setFechaPCR(String fechaPCR) {
        this.fechaPCR = fechaPCR;
    }
}
