package ejercicio2;

import ejercicio2.model.Empleado;
import ejercicio2.persistence.ArchivoDeTextoEmpleados;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoEmpleadosTest {

    @TempDir
    Path tempDir;

    @Test
    public void leeEmpleadosDesdeArchivoConFormatoBarras() throws IOException {
        Path archivo = tempDir.resolve("empleados.txt");
        Files.writeString(archivo, "Young, Angus, 1982/10/08, angus@acdc.com\n");

        ArchivoDeTextoEmpleados registro = new ArchivoDeTextoEmpleados(archivo.toString());

        List<Empleado> empleados = registro.empleados();

        assertEquals(1, empleados.size());
        assertEquals("Young", empleados.get(0).apellido());
        assertEquals("Angus", empleados.get(0).nombre());
        assertEquals(LocalDate.of(1982, 10, 8), empleados.get(0).fechaDeNacimiento());
        assertEquals("angus@acdc.com", empleados.get(0).email());
    }

    @Test
    public void lanzaErrorSiLaLineaNoTieneCuatroDatos() throws IOException {
        Path archivo = tempDir.resolve("empleados.txt");
        Files.writeString(archivo, "Young, Angus, 1982/10/08\n");

        ArchivoDeTextoEmpleados registro = new ArchivoDeTextoEmpleados(archivo.toString());

        RuntimeException ex = assertThrows(RuntimeException.class, registro::empleados);

        assertTrue(ex.getMessage().contains("Formato inválido"));
    }

    @Test
    public void lanzaErrorSiLaFechaTieneFormatoInvalido() throws IOException {
        Path archivo = tempDir.resolve("empleados.txt");
        Files.writeString(archivo, "Young, Angus, 08-10-1982, angus@acdc.com\n");

        ArchivoDeTextoEmpleados registro = new ArchivoDeTextoEmpleados(archivo.toString());

        RuntimeException ex = assertThrows(RuntimeException.class, registro::empleados);

        assertTrue(ex.getMessage().contains("Formato de fecha inválido"));
    }
}