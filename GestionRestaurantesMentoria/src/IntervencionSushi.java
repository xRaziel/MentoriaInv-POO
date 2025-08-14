public class IntervencionSushi implements IntervencionStrategy {
    @Override
    public boolean necesitaIntervencion(Restaurante restaurante) {
        SushiBar sushiBar = (SushiBar) restaurante;
        if (sushiBar.getRatingClientes() < 4.0 || sushiBar.getChefsEspecializados() < 2 || sushiBar.getAñosOperacion() > 6) {
            return true; // Necesita intervención si no cumple con los requisitos mínimos
        }
        return false; // No necesita intervención si cumple con los requisitos
    }
}
