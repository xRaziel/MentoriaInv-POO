public class Estudiante extends Usuario{

    public Estudiante(String id, String nombre, String email) {
        super(id, nombre, email);
    }

    @Override
    public int getMaximoMaterialesPermitidos(){
        return 3; // Máximo de 3 materiales permitidos para un estudiante
    }

    @Override
    public String getTipoUsuario() {
        return "Estudiante"; // Tipo de usuario
    }
}
