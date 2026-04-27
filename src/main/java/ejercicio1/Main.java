package ejercicio1;
import ejercicio1.Persistence.ConnectionManager;
import ejercicio1.Persistence.JdbcRegistroDeParticipantes;
import ejercicio1.UI.AgregarParticipantes;
import ejercicio1.modelo.Participantes;
import ejercicio1.modelo.RegistroDeParticipantes;

import java.awt.EventQueue;
public class Main {

    static void main() {
        EventQueue.invokeLater(() -> {

            RegistroDeParticipantes registro =
                    new JdbcRegistroDeParticipantes(ConnectionManager.conectar());

            Participantes participantes =
                    new Participantes(registro);

            new AgregarParticipantes(participantes);
        });
    }
}