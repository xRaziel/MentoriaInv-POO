public class ClienteRegular implements EstrategiaDescuento{
    @Override
    public double calcularDescuento(double precioOriginal) {
        if (precioOriginal > 500000){
            return precioOriginal * 0.95 ; // 5% de descuento
        }
        return precioOriginal; // Sin descuento
    }
}
