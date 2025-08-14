public class IntervencionCafeteria implements IntervencionStrategy {
    @Override
    public boolean necesitaIntervencion(Restaurante restaurante) {
        CafeteriaGourmet cafeteria = (CafeteriaGourmet) restaurante;
        if(cafeteria.getAñosOperacion() > 10 || cafeteria.getRatingClientes() < 3.8 || cafeteria.getMaquinasCafe() < 3) {
            return true; // Necesita intervención si no cumple con los requisitos mínimos
        }
        return false; // No necesita intervención si cumple con los requisitos
    }
}
