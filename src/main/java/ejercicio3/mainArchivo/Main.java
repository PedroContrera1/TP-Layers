package ejercicio3.mainArchivo;

import ejercicio3.Modelo.Inscripciones;
import ejercicio3.Persistencia.ArchivoConcursos;
import ejercicio3.Persistencia.ArchivoInscripciones;
import ejercicio3.Persistencia.RegistroConcursos;
import ejercicio3.Persistencia.RegistroInscripcion;
import ejercicio3.UI.RadioCompetition;

import javax.swing.*;

public class Main {

     static void main() {
        SwingUtilities.invokeLater(() -> {
            RegistroConcursos concursos =
                    new ArchivoConcursos("concursos.txt");

            RegistroInscripcion inscripciones =
                    new ArchivoInscripciones("inscriptos.txt");

            Inscripciones servicio =
                    new Inscripciones(concursos, inscripciones);

            new RadioCompetition(servicio);
        });
    }
}