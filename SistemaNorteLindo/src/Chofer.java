public class Chofer extends Trabajador{

    private int licencia;

    public Chofer(String nombre, String rut, int licencia) {
        super(nombre, rut);
        this.licencia = licencia;
    }

    @Override
    public int calcularBono() {
        if(licencia >= 100000 && licencia <= 200000){
            return licencia;
        }
        return 0;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }
}
