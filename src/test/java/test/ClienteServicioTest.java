package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

class ClienteServicioTest {
	
	public static ClienteServicio cli; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cli = mock(ClienteServicio.class);
	}

	@Test
	public void agregarClienteTest() {
		Cliente c = new Cliente("1-9", "Paty", "Salvo", 2, CategoriaEnum.ACTIVO);
//		when(cli.agregarCliente(c)).thenReturn("OK");
//		String obtenido = cli.agregarCliente(c);
	}

	
	
//	@Test
//	public void agregarClienteNullTest() {
//		
//		
//	}

}
