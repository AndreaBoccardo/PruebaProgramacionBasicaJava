package vista;

import java.util.Scanner;

/*
  clienteServicio, instancia de ClienteServicio.
 archivoServicio, instancia de ArchivoServicio.
 exportadorCsv, instancia de ExportarCsv.
 exportarTxt, instancia de ExportarTxt.
 * 
 */
public class Menu {
	
	private String fileName = "Clientes";//exportar el archivo
	private String fileName1 = "DBClientes.csv"; //importar el archivo
	private Scanner sc;
	
	public void iniciarMenu() {
		
		
	}
	
	public void listarCliente() {
		//muestra lista de clientes agregados, ya sea por importación o agregando a mano
	}
	
	public void agregarCliente() {
		//solicita ingreso de datos y llena objeto de tipo Cliente
	}
	
	public void editarCliente() {
		//permite la edición de algún cliente en caso de requerirlo o cambiar el estado del cliente
	}
	
	public void importarDatos() {
		//ejecuta la carga de datos del archivo “DBClientes.csv”.
	}
	
	public void exportarDatos() {
		//lama a método para exportar clientes en formato “.txt” o“.csv”.
	}
	
	public void terminarPrograma() {
		//finaliza la ejecución del sistema
	}

}
