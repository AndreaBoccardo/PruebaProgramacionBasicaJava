package servicio;

import modelo.Cliente;

public interface ClienteServicioInt {
	// por definición, estos métodos son públicos, es redundante declararlos
	void listarClientes();

	void agregarCliente(Cliente cli);

	void editarCliente(String opcion, Cliente cli);

	void cambiarEstado();

	void editarDatos();

}
