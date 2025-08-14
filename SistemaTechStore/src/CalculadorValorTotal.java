public class CalculadorValorTotal implements ProductoVisitor{
    private double total = 0;

    @Override
    public void visitLaptop(Laptop laptop) {
        total += laptop.getPrecio() * laptop.getStock();
    }

    @Override
    public void visitSmartphone(Smartphone smartphone) {
        total += smartphone.getPrecio() * smartphone.getStock();
    }

    @Override
    public void visitAccessorio(Accesorio accesorio) {
        total += accesorio.getPrecio() * accesorio.getStock();
    }

    public double getTotal() {
        return total;
    }
}
