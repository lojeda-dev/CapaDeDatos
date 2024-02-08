package personaMain;

import personaDAO.PersonaDAOimpl;
import personaDTO.PersonaDTO;

import java.util.List;

public class PersonaTest {
    public static void main(String[] args) {
        PersonaDAOimpl persona = new PersonaDAOimpl();

        //BORRAR
        PersonaDTO eliminarPersona = new PersonaDTO(6);
        System.out.println("DATOS ELIMINADOS: " + persona.borrar(eliminarPersona));

        //ACTUALIZAR
        PersonaDTO actualizarPersona = new PersonaDTO(1,"Leo","Ojeda");
        System.out.println("DATOS ACTUALIZADOS: " + persona.actualizar(actualizarPersona));

        //INSERTAR
        PersonaDTO insertarPersona = new PersonaDTO();
        insertarPersona.setNombre("Josefina");
        insertarPersona.setApellido("Reyes");
        System.out.println("DATOS INSERTADOS: " + persona.insertar(insertarPersona));

        //LISTAR
        List<PersonaDTO> listaPersonas = persona.seleccionar();
        listaPersonas.forEach(p ->{
            System.out.println(p.toString());
        });
    }
}
