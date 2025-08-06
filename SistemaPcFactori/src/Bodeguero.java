import java.util.ArrayList;
import java.util.List;

public class Bodeguero extends Empleado{
    private int edad;
    private List<Caja> cajas;

    public Bodeguero(String rut, String nombre, double sueldo, int edad) {
        super(rut, nombre, sueldo);
        this.edad = edad;
        this.cajas = new ArrayList<>();
    }

    @Override
    public double calcularSueldo() {
        if(edad > 40){
            return getSueldo() + 200000; // Aumento de 200.000 si tiene más de 40 años
        }
        return getSueldo();
    }

    @Override
    public String getTipoEmpleado() {
        return "Bodeguero";
    }

    public double getPesoTotal(){
        double pesoTotal = 0;
        for (Caja caja : cajas) {
            pesoTotal += caja.getPeso();
        }
        return pesoTotal;
    }

    public void agregarCaja(Caja caja) {
        cajas.add(caja);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Caja> getCajas() {
        return cajas;
    }

    public void setCajas(List<Caja> cajas) {
        this.cajas = cajas;
    }
}
