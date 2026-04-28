package ejercicio3.Persistencia;
import ejercicio3.Modelo.Inscripcion;
import ejercicio3.Modelo.Participante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ArchivoInscripciones implements RegistroInscripcion {

    private final String ruta;

    public ArchivoInscripciones(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void guardar(Inscripcion inscripcion) {
        Participante participante = inscripcion.participante();

        String linea = participante.apellido() + ", "
                + participante.nombre() + ", "
                + participante.telefono() + ", "
                + participante.email() + ", "
                + inscripcion.concurso().idConcurso();

        try {
            Files.writeString(
                    Path.of(ruta),
                    linea + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar la inscripción", e);
        }
    }
}