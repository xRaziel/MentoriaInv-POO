import java.util.List;

public class AnalizadorProductosPremium implements ProductoVisitor{

    private List<Producto> productosPremium = new ArrayList<>();


    @Override
    public void visitLaptop(Laptop laptop) {
        if(laptop.getPrecio() >= 2000000){
            productosPremium.add(laptop);
        }
    }

    @Override
    public void visitSmartphone(Smartphone smartphone) {
        if(smartphone.getPrecio() >= 1000000){
            productosPremium.add(smartphone);
        }
    }

    @Override
    public void visitAccessorio(Accesorio accesorio) {
        if(accesorio.getPrecio() >= 200000){
            productosPremium.add(accesorio);
        }
    }
}
