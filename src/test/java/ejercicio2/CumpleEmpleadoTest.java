package ejercicio2;

import ejercicio2.model.Empleado;
import ejercicio2.model.MensajeCumpleanos;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CumpleEmpleadoTest {
    @Test
    public void enviaMailSoloAlEmpleadoQueCumpleanios() {
        var fakeNotificacion = new FakeNotificacion();
        var mensaje = new MensajeCumpleanos(() -> {
            return List.of(new Empleado("Contrera", "Pedro",
                            LocalDate.of(2003, 9, 3), "pedrocontrera1745@gmail.com"),
                    new Empleado("Mellado", "Matias",
                            LocalDate.of(2003, 2, 28), "matias@gmail.com"));
        }, fakeNotificacion);
        mensaje.enviarSaludos(MonthDay.of(9, 3));
        assertEquals("pedrocontrera1745@gmail.com",fakeNotificacion.getData());
    }
    @Test
    public void noEnviaMailSiNingunEmpleadoCumpleanios() {
        var fakeNotificacion = new FakeNotificacion();

        var mensaje = new MensajeCumpleanos(() -> List.of(
                new Empleado("Contrera", "Pedro",
                        LocalDate.of(2003, 9, 3), "pedrocontrera1745@gmail.com"),
                new Empleado("Mellado", "Matias",
                        LocalDate.of(2003, 2, 28), "matias@gmail.com")
        ), fakeNotificacion);

        mensaje.enviarSaludos(MonthDay.of(12, 25));

        assertEquals(0, fakeNotificacion.cantidadEnviados());
        assertNull(fakeNotificacion.ultimoEmail());
    }

    @Test
    public void enviaMailATodosLosEmpleadosQueCumplenAniosElMismoDia() {
        var fakeNotificacion = new FakeNotificacion();

        var mensaje = new MensajeCumpleanos(() -> List.of(
                new Empleado("Young", "Angus",
                        LocalDate.of(1982, 10, 8), "angus@acdc.com"),
                new Empleado("Johnson", "Brian",
                        LocalDate.of(1975, 10, 8), "brian@acdc.com"),
                new Empleado("Mellado", "Matias",
                        LocalDate.of(2003, 2, 28), "matias@gmail.com")
        ), fakeNotificacion);

        mensaje.enviarSaludos(MonthDay.of(10, 8));

        assertEquals(2, fakeNotificacion.cantidadEnviados());
        assertEquals(List.of("angus@acdc.com", "brian@acdc.com"), fakeNotificacion.emailsEnviados());
    }
}
