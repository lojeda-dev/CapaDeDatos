package personaDAO;

import personaDTO.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOimpl implements IPersonaDAO {
    //
    private Connection conexionTransaccional;
    private static final String JDBC_SELECT = "SELECT id_persona, nombre, apellido FROM personas";
    private static final String JDBC_INSERT = "INSERT INTO personas (nombre,apellido) VALUES (?,?)";
    private static final String JDBC_UPDATE = "UPDATE personas SET nombre = ?, apellido = ? WHERE id_persona = ?";
    private static final String JDBC_DELETE = "DELETE FROM personas WHERE id_persona = ?";

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public PersonaDAOimpl() {
    }

    public PersonaDAOimpl(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<PersonaDTO> seleccionar() throws SQLException {
        List<PersonaDTO> personas = new ArrayList<>();
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = con.prepareStatement(JDBC_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                PersonaDTO persona = new PersonaDTO();
                persona.setIdPersona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                personas.add(persona);
            }
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                if (conexionTransaccional == null) {
                    Conexion.close(con);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERROR AL CERRAR CONEXION SELECCIONAR");
            }
        }
        return personas;
    }

    @Override
    public int insertar(PersonaDTO persona) throws SQLException {
        int registros = 0;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = con.prepareStatement(JDBC_INSERT);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            registros = ps.executeUpdate();
        } finally {
            try {
                Conexion.close(ps);
                if (conexionTransaccional == null) {
                    Conexion.close(con);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("ERROR AL CERRAR CONEXION INSERTAR");
            }
        }
        return registros;
    }

    @Override
    public int actualizar(PersonaDTO persona) throws SQLException {
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = con.prepareStatement(JDBC_UPDATE);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setInt(3, persona.getIdPersona());
            registros = ps.executeUpdate();
        } finally {
            try {
                Conexion.close(ps);
                if (conexionTransaccional == null) {
                    Conexion.close(con);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("ERROR AL CERRAR CONEXION ACTUALIZAR");
            }
        }
        return registros;
    }

    @Override
    public int borrar(PersonaDTO persona) throws SQLException {
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = con.prepareStatement(JDBC_DELETE);
            ps.setInt(1, persona.getIdPersona());
            registros = ps.executeUpdate();
        } finally {
            try {
                Conexion.close(ps);
                if (conexionTransaccional == null) {
                    Conexion.close(con);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                System.out.println("ERROR AL CERRAR CONEXION BORRAR");
            }
        }
        return registros;
    }
}
