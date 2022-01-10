package servicio;

import modelo.Cliente;

public interface ClienteServicioInt {
	// por definici�n, estos m�todos son p�blicos, es redundante declararlos
	void listarClientes();

	void agregarCliente(Cliente cli);

	void editarCliente(String opcion, Cliente cli);

	void cambiarEstado();

	void editarDatos();

}
