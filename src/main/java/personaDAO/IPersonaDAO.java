package personaDAO;

import personaDTO.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface IPersonaDAO {

    List<PersonaDTO> seleccionar() throws SQLException;

    int insertar(PersonaDTO persona) throws SQLException;

    int actualizar(PersonaDTO persona) throws SQLException;

    int borrar(PersonaDTO persona) throws SQLException;
}
