public class CalcularBonificaciones {
    private BonificacionesStrategy bonificacionesStrategy;

    public double ejecutarCalculo(Restaurante restaurante) {
        return bonificacionesStrategy.calcularBonificacion(restaurante);
    }

    public void setBonificacionesStrategy(BonificacionesStrategy bonificacionesStrategy) {
        this.bonificacionesStrategy = bonificacionesStrategy;
    }
}
