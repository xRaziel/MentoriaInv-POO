public interface SistemaCovid {

    boolean ingresarPacienteSintomatico(PacienteSintomatico pacienteSintomatico);
    boolean ingresarPacienteAsintomatico(PacienteAsintomatico pacienteAsintomatico);
    boolean ingresarComuna(Comuna comuna);
    boolean ingresarCentroSalud(String nombreComuna, CentroSalud centroSalud);
    boolean ingresarHospitalizacion(String idPaciente, Hospitalizacion hospitalizacion);
    void desplegarPacienteSintomatico();
    boolean eliminarPacienteSintomatico(String idPaciente);
    void desplegarInfoPacientes();
    void desplegarInfoComunas();
    void desplegarCantPacientesAsintomaticos();

}
