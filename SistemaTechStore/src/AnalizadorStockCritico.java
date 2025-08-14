import java.util.List;

public class AnalizadorStockCritico implements ProductoVisitor{
    private List<Producto> productosCriticos = new ArrayList<>();


    @Override
    public void visitLaptop(Laptop laptop) {
        if (laptop.getStock() <= 3) {
            productosCriticos.add(laptop);
        }
    }

    @Override
    public void visitSmartphone(Smartphone smartphone) {
        if (smartphone.getStock() <= 5) {
            productosCriticos.add(smartphone);
        }
    }

    @Override
    public void visitAccessorio(Accesorio accesorio) {
        if (accesorio.getStock() <= 10) {
            productosCriticos.add(accesorio);
        }
    }

    public List<Producto> getProductosCriticos() {
        return productosCriticos;
    }
}
