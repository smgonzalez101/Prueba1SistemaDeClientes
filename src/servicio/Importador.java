package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class Importador {
	
	public abstract void cargarDatos(String fileName1, List<Cliente> listaClientes);

	}
