public class ContextoVenta {
    private EstrategiaDescuento estrategiaDescuento;

    public ContextoVenta(EstrategiaDescuento estrategiaDescuento) {
        this.estrategiaDescuento = estrategiaDescuento;
    }

    public void setEstrategiaDescuento(EstrategiaDescuento estrategiaDescuento) {
        this.estrategiaDescuento = estrategiaDescuento;
    }

    public double calcularPrecioFinal(double precioOriginal) {
        return estrategiaDescuento.calcularDescuento(precioOriginal);
    }

}
