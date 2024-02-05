package personaDAO;

import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/capa_de_datos?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }
    public static void close(Connection con) throws SQLException {
        con.close();
    }
}
