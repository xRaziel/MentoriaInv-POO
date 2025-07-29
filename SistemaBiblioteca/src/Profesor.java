public class Profesor extends Usuario{

    public Profesor(String id, String nombre, String email) {
        super(id, nombre, email);
    }

    @Override
    public int getMaximoMaterialesPermitidos(){
        return 8; // Máximo de 8 materiales permitidos para un estudiante
    }

    @Override
    public String getTipoUsuario() {
        return "Profesor"; // Tipo de usuario
    }
}
