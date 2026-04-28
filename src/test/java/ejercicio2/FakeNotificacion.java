package ejercicio2;

import ejercicio2.model.Notificacion;

import java.util.ArrayList;
import java.util.List;

public class FakeNotificacion implements Notificacion {
    private final List<String> emails = new ArrayList<>();
    private final List<String> mensajes = new ArrayList<>();

    @Override
    public void enviarEmail(String email, String cuerpoDelCorreo) {
        this.emails.add(email);
        this.mensajes.add(cuerpoDelCorreo);
    }

    public String getData() {
        return ultimoEmail();
    }

    public String ultimoEmail() {
        if (emails.isEmpty()) {
            return null;
        }
        return emails.get(emails.size() - 1);
    }

    public String ultimoMensaje() {
        if (mensajes.isEmpty()) {
            return null;
        }
        return mensajes.get(mensajes.size() - 1);
    }

    public int cantidadEnviados() {
        return emails.size();
    }

    public List<String> emailsEnviados() {
        return emails;
    }
}
