public class BonificacionAsador implements BonificacionesStrategy{
    /*
    *
    * Asador:
    * 1.	Si parrillas ≥ 4 Y rating ≥ 4.3: $700 por empleado
    * Si rating ≥ 4.0: $400 por empleado
    * Otros casos: $200 por empleado
    *
    * */
    @Override
    public double calcularBonificacion(Restaurante restaurante) {
        AsadorCarnes asador = (AsadorCarnes) restaurante;
        double bonificacion = 0.0;
        if (asador.getParrillasPremium() >= 4 && asador.getRatingClientes() >= 4.3) {
            bonificacion = 700 * asador.getNumeroEmpleados();
        } else if (asador.getRatingClientes() >= 4.0) {
            bonificacion = 400 * asador.getNumeroEmpleados();
        } else {
            bonificacion = 200 * asador.getNumeroEmpleados();
        }
        return bonificacion;

    }
}
