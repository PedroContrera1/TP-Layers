package ejercicio3.Modelo;

import java.time.LocalDate;

public class Inscripcion {

    private Participante participante;
    private Concurso concurso;
    public Inscripcion(Participante participante, Concurso concurso) {
        if (participante == null) {
            throw new RuntimeException("La persona es obligatoria");
        }

        if (concurso == null) {
            throw new RuntimeException("Debe elegir un concurso");
        }

        this.participante = participante;
        this.concurso = concurso;
    }

    public Participante participante() {
        return participante;
    }

    public Concurso concurso() {
        return concurso;
    }
}