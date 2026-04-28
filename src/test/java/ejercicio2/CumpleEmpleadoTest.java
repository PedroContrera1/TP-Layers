package ejercicio2;

import ejercicio2.model.Empleado;
import ejercicio2.model.MensajeCumpleanos;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CumpleEmpleadoTest {
    @Test
    public void test01() {
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
}
