import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Empleado{
    private int mesesAntiguedad;
    private List<Venta> ventas;

    public Vendedor(String rut, String nombre, double sueldo, int mesesAntiguedad) {
        super(rut, nombre, sueldo);
        this.mesesAntiguedad = mesesAntiguedad;
        this.ventas = new ArrayList<>();
    }

    @Override
    public double calcularSueldo() {
        if(mesesAntiguedad > 18){
            return getSueldo() * 1.3; // Aumento del 30% si tiene más de 18 meses de antigüedad
        }
        return getSueldo();
    }

    @Override
    public String getTipoEmpleado() {
        return "Vendedor";
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public double getTotalVentas() {
        double total = 0;
        for (Venta venta : ventas) {
            total += venta.getMonto();
        }
        return total;
    }

    public int getMesesAntiguedad() {
        return mesesAntiguedad;
    }

    public void setMesesAntiguedad(int mesesAntiguedad) {
        this.mesesAntiguedad = mesesAntiguedad;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
