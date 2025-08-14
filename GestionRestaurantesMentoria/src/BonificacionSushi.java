public class BonificacionSushi implements BonificacionesStrategy{
    /*
    *
    * Sushi:
    * Si rating ≥ 4.8: $800 por empleado
    * Si rating ≥ 4.0 Y chefs ≥ 2: $600 por empleado
    * Otros casos: $250 por empleado
    *
    * */
    @Override
    public double calcularBonificacion(Restaurante restaurante) {
        SushiBar sushi = (SushiBar) restaurante;
        double bonificacion = 0.0;
        if (sushi.getRatingClientes() >= 4.8) {
            bonificacion = 800 * sushi.getNumeroEmpleados();
        } else if (sushi.getRatingClientes() >= 4.0 && sushi.getChefsEspecializados() >= 2) {
            bonificacion = 600 * sushi.getNumeroEmpleados();
        } else {
            bonificacion = 250 * sushi.getNumeroEmpleados();
        }
        return bonificacion;

    }
}
