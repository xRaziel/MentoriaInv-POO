public interface SistemaNorteLindo {

    public void cargarTrabajadores(String archivoTrabajadores);
    public void cargarBuses(String archivoBuses);
    public void cargarRecorridos(String archivoRecorridos);
    public void asignarRecorridosBuses(String archivoRecorridosBuses);
    public void asignarTrabajdoresBuses(String archivoTrabajadoresBuses);
    public void eliminarBusesViejos();
    public void obtenerDatosBuses();
    public void obtenerDatosTrabajadores();
    public void eliminarTrabajador();
    public void obtenerRecorridos();
    public void mostrarMenu();
}
