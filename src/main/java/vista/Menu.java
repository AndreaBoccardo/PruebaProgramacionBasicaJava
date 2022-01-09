package vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;


public class Menu {
	
	private Scanner sc;
	private ClienteServicio cs;
	private ExportadorCsv exportadorCsv;
	private ExportadorTxt exportarTxt;
	private ArchivoServicio as;
	private String fileName = "Clientes";//exportar el archivo
	private String fileName1 = "DBClientes.csv"; //importar el archivo
	private Utilidad ut;
	
	
	public Menu() {
		sc = new Scanner(System.in);
		cs = new ClienteServicio();
		as = new ArchivoServicio();
		exportadorCsv = new ExportadorCsv();
		exportarTxt = new ExportadorTxt();
		ut = new Utilidad();
		
	}
	
	public void iniciarMenu() {
		int opcion = 0;
		
		do {
			System.out.println("Bienvenido a Pastelería Bon Bon Jovi");
			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Cargar Datos");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.println("Ingrese una opción: ");
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
				System.out.println("La opción ingresada no es válida");
				break;
			}
		} while (opcion != 6);
	}
	
	public void listarCliente() {
		//muestra lista de clientes agregados, ya sea por importación o agregando a mano
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
		sc.nextLine();
		String run = sc.nextLine();
		System.out.println("Ingresa el Nombre del Cliente: ");
		String nombre = sc.nextLine();
		System.out.println("Ingresa el Apellido del Cliente: ");
		String apellido = sc.nextLine();
		System.out.println("Ingresa los años como Cliente:");
		int anios = sc.nextInt();
		System.out.println("---------------------------------------");
		Cliente c = new Cliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);
		cs.agregarCliente(c);
	}
	
	public void editarCliente() {
		//permite la edición de algún cliente en caso de requerirlo o cambiar el estado del cliente
		cs.editarCliente(0, null);
		
	}
	
	public void importarDatos() {
		//ejecuta la carga de datos del archivo “DBClientes.csv”.
		System.out.println("---------Cargar Datos-----------");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		String fileName = sc.nextLine();
		
		try {
			for (Cliente c : as.cargarDatos(fileName)) {
				cs.agregarCliente(c);
			}
			
			System.out.println("Datos cargados correctamente en la lista");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void exportarDatos() {
		//lama a método para exportar clientes en formato “.txt” o“.csv”.
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("Ingrese una opción para exportar:");
		String op = sc.nextLine();
		System.out.println("----------------------------------");
		
		switch (op) {
		case "1":
			System.out.println("---------Exportar Datos-----------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			String fileName = sc.nextLine();
			try {
				exportadorCsv.exportar(fileName, cs.getListaClientes());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "2":
			System.out.println("---------Exportar Datos-----------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			String fileName1 = sc.nextLine();
			try {
				exportarTxt.exportar(fileName1, cs.getListaClientes());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	public void terminarPrograma() {
		//finaliza la ejecución del sistema
		ut.esperar();
		ut.limpiarPantalla();
		System.out.println("Gracias por usar nuestro sistema. Hasta luego");
		System.out.println("Abandonando el sistema de clientes...");
		System.out.println("Acaba de salir del sistema");
		System.exit(0);
	}

}
