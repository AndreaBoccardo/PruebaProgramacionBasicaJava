package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;

class ClienteServicioTest {
	
	public static ClienteServicioPrueba cs;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cs = mock(ClienteServicioPrueba.class);
	}

	
	@Test
	public void agregarClienteTest() {
		Cliente c1 = new Cliente("1-9", "Paty", "Salvo", 3, CategoriaEnum.ACTIVO);
		Cliente c2 = new Cliente("1-3", "Mika", "Aparicio", 6, CategoriaEnum.ACTIVO);
		Cliente c3 = new Cliente("2-2", "Olaf", "Guerra", 2, CategoriaEnum.INACTIVO);
		
		when(cs.agregarCliente(c1)).thenReturn("OK");
		String obtenido1 = cs.agregarCliente(c1);
		assertEquals("OK", obtenido1);
		verify(cs).agregarCliente(c1);
		
		when(cs.agregarCliente(c2)).thenReturn("OK");
		String obtenido2 = cs.agregarCliente(c2);
		assertEquals("OK", obtenido2);
		verify(cs).agregarCliente(c2);
		
		when(cs.agregarCliente(c3)).thenReturn("OK");
		String obtenido3 = cs.agregarCliente(c3);
		assertEquals("OK", obtenido3);
		verify(cs).agregarCliente(c3);
		
		
	}
	
	@Test
	public void agregarClienteNullTest() {
		Cliente c = new Cliente("", "", "", 0, CategoriaEnum.INACTIVO);
		when(cs.agregarCliente(c)).thenReturn("OK");
		String obtenido = cs.agregarCliente(c);
		assertEquals("OK", obtenido);
		verify(cs).agregarCliente(c);
		
	}

}
