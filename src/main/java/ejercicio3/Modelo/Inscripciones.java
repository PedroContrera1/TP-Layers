package ejercicio3.Modelo;

import ejercicio3.Persistencia.RegistroConcursos;
import ejercicio3.Persistencia.RegistroInscripcion;

import java.util.List;

public class Inscripciones {
    private RegistroConcursos registroConcursos;
    private RegistroInscripcion registroInscripciones;

    public Inscripciones(RegistroConcursos registroConcursos, RegistroInscripcion registroInscripciones){
        this.registroConcursos = registroConcursos;
        this.registroInscripciones = registroInscripciones;
    }
    public List<Concurso> concursosAbiertos() {
        return registroConcursos.concursosAbiertos();
    }

    public void inscribir(
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String email,
            Concurso concurso
    ) {
        Participante participante = new Participante(nombre, apellido, dni, telefono, email);
        Inscripcion inscripcion = new Inscripcion(participante, concurso);
        registroInscripciones.guardar(inscripcion);
    }
}
