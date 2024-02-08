package personaDAO;

import personaDTO.PersonaDTO;

import java.util.List;

public interface IPersonaDAO {

    List<PersonaDTO> seleccionar();

    int insertar(PersonaDTO persona);

    int actualizar(PersonaDTO persona);

    int borrar(PersonaDTO persona);
}
