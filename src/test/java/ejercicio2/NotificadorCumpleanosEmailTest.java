package ejercicio2;

import ejercicio2.email.NotificadorCumpleanosEmail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotificadorCumpleanosEmailTest {

    @Test
    public void noPuedeEnviarEmailConDireccionInvalida() {
        NotificadorCumpleanosEmail notificador =
                new NotificadorCumpleanosEmail(
                        "sandbox.smtp.mailtrap.io",
                        2525,
                        "usuario",
                        "password",
                        "test@mailtrap.io"
                );

        assertThrows(RuntimeException.class, () ->
                notificador.enviarEmail("email-invalido", "Feliz cumpleaños")
        );
    }
}