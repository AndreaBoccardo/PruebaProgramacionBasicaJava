package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String path, List<Cliente> listaClientes) throws FileNotFoundException {
		File carpeta = new File(path);
		File archivo = new File(String.format("%s/clientes.txt", path));
		try {
			if (!carpeta.exists()) {
				carpeta.mkdir();
				archivo.createNewFile();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (archivo.exists()) {
			System.out.println("El archivo no se encuentra en esa ruta.");

		} else {
			try {
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter escritor = new BufferedWriter(fw);
				for (Cliente cliente : listaClientes) {
					String e = String.format("%s,%s,%s,%s,%s", cliente.getRunCliente(), cliente.getNombreCliente(),
							cliente.getApellidoCliente(), String.valueOf(cliente.getAniosCliente()),
							cliente.getNombreCategoria());
					escritor.write(e);
					escritor.newLine();
				}
				escritor.close();
				System.out.println("-----------------------------------------------");
				System.out.println("Datos de clientes exportados correctamente en formato txt.");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
