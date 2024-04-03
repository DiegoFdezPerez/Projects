package data_acces_test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import data_acces.UserGateway;
import enities.User;

class UserGatewayTests {

	@Test
	void simpleGatewayTest() throws SQLException {
		
		try {
		//Obtener instancia del gateway
		UserGateway gatewayInstance = UserGateway.getInstance();
		
		//Insertar 2 usuarios
		gatewayInstance.insert( "Pedro", "Vendedor");
		gatewayInstance.insert( "Juan", "Administrador");
		
		//Obtener todos los usuarios
		List<User> users = gatewayInstance.getAll();
		
		//Deberían haber 7 usuarios registrados
		Assertions.assertEquals (7,users.size());
	
		//Actualizamos uno de los usuarios
		gatewayInstance.update(7, "Diana", "Vendedor");
		
		//Obtenemos el usuario para ver si el nombre fue cambiado
		User updatedUser = gatewayInstance.getById(7);
		
		Assertions.assertNotNull(updatedUser);
		Assertions.assertEquals("Diana", updatedUser.getName());
		
		//Eliminar un usuario
		gatewayInstance.delete(6);
		
		//Ahora deben haber 6 objetos tipo User
		users = gatewayInstance.getAll();
		Assertions.assertEquals(6, users.size());
		
		//Si tratamos de obtener el usuario por ID nos debe devolver null
		User deletedUser = gatewayInstance.getById(6);
		Assertions.assertNull(deletedUser);}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
