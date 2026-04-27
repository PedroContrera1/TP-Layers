package ejercicio1.modelo;

public class Participantes {
    private final RegistroDeParticipantes registroDeParticipantes;
    public Participantes(RegistroDeParticipantes registroDeParticipantes){
        this.registroDeParticipantes=registroDeParticipantes;
    }
    public void nuevoParticipante(String nombre,String telefono,String region){
        var participante=new Participante(nombre, telefono, region);
        this.registroDeParticipantes.registrar(participante);
    }
}
