package ejercicio2;

import ejercicio2.model.Empleado;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void sabeSiEsSuCumpleanios() {
        Empleado empleado = new Empleado("Young", "Angus",
                LocalDate.of(1982, 10, 8), "angus@acdc.com");

        assertTrue(empleado.esTuCumple(MonthDay.of(10, 8)));
        assertFalse(empleado.esTuCumple(MonthDay.of(9, 11)));
    }

    @Test
    public void exponeSusDatos() {
        Empleado empleado = new Empleado("Johnson", "Brian",
                LocalDate.of(1975, 9, 11), "brian@acdc.com");

        assertEquals("Johnson", empleado.apellido());
        assertEquals("Brian", empleado.nombre());
        assertEquals(LocalDate.of(1975, 9, 11), empleado.fechaDeNacimiento());
        assertEquals("brian@acdc.com", empleado.email());
    }

    @Test
    public void noPermiteNombreVacio() {
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                new Empleado("Young", "", LocalDate.of(1982, 10, 8), "angus@acdc.com")
        );

        assertEquals("Nombre inválido", ex.getMessage());
    }

    @Test
    public void noPermiteApellidoVacio() {
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                new Empleado("", "Angus", LocalDate.of(1982, 10, 8), "angus@acdc.com")
        );

        assertEquals("Apellido inválido", ex.getMessage());
    }

    @Test
    public void noPermiteFechaNula() {
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                new Empleado("Young", "Angus", null, "angus@acdc.com")
        );

        assertEquals("Fecha inválida", ex.getMessage());
    }

    @Test
    public void noPermiteEmailInvalido() {
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                new Empleado("Young", "Angus", LocalDate.of(1982, 10, 8), "angusacdc.com")
        );

        assertEquals("Email inválido", ex.getMessage());
    }
}
