public class IntervencionPizzeria implements IntervencionStrategy {
    @Override
    public boolean necesitaIntervencion(Restaurante restaurante) {
        Pizzeria pizzeria = (Pizzeria) restaurante;
        if (pizzeria.getAñosOperacion() > 8 || pizzeria.getRatingClientes() < 3.5 || pizzeria.getHornosOperativos() < 2) {
            return true; // Necesita intervención si no cumple con los requisitos mínimos
        }
        return false; // No necesita intervención si cumple con los requisitos
    }
}
