package ejercicio2;

import ejercicio2.email.NotificadorCumpleanosEmail;
import ejercicio2.model.MensajeCumpleanos;
import ejercicio2.model.Notificacion;
import ejercicio2.model.RegistroDeEmpleados;
import ejercicio2.persistence.ArchivoDeTextoEmpleados;


import java.time.MonthDay;

public class Main {

    public static void main(String[] args) {

        RegistroDeEmpleados registro =
                new ArchivoDeTextoEmpleados("empleados.txt");

        Notificacion notificador =
                new NotificadorCumpleanosEmail(
                        "sandbox.smtp.mailtrap.io",
                        2525,
                        "692498a3dff362",
                        "7f757d0825d4b2",
                        "test@mailtrap.io"
                );

        MensajeCumpleanos mensajeCumpleanos =
                new MensajeCumpleanos(registro, notificador);

        mensajeCumpleanos.enviarSaludos(MonthDay.of(9,11));

        System.out.println("Proceso de cumpleaños ejecutado correctamente.");
    }
}