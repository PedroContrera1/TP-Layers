package ejercicio3.Modelo;



import java.util.Objects;

public class Participante {
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final String email;
    public Participante(String dni, String nombre,String apellido, String email, String telefono) {
        validarDni(dni);
        validarNombre(nombre);
        validarApellido(apellido);
        validarEmail(email);
        validarTelefono(telefono);
        this.dni = dni;
        this.nombre = nombre;
        this.apellido=apellido;
        this.email=email;
        this.telefono=telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new RuntimeException("El nombre no puede estar vacío");
        }
    }
    private void validarApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new RuntimeException("El nombre no puede estar vacío");
        }
    }

    private void validarDni(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            throw new RuntimeException("El id del participante no puede estar vacío");
        }
    }
    private void validarTelefono(String telefono){
        if (telefono==null || telefono.isEmpty()){
            throw new RuntimeException("El campo telefono no puede ser vacio");
        }
        String formato="\\d{4}-\\d{6}";
        if (!telefono.matches(formato)){
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
    }
    private void validarEmail(String email){
        if (email==null || email.isEmpty()){
            throw new RuntimeException("El campo telefono no puede ser vacio");
        }
        String formato= "^[\\w-_.+]*[\\w-_.]@(\\w+\\.)+\\w+\\w$";
        if (!email.matches(formato)){
            throw new RuntimeException("El email debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participante that)) return false;
        return Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    public String nombre() {
        return this.nombre;
    }
    public String apellido(){
        return this.apellido;
    }
    public String telefono(){
        return this.telefono;
    }
    public String email(){
        return this.email;
    }
}
