package vista;

import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

/*

 archivoServicio, instancia de ArchivoServicio.
 exportadorCsv, instancia de ExportarCsv.
 exportarTxt, instancia de ExportarTxt.
 * 
 */
public class Menu {
	
	private ClienteServicio cs;
	private String fileName = "Clientes";//exportar el archivo
	private String fileName1 = "DBClientes.csv"; //importar el archivo
	private Scanner sc;
	
	public Menu() {
		sc = new Scanner(System.in);
		cs = new ClienteServicio();
		
	}
	
	public void iniciarMenu() {
		int opcion = 0;
		
		do {
			System.out.println("Bienvenido a Pasteler�a Bon Bon Jovi");
			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Cargar Datos");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.println("Ingrese una opci�n: ");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				listarCliente();
				break;
			case 2:
				agregarCliente();
				break;
			case 3:
				editarCliente();
				break;
			case 4:
				importarDatos();
				break;
			case 5:
				exportarDatos();
				break;
			case 6:
				terminarPrograma();
				break;
			default:
				System.out.println("La opci�n ingresada no es v�lida");
				break;
			}
		} while (opcion != 6);
	}
	
	public void listarCliente() {
		//muestra lista de clientes agregados, ya sea por importaci�n o agregando a mano
		if (cs.getListaClientes().size() == 0) {
			System.out.println("No hay Clientes para visualizar");
		} else {
			cs.listarClientes();
		}
	}
	
	public void agregarCliente() {
		//solicita ingreso de datos y llena objeto de tipo Cliente
		System.out.println("-------------Crear Cliente-------------");
		System.out.println("Ingresa el RUN del Cliente: ");
		String run = sc.nextLine();
		System.out.println("Ingresa el Nombre del Cliente: ");
		String nombre = sc.nextLine();
		System.out.println("Ingresa el Apellido del Cliente: ");
		String apellido = sc.nextLine();
		System.out.println("Ingresa los a�os como Cliente:");
		int anios = sc.nextInt();
		System.out.println("---------------------------------------");
		Cliente c = new Cliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);
		cs.agregarCliente(c);
	}
	
	public void editarCliente() {
		//permite la edici�n de alg�n cliente en caso de requerirlo o cambiar el estado del cliente
		cs.editarCliente(0, null);
		
	}
	
	public void importarDatos() {
		//ejecuta la carga de datos del archivo �DBClientes.csv�.
	}
	
	public void exportarDatos() {
		//lama a m�todo para exportar clientes en formato �.txt� o�.csv�.
	}
	
	public void terminarPrograma() {
		//finaliza la ejecuci�n del sistema
	}

}
