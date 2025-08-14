public class ClientePremium implements EstrategiaDescuento{

    @Override
    public double calcularDescuento(double precioOriginal) {
        double precioConDescuento = precioOriginal * 0.90; // 10% de descuento
        if(precioOriginal > 1000000){
            precioConDescuento = precioOriginal * 0.75; // 15% de descuento adicional
        }
        return precioConDescuento;
    }
}
