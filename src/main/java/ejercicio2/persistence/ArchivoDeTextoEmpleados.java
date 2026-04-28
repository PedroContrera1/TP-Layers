package ejercicio2.persistence;

import ejercicio2.model.Empleado;
import ejercicio2.model.RegistroDeEmpleados;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoDeTextoEmpleados implements RegistroDeEmpleados {
    private static final DateTimeFormatter FORMATO_FECHA_BARRAS = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private final String pathArchivo;

    public ArchivoDeTextoEmpleados(String pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    @Override
    public List<Empleado> empleados() {
        try {
            List<String> lineas = Files.readAllLines(Path.of(pathArchivo));
            List<Empleado> empleados = new ArrayList<>();

            for (String linea : lineas) {
                if (linea == null || linea.isBlank()) {
                    continue;
                }

                empleados.add(crearEmpleadoDesde(linea));
            }

            return empleados;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo de empleados", e);
        }
    }

    private Empleado crearEmpleadoDesde(String linea) {
        String[] datos = linea.split(",");

        if (datos.length != 4) {
            throw new RuntimeException("Formato inválido en la línea: " + linea);
        }

        String apellido = datos[0].trim();
        String nombre = datos[1].trim();
        LocalDate fechaNacimiento = parsearFecha(datos[2].trim());
        String email = datos[3].trim();

        return new Empleado(apellido, nombre, fechaNacimiento, email);
    }

    private LocalDate parsearFecha(String fecha) {
        try {
            return LocalDate.parse(fecha, FORMATO_FECHA_BARRAS);
        } catch (DateTimeParseException e) {
            try {
                return LocalDate.parse(fecha);
            } catch (DateTimeParseException ex) {
                throw new RuntimeException("Formato de fecha inválido. Use yyyy/MM/dd o yyyy-MM-dd", ex);
            }
        }
    }
}

