import java.util.ArrayList;
import java.util.List;

public class SistemaTechStoreImpl implements SistemaTechStore{
    private List<Producto> productos;

    public SistemaTechStoreImpl() {
        this.productos = new ArrayList<>();
        cargarProductos();
    }

    private void cargarProductos() {
        // Aquí se cargarían los productos de la tienda leyendo los txt
    }

    public List<Producto> getProductos() {
        return productos;
    }

    private void aplicarVisitor(ProductoVisitor visitor) {
        for (Producto producto : productos) {
            producto.accept(visitor);
        }
    }

    public void ejecutarOperaciones(){
        System.out.println("Ejecutando operaciones del sistema TechStore...");
        System.out.println("1. Calcular valor total de productos");
        CalculadorValorTotal calculador = new CalculadorValorTotal();
        aplicarVisitor(calculador);
        System.out.println("Valor total de productos: " + calculador.getTotal());

        System.out.println("2. Analizar stock crítico de productos");
        AnalizadorStockCritico analizadorStock = new AnalizadorStockCritico();
        aplicarVisitor(analizadorStock);
        List<Producto> productosCriticos = analizadorStock.getProductosCriticos();
        if (productosCriticos.isEmpty()) {
            System.out.println("No hay productos con stock crítico.");
        } else {
            System.out.println("Productos con stock crítico:");
            for (Producto producto : productosCriticos) {
                System.out.println(producto.getNombre() + " - Stock: " + producto.getStock());
            }
        }

        System.out.println("3. Analizar productos premium");
        AnalizadorProductosPremium analizadorPremium = new AnalizadorProductosPremium();
        aplicarVisitor(analizadorPremium);
        List<Producto> productosPremium = analizadorPremium.getProductosPremium();
        if (productosPremium.isEmpty()) {
            System.out.println("No hay productos premium.");
        } else {
            System.out.println("Productos premium:");
            for (Producto producto : productosPremium) {
                System.out.println(producto.getNombre() + " - Precio: " + producto.getPrecio());
            }
        }
    }

    public void demostrarEstrategiasDescuento(){
        System.out.println("Demostrando estrategias de descuento...");

        // Crear productos de ejemplo
        Laptop laptop = new Laptop("Laptop Premium", 2500000, 2);
        Smartphone smartphone = new Smartphone("Smartphone Avanzado", 1200000, 4);
        Accesorio accesorio = new Accesorio("Accesorio Básico", 300000, 8);

        // Aplicar estrategia de descuento para Laptop
        ClienteRegular clienteRegular = new ClienteRegular();
        ContextoVenta contextoVenta = new ContextoVenta(clienteRegular);
        double total = laptop.getPrecio();
        double descuentoLaptop = contextoVenta.calcularPrecioFinal(total);
        System.out.println("Cliente regular:");
        System.out.println("Laptop: Precio original: " + laptop.getPrecio() + ", Precio final con descuento: " + descuentoLaptop);

        ClientePremium clientePremium = new ClientePremium();
        contextoVenta.setEstrategiaDescuento(clientePremium);
        double descuentoLaptopPremium = contextoVenta.calcularPrecioFinal(laptop.getPrecio()+smartphone.getPrecio());
        System.out.println("Cliente premium:");
        System.out.println("Laptop + Smartphone: Precio original: " + (laptop.getPrecio() + smartphone.getPrecio()) + ", Precio final con descuento: " + descuentoLaptopPremium);

        ClienteCorporativo clienteCorporativo = new ClienteCorporativo();
        contextoVenta.setEstrategiaDescuento(clienteCorporativo);
        double descuentoLaptopAccesorio = contextoVenta.calcularPrecioFinal(laptop.getPrecio() + accesorio.getPrecio());
        System.out.println("Cliente corporativo:");
        System.out.println("Laptop + Accesorio: Precio original: " + (laptop.getPrecio() + accesorio.getPrecio()) + ", Precio final con descuento: " + descuentoLaptopAccesorio);

    }

}
