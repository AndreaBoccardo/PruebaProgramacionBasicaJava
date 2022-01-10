package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio implements ClienteServicioInt {

	private List<Cliente> listaClientes;
	Scanner sc = new Scanner(System.in);

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
		listaClientes.forEach(c -> System.out.println("-------------Datos del Cliente-------------\n"
				+ (c.toString() + "\n-------------------------------------------")));
	}

	@Override
	public void agregarCliente(Cliente cli) {

		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(cli.getRunCliente())) {
				System.out.println("Ya existe un cliente con ese RUN");
			} else {
				listaClientes.add(cli);
				System.out.println("Cliente agregado exitosamente");
			}
		}
	}

	@Override
	public void editarCliente(String opcion, Cliente cli) {
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione qué desea hacer:");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese opcion:");
		String op = sc.next();
		System.out.println("----------------------------------------");
		switch (op) {
		case "1":
			cambiarEstado();
			break;
		case "2":
			editarDatos();
			break;
		default:
			System.out.println("La opción no es válida");
			break;
		}
	}

	@Override
	public void cambiarEstado() {
		System.out.println("Ingrese RUN del Cliente a editar:");
		String run = sc.next();
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente() != null) {
				Stream<Cliente> cli = listaClientes.stream().filter(c -> cliente.getRunCliente().equals(run));
				System.out.println("-----Actualizando estado del Cliente----");
				System.out.println("El estado actual es: " + cliente.getNombreCategoria());
				System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
				System.out.println("2.-Si desea mantener/cambiar el estado del cliente a Activo");
				System.out.println("Ingrese opcion: ");
				int opc = sc.nextInt();
				System.out.println("----------------------------------------");
				if (opc == 1) {
					cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
				}
			} else {
				cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
			}
		}

	}

	@Override
	public void editarDatos() {
		System.out.println("Ingrese RUN del Cliente a editar:");
		String run = sc.nextLine();
		System.out.println("----Actualizando datos del Cliente-----");
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(run)) {
				System.out.printf("1.-El RUN del Cliente es:  %s \n\r", cliente.getRunCliente());
				System.out.printf("2.-El Nombre del Cliente es:  %s \n\r", cliente.getNombreCliente());
				System.out.printf("3.-El Apellido del Cliente es:  %s \n\r", cliente.getApellidoCliente());
				System.out.printf("4.-Los años como Cliente son:  %s  años \n\r", cliente.getAniosCliente());
				System.out.println("Ingrese la opción a editar de los datos del cliente:");
				int opEditar = sc.nextInt();
				String n = "";

				switch (opEditar) {
				case 1:
					System.out.println("1.-Ingrese el nuevo RUN del Cliente:");
					n = sc.next();
					cliente.setRunCliente(n);
					break;
				case 2:
					System.out.println("2.-Ingrese el nuevo Nombre del Cliente:");
					n = sc.next();
					cliente.setNombreCliente(n);
					break;
				case 3:
					System.out.println("1.-Ingrese el nuevo Apellido del Cliente:");
					n = sc.next();
					cliente.setApellidoCliente(n);
					;
					break;
				case 4:
					System.out.println("1.-Ingrese los nuevos años como Cliente:");
					n = sc.next();
					cliente.setAniosCliente(Integer.parseInt(n));
					;
					break;
				default:
					System.out.println("Opción no válida");
					break;
				}
			} else {
				System.out.println("No existe un cliente con ese RUN");
			}
		}
	}

}
