public class ClienteCorporativo implements EstrategiaDescuento{

    @Override
    public double calcularDescuento(double precioOriginal) {
        if (precioOriginal > 2000000) {
            return precioOriginal * 0.8; // 20% de descuento
        }
        return precioOriginal; // Sin descuento
    }
}
