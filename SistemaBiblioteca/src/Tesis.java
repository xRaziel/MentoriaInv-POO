public class Tesis extends MaterialBibliografico{

    public Tesis(String codigo, String titulo, String autor, int añoPublicacion ) {
        super(codigo, titulo, autor, añoPublicacion);
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
