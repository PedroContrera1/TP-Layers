package ejercicio3.Modelo;

import java.time.LocalDate;

public class Concurso {
    private final String idConcurso;
    private final String nombre;
    private final LocalDate fechaInicioInscripcion;
    private final LocalDate fechaFinInscripcion;

    public Concurso(String idConcurso, String nombre,LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
        validarNombre(nombre);
        validarFecha(fechaInicioInscripcion);
        validarFecha(fechaFinInscripcion);
        validarPeriodo(fechaInicioInscripcion, fechaFinInscripcion);

        this.idConcurso = idConcurso;
        this.nombre=nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public boolean estaAbierto(LocalDate fecha) {
        return !fecha.isBefore(fechaInicioInscripcion)
                && !fecha.isAfter(fechaFinInscripcion);
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new RuntimeException("El nombre del concurso no puede ser nulo o vacío.");
        }
    }

    private void validarFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new RuntimeException("La fecha no puede ser nula.");
        }
    }

    private void validarPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
        if (!fechaInicio.isBefore(fechaFin)) {
            throw new RuntimeException(
                    "La fecha de inicio de inscripción debe ser anterior a la fecha de fin de inscripción."
            );
        }
    }
    public String idConcurso(){
        return idConcurso;
    }
}
