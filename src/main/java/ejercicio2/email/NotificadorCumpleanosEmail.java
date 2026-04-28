package ejercicio2.email;

import ejercicio2.model.Notificacion;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class NotificadorCumpleanosEmail implements Notificacion {
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String remitente;
    public NotificadorCumpleanosEmail (String host, int port, String username, String password, String remitente) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.remitente = remitente;
    }
    @Override
    public void enviarEmail(String email, String cuerpoDelCorreo) {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", host);
        propiedades.put("mail.smtp.port", String.valueOf(port));
        Session session = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            mensaje.setSubject("Saludo de feliz cumpleanos");
            mensaje.setText(cuerpoDelCorreo);

            Transport.send(mensaje);
        } catch (MessagingException e) {
            throw new RuntimeException("No se pudo enviar el email de inscripción", e);
        }
    }

}
