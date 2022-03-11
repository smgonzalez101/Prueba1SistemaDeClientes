package main;

import vista.Menu;
import vista.MenuTemplate;

/*
 * [x] Crear 6 paquetes main, modelo, servicio, test, utilidades, vista.
 * [x] clases en main - Main
 * [x] clases en modelo - CategoriaEnum -Cliente
 * [x] Clases en servicio - ArchivoServicio, ClienteServicio, Esportador, ExportadorCsv, ExportadorTXt, importador
 * [x] Clases en test -ClienteServicioTest
 * [x] Clases en utilidades - Utilidad
 * [x] Clases en vista - Menu, MenuTemplate
 * 
 * [x] Creación (Main, Cliente y CategoriaEnum)
 * [X] Creación de MenuTemple
 * [X] Creación de Menu
 * [X] Creación de Utilidad
 * [X] Creación de ClienteServicio 
 * [X] Creación de ArchivoServicio
 * [X] Creación de Exportador, ExportadorCsv, ExportadorTxt, Importador
 * [X] Creación de ClienteServicioTest
 */

public class Main {

	public static void main(String[] args) {

		MenuTemplate menu = new Menu();
		menu.iniciarMenu();
	}

}
