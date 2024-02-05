package personaDAO;

import personaDTO.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOimpl implements IPersonaDAO {

    private static final String JDBC_SELECT = "SELECT id_persona, nombre, apellido FROM personas";
    private static final String JDBC_INSERT = "INSERT INTO personas (nombre,apellido) VALUES (?,?)";
    private static final String JDBC_UPDATE = "UPDATE personas SET nombre = ?, SET apellido = ? WHERE id_persona = ?";
    private static final String JDBC_DELETE = "DELETE FROM personas WHERE id_persona = ?";

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    @Override
    public List<PersonaDTO> seleccionar() {
        List<PersonaDTO> personas = new ArrayList<>();
        PersonaDTO persona = new PersonaDTO();
        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(JDBC_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                persona.setIdPersona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("ERROR GET CONNECTION SELECCIONAR");
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(con);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERROR AL CERRAR CONEXIONES SELECCIONAR");
            }
        }
        return personas;
    }

    @Override
    public int indertar(PersonaDTO persona) {
        return 0;
    }

    @Override
    public int actualizar(PersonaDTO persona) {
        return 0;
    }

    @Override
    public int borrar(PersonaDTO persona) {
        return 0;
    }
}
