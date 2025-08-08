import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaNorteLindoImpl implements SistemaNorteLindo{
    private List<Bus> buses;
    private List<Trabajador> trabajadores;
    private List<Recorrido> recorridos;

    public SistemaNorteLindoImpl() {
        this.buses = new ArrayList<>();
        this.trabajadores = new ArrayList<>();
        this.recorridos = new ArrayList<>();
    }

    @Override
    public void cargarTrabajadores(String archivoTrabajadores) {

    }

    @Override
    public void cargarBuses(String archivoBuses) {

    }

    @Override
    public void cargarRecorridos(String archivoRecorridos) {

    }

    @Override
    public void asignarRecorridosBuses(String archivoRecorridosBuses) {

    }

    @Override
    public void asignarTrabajdoresBuses(String archivoTrabajadoresBuses) {

    }

    private Bus buscarBusPorPatente(String patente) {
        for (Bus bus : buses) {
            if (bus.getPatente().equals(patente)) {
                return bus;
            }
        }
        return null;
    }

    private Recorrido buscarRecorridoPorNumero(int numero) {
        for (Recorrido recorrido : recorridos) {
            if (recorrido.getNumero() == numero) {
                return recorrido;
            }
        }
        return null;
    }

    private Guia buscarGuiaPorRut(String rut) {
        for (Trabajador trabajador : trabajadores) {
            if (trabajador instanceof Guia && trabajador.getRut().equals(rut)) {
                Guia guia = (Guia) trabajador;
                return guia;
            }
        }
        return null;
    }

    private Chofer buscarChoferPorRut(String rut) {
        for (Trabajador trabajador : trabajadores) {
            if (trabajador instanceof Chofer && trabajador.getRut().equals(rut)) {
                Chofer chofer = (Chofer) trabajador;
                return chofer;
            }
        }
        return null;
    }


    @Override
    public void eliminarBusesViejos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el año de los buses a eliminar: ");
        int año = scanner.nextInt();

        for (Bus bus : buses) {
            if (bus.getAño() == año) {
                buses.remove(bus);
                System.out.println("Bus con patente " + bus.getPatente() + " eliminado.");
            }
        }
    }

    @Override
    public void obtenerDatosBuses() {
        for (Bus bus : buses) {
            System.out.println("Patente: " + bus.getPatente() + ", Año: " + bus.getAño());
            if (bus.getChofer() != null) {
                System.out.println("  Chofer: " + bus.getChofer().getNombre() + ", RUT: " + bus.getChofer().getRut());
            }else{
                System.out.println("  Chofer: No asignado");
            }
            if (bus.getGuia() != null) {
                System.out.println("  Guia: " + bus.getGuia().getNombre() + ", RUT: " + bus.getGuia().getRut());
            }else{
                System.out.println("  Guia: No asignado");
            }
        }
    }

    @Override
    public void obtenerDatosTrabajadores() {
        for (Trabajador trabajador : trabajadores) {
            System.out.println("Nombre: " + trabajador.getNombre() + ", RUT: " + trabajador.getRut());
            if (trabajador instanceof Chofer) {
                Chofer chofer = (Chofer) trabajador;
                System.out.println("  Licencia: " + chofer.getLicencia() + ", Bono: " + chofer.calcularBono());
            } else if (trabajador instanceof Guia) {
                Guia guia = (Guia) trabajador;
                System.out.println("  Categoria: " + guia.getCategoria() + ", Bono: " + guia.calcularBono());
            }
        }
    }

    @Override
    public void eliminarTrabajador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el RUT del trabajador a eliminar: ");
        String rut = scanner.nextLine();

        Trabajador trabajadorAEliminar = null;
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getRut().equals(rut)) {
                trabajadorAEliminar = trabajador;
                break;
            }
        }

        if(trabajadorAEliminar != null) {
            trabajadores.remove(trabajadorAEliminar);
            System.out.println("Trabajador con RUT " + rut + " eliminado.");

            // Eliminar asignaciones de buses
            for (Bus bus : buses) {
                if (bus.getChofer() != null && bus.getChofer().getRut().equals(rut)) {
                    bus.setChofer(null);
                    System.out.println("Chofer con RUT " + rut + " eliminado de bus con patente " + bus.getPatente());
                }
                if (bus.getGuia() != null && bus.getGuia().getRut().equals(rut)) {
                    bus.setGuia(null);
                    System.out.println("Guia con RUT " + rut + " eliminado de bus con patente " + bus.getPatente());
                }
            }
        } else {
            System.out.println("Trabajador con RUT " + rut + " no encontrado.");
        }
    }

    @Override
    public void obtenerRecorridos() {
        for (Recorrido recorrido : recorridos) {
            System.out.println("Numero: " + recorrido.getNumero() + ", KmM recorrido: " + recorrido.getKm());
            if(recorrido.getBuses() != null) {
                for (Bus bus : recorrido.getBuses()) {
                    System.out.println("  Bus: " + bus.getPatente() + ", Año: " + bus.getAño());
                    if (bus.getChofer() != null) {
                        System.out.println("    Chofer: " + bus.getChofer().getNombre() + ", RUT: " + bus.getChofer().getRut());
                    } else {
                        System.out.println("    Chofer: No asignado");
                    }
                    if (bus.getGuia() != null) {
                        System.out.println("    Guia: " + bus.getGuia().getNombre() + ", RUT: " + bus.getGuia().getRut());
                    } else {
                        System.out.println("    Guia: No asignado");
                    }
                }
            } else {
                System.out.println("  Bus: No asignado");
            }
        }

    }

    @Override
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Menu Sistema Norte Lindo");
            System.out.println("1. Eliminar buses viejos");
            System.out.println("2. Obtener datos de buses");
            System.out.println("3. Obtener datos de trabajadores");
            System.out.println("4. Eliminar trabajador");
            System.out.println("5. Obtener recorridos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    eliminarBusesViejos();
                    break;
                case 2:
                    obtenerDatosBuses();
                    break;
                case 3:
                    obtenerDatosTrabajadores();
                    break;
                case 4:
                    eliminarTrabajador();
                    break;
                case 5:
                    obtenerRecorridos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }

        }while(opcion != 0);
    }
}
