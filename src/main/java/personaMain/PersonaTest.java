package personaMain;

import personaDAO.Conexion;
import personaDAO.PersonaDAOimpl;
import personaDTO.PersonaDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonaTest {
    public static void main(String[] args) throws SQLException {
        /*
        EN ESTE EJEMPLO UTILIZO EL CONCEPTO DE TRANSACCIONES PARA PODER EJECUTAR MAS DE UNA SENTENCIA SQL ABRIERONDO Y CERRANDO UNA SOLA CONEXION A LA BASE DE DATOS.
        LA MISMA NOS PERMITE UTILIZAR METODOS COMO ROLLBACK PARA REGRESAR A UN ESTADO ANTERIOR DE LA DB, HACER COMMIT DE LOS CAMBIOS O SETEAR EL METODO AUTOCOMMIT.
        ESTA FUNCION ES UTILIZADA SOLAMENTE PARA LAS SENTENCIAS QUE ALTERAN EL ESTADO DE LA BD. (INSERT, UPDATE O DELETE)
        */

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                //SETEAMOS VALOR PARA QUE LOS CAMBIOS NO SE GUARDEN AUTOMATICAMENTE
                conexion.setAutoCommit(false);
            }
            PersonaDAOimpl persona = new PersonaDAOimpl(conexion);

            //BORRAR
            PersonaDTO eliminarPersona = new PersonaDTO(3);
            System.out.println("DATOS ELIMINADOS: " + persona.borrar(eliminarPersona));

            //INSERTAR
            PersonaDTO insertarPersona = new PersonaDTO();
            insertarPersona.setNombre("Sebastian");
            insertarPersona.setApellido("Cardozo");
            System.out.println("DATOS INSERTADOS: " + persona.insertar(insertarPersona));

            //ACTUALIZAR
            PersonaDTO actualizarPersona = new PersonaDTO(1, "Leonel Edgar", "Ojeda");
            System.out.println("DATOS ACTUALIZADOS: " + persona.actualizar(actualizarPersona));

            //LISTAR
            List<PersonaDTO> listaPersonas = persona.seleccionar();
            listaPersonas.forEach(p -> {
                System.out.println(p.toString());
            });

            //EN ESTE MOMENTO SE VAN A REALIZAR LOS CAMBIOS
            conexion.commit();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("ENTRAMOS AL ROLLBACK.");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("ERROR ROLLBACK");
            }
        }
    }
}
