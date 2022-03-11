package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {

	List<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio() {
		super();

	}

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = new ArrayList<Cliente>(listaClientes);
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void retornolistarClientes() {
		int validarExiste = 0;
		for (Cliente clienteTemp : listaClientes) {

			System.out.println("----------------Datos del Cliente--------------------\n");
			System.out.println("RUN del Cliente: " + clienteTemp.getRunCliente());
			System.out.println("Nombre del Cliente: " + clienteTemp.getNombreCliente());
			System.out.println("Apellido del Cliente: " + clienteTemp.getApellidoCliente());
			System.out.println("Años como Cliente: " + clienteTemp.getAniosCliente());
			System.out.println("Categoría del Cliente: " + clienteTemp.getNombreCategoria());
			System.out.println("______________________________________________________\n");
			validarExiste = 1;
		}
		if (validarExiste != 1) {
			System.out.println("No existen datos, ingresar o cargar datos.");
		}
	}

	public List<Cliente> agregarCliente(String runCliente, String nombreCliente, String apellidoCliente,
			String aniosCliente, CategoriaEnum nombreCategoria) {

		Cliente clienteIngresado = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente,
				CategoriaEnum.ACTIVO);

		listaClientes.add(clienteIngresado);
		return listaClientes;

	}

	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {// Método sobreescribe Menú.

	}

}
