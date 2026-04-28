package ejercicio3.mainBD;

import ejercicio3.Modelo.Inscripciones;
import ejercicio3.Persistencia.ConnectionManager;
import ejercicio3.Persistencia.RegistroConcursosBD;
import ejercicio3.Persistencia.RegistroInscripcionesBD;
import ejercicio3.UI.RadioCompetition;

import javax.swing.SwingUtilities;
import java.sql.Connection;

public class Main {

    static void main() {
        SwingUtilities.invokeLater(() -> {
            Connection conexion = ConnectionManager.conectar();

            Inscripciones servicio = new Inscripciones(
                    new RegistroConcursosBD(conexion),
                    new RegistroInscripcionesBD(conexion)
            );

            new RadioCompetition(servicio);
        });
    }
}