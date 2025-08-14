public class IntervencionAsador implements IntervencionStrategy{
    @Override
    public boolean necesitaIntervencion(Restaurante restaurante) {
        AsadorCarnes asador = (AsadorCarnes) restaurante;
        if( asador.getRatingClientes() < 4.0 || asador.getRatingClientes() < 4.0 || asador.getParrillasPremium() < 3) {
            return true; // Necesita intervención si no cumple con los requisitos mínimos
        }
        return false; // No necesita intervención si cumple con los requisitos
    }
}
