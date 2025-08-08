// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SistemaNorteLindo sistema = new SistemaNorteLindoImpl();

        sistema.cargarTrabajadores("trabajadores.txt");
        sistema.cargarBuses("buses.txt");
        sistema.cargarRecorridos("recorridos.txt");
        sistema.asignarRecorridosBuses("recorridos_buses.txt");
        sistema.asignarTrabajdoresBuses("trabajadores_buses.txt");

        sistema.mostrarMenu();
    }
}