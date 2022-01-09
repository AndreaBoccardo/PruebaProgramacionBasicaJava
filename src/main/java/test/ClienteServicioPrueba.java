package test;

import java.util.List;
import modelo.Cliente;

public class ClienteServicioPrueba {

	private List<Cliente> listaClientes;

	public String agregarCliente(Cliente cli) {

		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(cli.getRunCliente())) {
				System.out.println("Ya existe un cliente con ese RUN");
			} else {
				listaClientes.add(cli);
				System.out.println("Cliente agregado exitosamente");
			}
		}
		return "OK";
	}
}
