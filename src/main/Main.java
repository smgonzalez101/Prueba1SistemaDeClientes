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
 * [x] Creaci�n (Main, Cliente y CategoriaEnum)
 * [X] Creaci�n de MenuTemple
 * [X] Creaci�n de Menu
 * [X] Creaci�n de Utilidad
 * [X] Creaci�n de ClienteServicio 
 * [X] Creaci�n de ArchivoServicio
 * [X] Creaci�n de Exportador, ExportadorCsv, ExportadorTxt, Importador
 * [X] Creaci�n de ClienteServicioTest
 */

public class Main {

	public static void main(String[] args) {

		MenuTemplate menu = new Menu();
		menu.iniciarMenu();
	}

}
