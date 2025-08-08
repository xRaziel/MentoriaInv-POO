import java.util.ArrayList;
import java.util.List;

public class Recorrido {
    private int numero;
    private double km;
    private List<Bus> buses;

    public Recorrido(int numero, double km) {
        this.numero = numero;
        this.km = km;
        this.buses = new ArrayList<>();
    }

    public void addBus(Bus bus) {
        if (bus != null) {
            buses.add(bus);
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}
