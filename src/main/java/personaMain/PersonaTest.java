package personaMain;

import personaDAO.PersonaDAOimpl;
import personaDTO.PersonaDTO;

import java.util.List;

public class PersonaTest {
    public static void main(String[] args) {
        //LISTAR
        PersonaDAOimpl persona = new PersonaDAOimpl();
        List<PersonaDTO> listaPersonas = persona.seleccionar();
        listaPersonas.forEach(p ->{
            System.out.println(p.toString());
        });
    }
}
