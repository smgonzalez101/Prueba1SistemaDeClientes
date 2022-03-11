package utilidades;

public class Utilidad {

	// Método limpieza pantalla
	public static void limpiezaPantalla() {
		for (int i = 0; i <= 20; i++) {
			System.out.println("\n");// Salta lineas para limpiar la pantalla.
		}
		System.out.flush();

	}

	// Método tiempo de espera
	public static void tiempoEspera() {
		try {
			Thread.sleep(3000);// detiene la ejecución del proceso
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

//método mensaje
	public static void printLine(String mensaje) {
		System.out.println(mensaje);
	}

	public static void mensajeTerminarPrograma() {
		System.out.println("___________________________________________________________\n");
		System.out.println("               Salió del sistema");
		System.out.println("___________________________________________________________\n");
		Utilidad.tiempoEspera();
		Utilidad.limpiezaPantalla();
		System.exit(0);
	}

	public static void mensajeIngreseOpcion() {
		System.out.println("___________________________________________________________\n");
		System.out.println("Ingrese opción: ");
		System.out.println("___________________________________________________________");

	}

	public static void mensajeIngresarNuevamente() {
		System.out.println("___________________________________________________________");
		System.out.println("         Error, ingrese nuevamente al sistema.");
		System.out.println("         Ingrese solo las opciones solicitadas.");
		System.out.println("___________________________________________________________");
		tiempoEspera();
		limpiezaPantalla();
	}

}
