package ejercicio2;

import ejercicio2.model.Notificacion;

public class FakeNotificacion implements Notificacion {
    private String data;

    @Override
    public void enviarEmail(String email, String cuerpoDelCorreo) {
        this.data=email;
    }

    public String getData(){
        return this.data;
    }
}
