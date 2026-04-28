package ejercicio3.Persistencia;
import ejercicio3.Modelo.Concurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ArchivoConcursos implements RegistroConcursos {

    private final String ruta;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public ArchivoConcursos(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public List<Concurso> concursosAbiertos() {
        try {
            return Files.readAllLines(Path.of(ruta))
                    .stream()
                    .filter(linea -> !linea.isBlank())
                    .map(this::crearConcurso)
                    .filter(concurso -> concurso.estaAbierto(LocalDate.now()))
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo de concursos", e);
        }
    }

    private Concurso crearConcurso(String linea) {
        String[] datos = linea.split(",");

        String id = datos[0].trim();
        String nombre = datos[1].trim();
        LocalDate inicio = LocalDate.parse(datos[2].trim(), formatter);
        LocalDate fin = LocalDate.parse(datos[3].trim(), formatter);

        return new Concurso(id, nombre, inicio, fin);
    }
}