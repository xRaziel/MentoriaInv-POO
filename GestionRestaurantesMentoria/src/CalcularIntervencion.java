public class CalcularIntervencion {
    private IntervencionStrategy intervencionStrategy;

    public boolean ejecutarIntervencion(Restaurante restaurante) {
        return intervencionStrategy.necesitaIntervencion(restaurante);
    }

    public void setIntervencionStrategy(IntervencionStrategy intervencionStrategy) {
        this.intervencionStrategy = intervencionStrategy;
    }
}
