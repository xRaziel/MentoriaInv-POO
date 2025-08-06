public class Venta {

    private String articulo;
    private double monto;

    public Venta(String articulo, double monto) {
        this.articulo = articulo;
        this.monto = monto;
    }

    public String getArticulo() {
        return articulo;
    }
    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
}
