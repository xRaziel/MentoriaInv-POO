public class Investigador extends Usuario{

    public Investigador(String id, String nombre, String email) {
        super(id, nombre, email);
    }

    @Override
    public int getMaximoMaterialesPermitidos(){
        return 12; // Máximo de 12 materiales permitidos para un estudiante
    }

    @Override
    public String getTipoUsuario() {
        return "Investigador"; // Tipo de usuario
    }
}
