package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteServicio implements ClienteServicioInt {

	private List<Cliente> listaClientes;
	
	public ClienteServicio() {
		super();
		listaClientes = new ArrayList<>();
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}

	@Override
	public void listarClientes() {
	listaClientes.forEach(c -> 
	System.out.println("-------------Datos del Cliente-------------\n" + 
	(c.toString() + "\n-------------------------------------------")));
	}

	@Override
	public void agregarCliente(Cliente cli) {
	
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(cli.getRunCliente())) {
				System.out.println("Ya existe un cliente con ese rut");
			} else {
				listaClientes.add(cli);
				System.out.println("Cliente agregado exitosamente");
			}	
		}
	}

	@Override
	public void editarCliente(Cliente cli) {
		

	}

}
