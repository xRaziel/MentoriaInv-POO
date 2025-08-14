public class Administrativo extends Empleado{

    private String departamento;
    private int horasTrabajadas;
    private int documentosProcesados;

    public Administrativo(String nombre, String rut, Double sueldoBase, String departamento, int horasTrabajadas, int documentosProcesados) {
        super(nombre, rut, sueldoBase);
        this.departamento = departamento;
        this.horasTrabajadas = horasTrabajadas;
        this.documentosProcesados = documentosProcesados;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    public int getDocumentosProcesados() {
        return documentosProcesados;
    }
    public void setDocumentosProcesados(int documentosProcesados) {
        this.documentosProcesados = documentosProcesados;
    }
}
