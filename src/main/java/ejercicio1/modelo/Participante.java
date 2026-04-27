package ejercicio1.modelo;

public class Participante {
    private final String nombre;
    private final String telefono;
    private final String region;
    public Participante(String nombre, String telefono, String region) {
        validarNombre(nombre);
        validarTelefono(telefono);
        validarRegion(region);

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private void validarNombre(String nombre) {
        if (nombre==null || nombre.isBlank()){
            throw new RuntimeException("Debe cargar un nombre");
        }
    }
    private void validarTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            throw new RuntimeException("Debe cargar un telefono");
        }

        String formato = "\\d{4}-\\d{6}";

        if (!telefono.matches(formato)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
    }
    private void validarRegion(String region) {
        if (region == null || region.isBlank()) {
            throw new RuntimeException("Debe cargar una Region");
        }

        if (!region.equals("China") && !region.equals("Europa") && !region.equals("US")) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
    }
    public String nombre(){
        return this.nombre;
    }
    public String telefono(){
        return this.telefono;
    }
    public String region(){
        return this.region;
    }
}
