package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {

	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv = new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();
	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";

	Scanner sc = new Scanner(System.in);

	@Override
	public void listarClientes() {

		clienteServicio.retornolistarClientes();

		System.out.println();

	}

	@Override
	public void agregarCliente() {

		@SuppressWarnings("unused") // restringir al compilador para que muestre una advertencia en consola.

		Cliente agregadoCliente = new Cliente();// Instancia para crear cliente nuevo

		System.out.println("___________________________________________________________\n");
		System.out.println("                   Creando al Cliente");
		System.out.println("___________________________________________________________\n");
		System.out.println("Ingresa RUN del cliente, con puntos y guión: ");

		String run = sc.nextLine();

		while (run.isEmpty()) {// comprueba si una cadena está vacía o no.
			System.out.println("No puede dejar datos en blanco.");
			System.out.println("Ingresa RUN del cliente, con puntos y guión: ");

			run = sc.nextLine();
		}

		System.out.println("Ingresa nombre del cliente: ");
		String nombre = sc.nextLine();

		while (nombre.isEmpty()) {
			System.out.println("No puede dejar datos en blanco.");
			System.out.println("Ingrese nombre del cliente");
			nombre = sc.nextLine();
		}
		System.out.println("Ingrese apellido del cliente: ");
		String apellido = sc.nextLine();

		while (apellido.isEmpty()) {
			System.out.println("No puede dejar datos en blanco.");
			System.out.println("Ingrese apellido del cliente");
			apellido = sc.nextLine();
		}

		System.out.println("Ingresa años como cliente: ");
		String anios = sc.nextLine();

		while (anios.isEmpty()) {
			System.out.println("No puede dejar datos en blanco.");
			System.out.println("Ingrese años como cliente");
			anios = sc.nextLine();
		}
		System.out.println("\nInformación del cliente ingresada.");
		System.out.println("___________________________________________________________\n");

		clienteServicio.agregarCliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);// pasar los datos del

	}

	@Override
	public void editarCliente() {
		System.out.println("___________________________________________________________\n");
		System.out.println("                    Editar Cliente");
		System.out.println("___________________________________________________________\n");

		System.out.println("Seleccione qué desea hacer: ");
		System.out.println("1.- Cambiar el estado del Cliente:       ");
		System.out.println("2.- Editar los datos del Cliente:     ");
		Utilidad.mensajeIngreseOpcion();
		int opcion = sc.nextInt();
		sc.nextLine();
		if (opcion == 1 || opcion == 2) {
			System.out.println("Ingrese RUN del Cliente, con puntos y guión:      ");
			String runEditar = sc.nextLine();
			System.out.println();

			int validarExiste = 0;// variable para validar mensaje de no existe run.
			for (Cliente clienteEditado : clienteServicio.getListaClientes()) {
				if (clienteEditado.getRunCliente().equals(runEditar)) {
					validarExiste = 1;

					if (opcion == 1) {
						System.out.println("___________________________________________________________\n");
						System.out.println("       Actualizando estado del Cliente/n");
						System.out.println("___________________________________________________________\n");
						System.out.println("El estado actual es: " + clienteEditado.getNombreCategoria());
						System.out.println("1.- Si desea cambiar el estado del Cliente a Inactivo");
						System.out.println("2.- Si desea mantener el estado del Cliente Activo ");
						Utilidad.mensajeIngreseOpcion();
						int opEditar = sc.nextInt();
						sc.nextLine();
						if (opEditar == 1) {
							clienteEditado.setNombreCategoria(CategoriaEnum.INACTIVO);
							System.out.println("___________________________________________________________\n");
							System.out.println("El cambio fue realizado.");
							System.out.println("El nuevo estado del Cliente es: " + CategoriaEnum.INACTIVO);
							System.out.println("___________________________________________________________\n");
						} else if (opEditar == 2) {
							clienteEditado.setNombreCategoria(CategoriaEnum.ACTIVO);
							System.out.println("El estado del Cliente continúa en " + CategoriaEnum.ACTIVO);
							System.out.println();
						} else {
							System.out.println("___________________________________________________________\n");
							System.out.println("Opción incorrecta. \nIngresará nuevamente al sistema");
							System.out.println("___________________________________________________________\n");
						}

					} else if (opcion == 2) {
						System.out.println("___________________________________________________________\n");
						System.out.println("       ----Actualizando datos del Cliente----\n");
						System.out.println("1.- El RUN del Cliente es: " + clienteEditado.getRunCliente());
						System.out.println("2.- El Nombre del Cliente es: " + clienteEditado.getNombreCliente());
						System.out.println("3.- El Apellido del Cliente es: " + clienteEditado.getApellidoCliente());
						System.out.println("4.- Los años como Cliente son: " + clienteEditado.getAniosCliente());
						Utilidad.mensajeIngreseOpcion();
						int opcionEditar = sc.nextInt();
						sc.nextLine();
						System.out.println();

						switch (opcionEditar) {
						case 1:
							System.out.println("Ingrese nuevo RUN del Cliente, con puntos y guión: ");
							String runModificado = sc.nextLine();

							while (runModificado.isEmpty()) {
								System.out.println("No puede dejar datos en blanco.");
								System.out.println("Ingrese nuevamente RUN del Cliente, con puntos y guión.");
								runModificado = sc.nextLine();
							}

							clienteEditado.setRunCliente(runModificado);
							System.out.println("___________________________________________________________\n");
							System.out.println("Dato cambiado con éxito.\nEl nuevo RUN es: " + runModificado);
							System.out.println("___________________________________________________________\n");
							break;
						case 2:
							System.out.println("Ingrese nuevo Nombre del Cliente");
							String nuevoNombre = sc.nextLine();

							while (nuevoNombre.isEmpty()) {
								System.out.println("No puede dejar datos en blanco.");
								System.out.println("Ingrese nuevo Nombre del Cliente");
								nuevoNombre = sc.nextLine();
							}

							clienteEditado.setNombreCliente(nuevoNombre);
							System.out.println("___________________________________________________________\n");
							System.out
									.println("Dato cambiado con éxito.\nEl nuevo Nombre ingresado es: " + nuevoNombre);
							System.out.println("___________________________________________________________\n");
							break;
						case 3:
							System.out.println("Ingrese nuevo Apellido del Cliente");
							String nuevoApellido = sc.nextLine();

							while (nuevoApellido.isEmpty()) {
								System.out.println("No puede dejar datos en blanco");
								System.out.println("Ingrese nuevo Apellido del Cliente");
								nuevoApellido = sc.nextLine();
							}

							clienteEditado.setApellidoCliente(nuevoApellido);
							System.out.println("___________________________________________________________\n");
							System.out.println("Dato cambiado con éxito.\nEl nuevo Apellido es: " + nuevoApellido);
							System.out.println("___________________________________________________________\n");
							break;
						case 4:
							System.out.println("Ingrese nuevos años como Cliente");
							String nuevoAnio = sc.nextLine();

							while (nuevoAnio.isEmpty()) {
								System.out.println("No puede dejar datos en blanco");
								System.out.println("Ingrese nuevos años como Cliente");
								nuevoAnio = sc.nextLine();
							}

							clienteEditado.setAniosCliente(nuevoAnio);
							System.out.println("___________________________________________________________\n");
							System.out.println("Dato cambiado con éxito.\nLos nuevos años son: " + nuevoAnio);
							System.out.println("___________________________________________________________\n");

						default:
							break;
						}
						if (opcionEditar <= 0 || opcionEditar >= 5) {
							System.out.println("___________________________________________________________\n");
							System.out.println("Opción incorrecta. \nIngresará nuevamente al sistema");
							System.out.println("___________________________________________________________\n");

						}
					} else {
						System.out.println("___________________________________________________________\n");
						System.out.println("Opción incorrecta. \nIngresará nuevamente al sistema");
						System.out.println("___________________________________________________________\n");
					}
				}
			}

			if (validarExiste != 1) {
				System.out.println("Run no encontrado, ingrese nuevamente al sistema");
			}

		} else {
			System.out.println("___________________________________________________________\n");
			System.out.println("Opción incorrecta. \nIngresará nuevamente al sistema");
			System.out.println("___________________________________________________________\n");
		}
	}

	@Override
	public void cargarDatos() {

		archivoServicio.cargarDatos(fileName1, clienteServicio.getListaClientes());
	}

	@Override
	public void exportarDatos() {
		System.out.println("___________________________________________________________\n");
		System.out.println("       ------------Exportar Datos----------------");
		System.out.println("Seleccione el formato a exportar:         ");
		System.out.println("1.- Formato csv");
		System.out.println("2.- Formato txt \n");
		Utilidad.mensajeIngreseOpcion();
		int opcion = sc.nextInt();
		sc.nextLine();

		if (opcion == 1) {

			exportadorCsv.exportar(fileName, clienteServicio.getListaClientes());

		} else {
			if (opcion == 2) {

				exportadorTxt.exportar(fileName, clienteServicio.getListaClientes());

			} else {
				System.out.println("___________________________________________________________\n");
				System.out.println("Opción incorrecta. \nIngresará nuevamente al sistema");
				System.out.println("___________________________________________________________\n");
			}
		}
	}

	public void iniciarMenu() {
		int seleccion = 0;
		System.out.println("___________________________________________________________\n");
		System.out.println(" 	 Control de Clientes - Pastelería Bon Bon Jovi  ");
		System.out.println("___________________________________________________________\n");
		System.out.println("                     Menú Principal           ");
		System.out.println("___________________________________________________________\n");

		try {
			do {

				System.out.println("1. Listar Clientes:\n" + "2. Agregar Cliente:\n" + "3. Editar Cliente:\n"
						+ "4. Cargar Datos:\n" + "5. Exportar Datos:\n" + "6. Salir\n");

				Utilidad.mensajeIngreseOpcion();
				seleccion = sc.nextInt();
				sc.nextLine();

				switch (seleccion) {
				case 1:
					listarClientes();
					Utilidad.tiempoEspera();
					break;
				case 2:
					agregarCliente();
					Utilidad.tiempoEspera();
					break;
				case 3:
					editarCliente();
					Utilidad.tiempoEspera();
					break;
				case 4:
					cargarDatos();
					Utilidad.tiempoEspera();
					break;
				case 5:
					exportarDatos();
					Utilidad.tiempoEspera();
					break;
				case 6:
					Utilidad.mensajeTerminarPrograma();// Salir
					break;
				default:
					Utilidad.mensajeIngresarNuevamente();
					break;
				}
			} while (seleccion >= 1 && seleccion <= 5);
		} catch (InputMismatchException ime) {
			Utilidad.mensajeIngresarNuevamente();
		}
	}

}
