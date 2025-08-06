import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SistemaPcFactoriImpl implements SistemaPcFactori{
    private List<Empleado> empleados;

    public SistemaPcFactoriImpl() {
        this.empleados = new ArrayList<>();
    }


    //sistema.cargarDatos("personal.txt", "ventas.txt", "mercaderia.txt");

    @Override
    public void cargarDatos(String personalTxt, String ventasTxt, String mercaderiaTxt) {
        //Caso personalTxt:
        try{
            BufferedReader reader = new BufferedReader(new FileReader(personalTxt));
            String linea;
            while ((linea = reader.readLine()) != null){
                String datos[] = linea.split(",");
                String nombre = datos[0];
                String rut = datos[1];
                char tipo = datos[2].charAt(0);
                double sueldo = Double.parseDouble(datos[3]);
                if(tipo == 'V'){
                    int mesesAntiguedad = Integer.parseInt(datos[4]);
                    Vendedor vendedor = new Vendedor(rut, nombre, sueldo, mesesAntiguedad);
                    empleados.add(vendedor);
                } else if(tipo == 'B'){
                    int edad = Integer.parseInt(datos[4]);
                    Bodeguero bodeguero = new Bodeguero(rut, nombre, sueldo, edad);
                    empleados.add(bodeguero);
                }
            }
        }catch (Exception e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    @Override
    public double calcularBalance() {
        double ingresos = 0;
        double gastos = 0;
        for(Empleado empleado: empleados){
            gastos += empleado.calcularSueldo();

            if(empleado instanceof Vendedor){
                Vendedor v = (Vendedor) empleado;
                ingresos += v.getTotalVentas();
            }
        }
        System.out.println("Total Ingresos: " + ingresos);
        System.out.println("Total Gastos: " + gastos);
        System.out.println("Balance: " + (ingresos - gastos));
        return ingresos - gastos;
    }

    @Override
    public void desplegarDetalleVendedores() {
        for(Empleado empleado: empleados){
            if(empleado instanceof Vendedor){
                Vendedor v = (Vendedor) empleado;
                System.out.println("Vendedor: " + v.getNombre() + ", RUT: " + v.getRut() + ", Meses de antiguedad: "+ v.getMesesAntiguedad() + ", Sueldo: " + v.calcularSueldo() + ", Total Ventas: " + v.getTotalVentas());
                for(Venta venta: v.getVentas()){
                    System.out.println("  Articulo: " + venta.getArticulo() + ", Monto: " + venta.getMonto());
                }
            }
        }
    }

    @Override
    public boolean modificarSueldoEmpleado(String rut, double sueldo) {
        Empleado empleado = buscarEmpleadoPorRut(rut);
        if(empleado != null) {
            empleado.setSueldo(sueldo);
            System.out.println("Sueldo modificado para " + empleado.getNombre() + ": " + sueldo);
            return true;
        }
        return false;
    }

    private Empleado buscarEmpleadoPorRut(String rut){
        for(Empleado empleado : empleados) {
            if (empleado.getRut().equals(rut)) {
                return empleado;
            }
        }
        return null;
    }

    @Override
    public void eliminarBodeguerosMenores20() {
        for(Empleado empleado : empleados){
            if(empleado instanceof Bodeguero){
                Bodeguero b = (Bodeguero) empleado;
                if(b.getEdad() < 20){
                    empleados.remove(empleado);
                    System.out.println("Bodeguero eliminado: " + b.getNombre() + ", RUT: " + b.getRut() + ", Edad: " + b.getEdad());
                }
            }
        }
    }

    @Override
    public void desplegarDetalleBodegueros() {
        for(Empleado empleado: empleados){
            if(empleado instanceof Bodeguero){
                Bodeguero b = (Bodeguero) empleado;
                System.out.println("Bodeguero: " + b.getNombre() + ", RUT: " + b.getRut() + ", Edad: " + b.getEdad() + ", Sueldo: " + b.calcularSueldo());
                for(Caja caja : b.getCajas()){
                    System.out.println("  Caja: " + caja.getCodigo() + ", Peso: " + caja.getPeso());
                }
            }
        }

    }

    @Override
    public void desplegarBodegueroMayorPeso() {
        Bodeguero bodegueroMayorPeso = null;
        double mayorPeso = 0;

        for(Empleado empleado : empleados){
            if (empleado instanceof Bodeguero){
                Bodeguero b = (Bodeguero) empleado;
                double pesoTotal = b.getPesoTotal();

                if (pesoTotal > mayorPeso) {
                    mayorPeso = pesoTotal;
                    bodegueroMayorPeso = b;
                }
            }
        }

        if(bodegueroMayorPeso != null) {
            System.out.println("Bodeguero con mayor peso total de cajas: " + bodegueroMayorPeso.getNombre() + ", RUT: " + bodegueroMayorPeso.getRut() + ", Peso Total: " + bodegueroMayorPeso.getPesoTotal());
        } else {
            System.out.println("No hay bodegueros registrados.");
        }

    }
}
