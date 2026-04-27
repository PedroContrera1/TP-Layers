package ejercicio1.Persistence;

import ejercicio1.modelo.Participante;
import ejercicio1.modelo.RegistroDeParticipantes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcRegistroDeParticipantes implements RegistroDeParticipantes {
    private final Connection conexion;
    public JdbcRegistroDeParticipantes(Connection conexion){
        this.conexion=conexion;
    }

    @Override
    public void registrar(Participante participante) {
        String sql= ("insert into participantes(nombre, telefono, region) values(?,?,?)");
        try (PreparedStatement st = conexion.prepareStatement(sql)) {
            st.setString(1, participante.nombre());
            st.setString(2, participante.telefono());
            st.setString(3, participante.region());
            st.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Error al guardar participante", e);
        }
    }
}
