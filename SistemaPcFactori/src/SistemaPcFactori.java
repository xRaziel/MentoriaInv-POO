public interface SistemaPcFactori {
    void cargarDatos(String personalTxt, String ventasTxt, String mercaderiaTxt);
    double calcularBalance();
    void desplegarDetalleVendedores();
    boolean modificarSueldoEmpleado(String rut, double sueldo);
    void eliminarBodeguerosMenores20();
    void desplegarDetalleBodegueros();
    void desplegarBodegueroMayorPeso();

}
