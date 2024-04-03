package bussines_logic_test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import business_logic.UserService;
import data_acces.UserGateway;
import enities.User;

class UserServiceTest {

	@Test
	void simpleGatewayTest() throws SQLException {
		
		try {
		//Obtener instancia del servicio
		UserService service = new UserService();
		
		//Insertar 2 usuarios
		service.insert( "Pedro", "Vendedor");
		service.insert( "Juan", "Administrador");
		
		//Obtener todos los usuarios
		List<User> users = service.getAll();
		
		//Deberían haber 7 usuarios registrados
		Assertions.assertEquals (7,users.size());
	
		//Actualizamos uno de los usuarios
		service.update(7, "Javier", "Vendedor");
		
		//Obtenemos el usuario para ver si el nombre fue cambiado
		User updatedUser = service.getById(7);
		
		Assertions.assertNotNull(updatedUser);
		Assertions.assertEquals("Javier", updatedUser.getName());
		
		//Eliminar un usuario
		service.delete(6);
		
		//Ahora deben haber 6 objetos tipo User
		users = service.getAll();
		Assertions.assertEquals(6, users.size());
		
		//Si tratamos de obtener el usuario por ID nos debe devolver null
		User deletedUser = service.getById(6);
		Assertions.assertNull(deletedUser);}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
