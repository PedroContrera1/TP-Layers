package ejercicio2.model;

import java.time.LocalDate;
import java.time.MonthDay;

public class Empleado {
    private final String apellido;
    private final String nombre;
    private final LocalDate fechaDeNacimiento;
    private final String email;

    public Empleado (String apellido, String nombre, LocalDate fechaDeNacimiento,String email){
        validarNombre(nombre);
        validarApellido(apellido);
        validarFechaNacimiento(fechaDeNacimiento);
        validarEmail(email);
        this.apellido=apellido;
        this.nombre=nombre;
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.email=email;
    }
    public boolean esTuCumple(MonthDay unDiaMes){
        return MonthDay.from(this.fechaDeNacimiento).equals(unDiaMes);
    }
    private void validarApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            throw new RuntimeException("Apellido inválido");
        }
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new RuntimeException("Nombre inválido");
        }
    }

    private void validarFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new RuntimeException("Fecha inválida");
        }
    }

    private void validarEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new RuntimeException("Email inválido");
        }
    }

    public String email(){
        return this.email;
    }
    public String apellido(){
        return this.apellido;
    }
    public String nombre(){
        return this.nombre;
    }
    public LocalDate fechaDeNacimiento(){
        return fechaDeNacimiento;
    }
}
