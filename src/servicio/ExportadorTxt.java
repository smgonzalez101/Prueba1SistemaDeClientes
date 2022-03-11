package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		int descargaCorrecta = 0;// variable para validar mensajes al crear carpeta
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String path = "src/";
		System.out.println("___________________________________________________________");
		System.out.println("\n-------Exportar datos en Windows-------");
		System.out.println("Ingrese la ruta en donde desea exportar el archivo Clientes.txt");
		System.out.println("Ejemplo: exportaClientes/Clientes.txt");
		String ruta = sc.nextLine();
		System.out.println("___________________________________________________________");

		File directorio = new File(path + ruta);
		if (!directorio.exists()) {
			directorio.mkdirs();
		}
		try {
			File archivo = new File(directorio + "/" + fileName);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			FileWriter archivoWriter = new FileWriter(archivo);
			PrintWriter printWriter = new PrintWriter(archivoWriter);
			for (Cliente cliente : listaClientes) {
				String lineaCliente = cliente.getRunCliente() + ";" + cliente.getNombreCliente() + ";"
						+ cliente.getApellidoCliente() + ";" + cliente.getAniosCliente() + ";"
						+ cliente.getNombreCategoria();
				printWriter.write(lineaCliente);
				printWriter.println();
				descargaCorrecta = 1;// variable para validar mensajes al crear carpeta
			}
			printWriter.close();

		} catch (IOException e) {
			System.out.println("No se pudo crear el archivo");
		}

		if (descargaCorrecta != 0) {

			System.out.println("___________________________________________________________");
			System.out.println("Datos de clientes exportados correctamente en formato.txt\n");
			System.out.println("___________________________________________________________");
		}
	}
}
