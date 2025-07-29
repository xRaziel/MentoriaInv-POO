public class Tesis extends MaterialBibliografico{

    public Tesis(String codigo, String titulo, String autor, int añoPublicacion, boolean disponible) {
        super(codigo, titulo, autor, añoPublicacion, disponible);
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        return diasRetraso * 1000.0; // Multa de 1000 por día de retraso
    }

    @Override
    public int getDiasMaximoPrestamo() {
        return 21; // Días máximos de préstamo para una tesis
    }
}
