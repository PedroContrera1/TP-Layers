package ejercicio3.Persistencia;
import ejercicio3.Modelo.Concurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroConcursosBD implements RegistroConcursos {

    private Connection conexion;

    public RegistroConcursosBD(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Concurso> concursosAbiertos() {
        List<Concurso> concursos = new ArrayList<>();

        String sql = """
                SELECT idconcurso, nombre, fecha_inicio_inscripcion, fecha_fin_inscripcion
                FROM concursos
                WHERE CURRENT_DATE BETWEEN fecha_inicio_inscripcion AND fecha_fin_inscripcion
                """;

        try (PreparedStatement st = conexion.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                concursos.add(new Concurso(
                        String.valueOf(rs.getInt("idconcurso")),
                        rs.getString("nombre"),
                        rs.getDate("fecha_inicio_inscripcion").toLocalDate(),
                        rs.getDate("fecha_fin_inscripcion").toLocalDate()
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException("No se pudieron obtener los concursos abiertos", e);
        }

        return concursos;
    }
}