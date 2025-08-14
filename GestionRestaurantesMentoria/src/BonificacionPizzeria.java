public class BonificacionPizzeria implements BonificacionesStrategy {

    /*
    *
    * Pizzería:
    * Si rating ≥ 4.5 Y hornos ≥ 3: $500 por empleado
    * Si rating ≥ 4.0: $300 por empleado
    * Otros casos: $150 por empleado
    *
    * */
    @Override
    public double calcularBonificacion(Restaurante restaurante) {
        Pizzeria pizzeria = (Pizzeria) restaurante;
        double bonificacion = 0.0;
        if (pizzeria.getRatingClientes() >= 4.5 && pizzeria.getHornosOperativos() >= 3) {
            bonificacion = 500 * pizzeria.getNumeroEmpleados();
        } else if (pizzeria.getRatingClientes() >= 4.0) {
            bonificacion = 300 * pizzeria.getNumeroEmpleados();
        } else {
            bonificacion = 150 * pizzeria.getNumeroEmpleados();
        }
        return bonificacion;

    }
}
