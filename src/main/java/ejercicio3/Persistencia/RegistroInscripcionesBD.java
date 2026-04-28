package ejercicio3.Persistencia;
import ejercicio3.Modelo.Inscripcion;
import ejercicio3.Modelo.Participante;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistroInscripcionesBD implements RegistroInscripcion {

    private Connection conexion;

    public RegistroInscripcionesBD(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void guardar(Inscripcion inscripcion) {
        Participante participante = inscripcion.participante();

        String sql = """
                INSERT INTO inscriptos(apellido, nombre, telefono, email, idconcurso)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (PreparedStatement st = conexion.prepareStatement(sql)) {
            st.setString(1, participante.apellido());
            st.setString(2, participante.nombre());
            st.setString(3, participante.telefono());
            st.setString(4, participante.email());
            st.setInt(5, Integer.parseInt(inscripcion.concurso().idConcurso()));

            st.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar la inscripción en la base de datos", e);
        }
    }
}