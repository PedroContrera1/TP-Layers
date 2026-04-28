package ejercicio3.Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/concursos_db?useSSL=false";
        String user = "root";
        String password = "";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo conectar a la base de datos", e);
        }
    }
}
