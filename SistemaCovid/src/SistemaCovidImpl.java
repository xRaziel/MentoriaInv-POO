import java.util.ArrayList;
import java.util.List;

public class SistemaCovidImpl implements SistemaCovid {

    private List<Paciente> pacientes;
    private List<Comuna> comunas;
    private List<CentroSalud> centrosSalud;

    public SistemaCovidImpl() {
        this.pacientes = new ArrayList<>();
        this.comunas = new ArrayList<>();
        this.centrosSalud = new ArrayList<>();
    }


    @Override
    public boolean ingresarPacienteSintomatico(PacienteSintomatico pacienteSintomatico) {
        boolean existe = false;
        for (Paciente p : pacientes) {
            if (p.getIdPaciente().equals(pacienteSintomatico.getIdPaciente())) {
                existe = true;
                break;
            }
        }

        if(!existe) {
            pacientes.add(pacienteSintomatico);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean ingresarPacienteAsintomatico(PacienteAsintomatico pacienteAsintomatico) {
        boolean existe = false;
        for (Paciente p : pacientes) {
            if (p.getIdPaciente().equals(pacienteAsintomatico.getIdPaciente())) {
                existe = true;
                break;
            }
        }

        if(!existe) {
            pacientes.add(pacienteAsintomatico);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean ingresarComuna(Comuna comuna) {
        boolean existe = false;
        for (Comuna c : comunas) {
            if (c.getNombreComuna().equals(comuna.getNombreComuna())) {
                existe = true;
                break;
            }
        }
        if(!existe) {
            comunas.add(comuna);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean ingresarCentroSalud(String nombreComuna, CentroSalud centroSalud) {
        Comuna comunaEncontrada = null;
        for (Comuna c : comunas) {
            if (c.getNombreComuna().equals(nombreComuna)) {
                comunaEncontrada = c;
                break;
            }
        }
        boolean centroExiste = false;
        if (comunaEncontrada != null) {
            for (CentroSalud cs : comunaEncontrada.getCentrosSalud()) {
                if (cs.getCodCentro().equals(centroSalud.getCodCentro())) {
                    centroExiste = true;
                    break;
                }
            }
            if (!centroExiste) {
                comunaEncontrada.agregarCentroSalud(centroSalud);
                centrosSalud.add(centroSalud);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean ingresarHospitalizacion(String idPaciente, Hospitalizacion hospitalizacion) {
        PacienteSintomatico pacienteEncontrado = null;
        for (Paciente p : pacientes) {
            if (p instanceof PacienteSintomatico && p.getIdPaciente().equals(idPaciente)) {
                pacienteEncontrado = (PacienteSintomatico) p;
                break;
            }
        }
        if (pacienteEncontrado != null) {
            pacienteEncontrado.agregarHospitalizacion(hospitalizacion);
            return true;
        } else {
            return false;
        }
    }

    public boolean existeCentroSalud(String codCentro) {
        for (CentroSalud cs : centrosSalud) {
            if (cs.getCodCentro().equals(codCentro)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void desplegarPacienteSintomatico() {
        for(Paciente p : pacientes){
            if(p instanceof PacienteSintomatico){
                PacienteSintomatico ps = (PacienteSintomatico) p;
                System.out.println("ID Paciente: " + ps.getIdPaciente() + "Nombre Paciente: " + ps.getNombrePaciente());
                for (Hospitalizacion h : ps.getHospitalizaciones()) {
                    System.out.println("  Hospitalización en Centro: " + h.getCentroSalud().getCodCentro() + " Fecha Ingreso: " + h.getFechaIngreso());
                }
            }
        }
    }

    @Override
    public boolean eliminarPacienteSintomatico(String idPaciente) {
        Paciente pacienteEncontrado = null;
        for (Paciente p : pacientes) {
            if (p instanceof PacienteSintomatico && p.getIdPaciente().equals(idPaciente)) {
                pacienteEncontrado = p;
                break;
            }
        }
        if (pacienteEncontrado != null) {
            pacientes.remove(pacienteEncontrado);
            return true;
        }
        return false;
    }

    @Override
    public void desplegarInfoPacientes() {
        for (Paciente p : pacientes) {
            if (p instanceof  PacienteSintomatico){
                PacienteSintomatico ps = (PacienteSintomatico) p;
                System.out.println("Paciente Sintomático - ID: " + ps.getIdPaciente() + ", Nombre: " + ps.getNombrePaciente() + ", Fecha Primeros Síntomas: " + ps.getFechaPrimerosSintomas());
            }else {
                PacienteAsintomatico pa = (PacienteAsintomatico) p;
                System.out.println("Paciente Asintomático - ID: " + pa.getIdPaciente() + ", Nombre: " + pa.getNombrePaciente() + ", Fecha Test Positivo: " + pa.getFechaPCR());
            }
        }
    }

    @Override
    public void desplegarInfoComunas() {
        for (Comuna c : comunas) {
            System.out.println("Comuna: " + c.getNombreComuna());
            for (CentroSalud cs : c.getCentrosSalud()) {
                String tipo = "";
                if(cs.getTipo() == 1){
                    tipo = "Publico";
                }else{
                    tipo = "Privado";
                }
                System.out.println("  Centro de Salud: " + cs.getCodCentro() + ", Tipo: " + tipo);
            }
        }

    }

    @Override
    public void desplegarCantPacientesAsintomaticos() {
        int contador = 0;
        for (Paciente p : pacientes) {
            if (p instanceof PacienteAsintomatico) {
                contador++;
            }
        }
        System.out.println("Cantidad de Pacientes Asintomáticos: " + contador);
    }
}
