import java.util.ArrayList;
import java.util.List;

public class PacienteSintomatico extends Paciente{

    private String fechaPrimerosSintomas;
    private List<Hospitalizacion> hospitalizaciones;

    public PacienteSintomatico(String idPaciente, String nombrePaciente, Comuna comuna, String fechaPrimerosSintomas) {
        super(idPaciente, nombrePaciente, comuna);
        this.fechaPrimerosSintomas = fechaPrimerosSintomas;
        this.hospitalizaciones = new ArrayList<>();
    }

    @Override
    public String getTipoPaciente() {
        return "Sintomático";
    }

    public String getFechaPrimerosSintomas() {
        return fechaPrimerosSintomas;
    }

    public void setFechaPrimerosSintomas(String fechaPrimerosSintomas) {
        this.fechaPrimerosSintomas = fechaPrimerosSintomas;
    }

    public List<Hospitalizacion> getHospitalizaciones() {
        return hospitalizaciones;
    }

    public void agregarHospitalizacion(Hospitalizacion hospitalizacion) {
        this.hospitalizaciones.add(hospitalizacion);
    }

}
