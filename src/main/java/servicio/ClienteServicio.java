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
	

	}

	@Override
	public void agregarCliente() {
	

	}

	@Override
	public void editarCliente() {
		

	}

}
