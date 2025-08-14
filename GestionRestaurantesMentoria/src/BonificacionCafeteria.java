public class BonificacionCafeteria implements BonificacionesStrategy{
    /*
    *
    * Cafetería:
    * Si maquinas_cafe ≥ 5 Y rating ≥ 4.2: $450 por empleado
    * Si rating ≥ 3.8: $350 por empleado
    * Otros casos: $180 por empleado
    *
    * */
    @Override
    public double calcularBonificacion(Restaurante restaurante) {
        CafeteriaGourmet cafeteria = (CafeteriaGourmet) restaurante;
        double bonificacion = 0.0;
        if (cafeteria.getMaquinasCafe() >= 5 && cafeteria.getRatingClientes() >= 4.2) {
            bonificacion = 450 * cafeteria.getNumeroEmpleados();
        } else if (cafeteria.getRatingClientes() >= 3.8) {
            bonificacion = 350 * cafeteria.getNumeroEmpleados();
        } else {
            bonificacion = 180 * cafeteria.getNumeroEmpleados();
        }
        return bonificacion;
    }
}
