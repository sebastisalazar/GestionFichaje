package conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Gestion {

	static ArrayList<Conexion> listadoConDuplicados= new ArrayList<Conexion>();
	static HashMap<String, Integer> listadoSinDuplicados = new HashMap<String, Integer>();

	public static void main(String[] args) {

		listadoConDuplicados = CargaLista.getLista();
		System.out.println("\n*************************");
		System.out.println("\n\tLISTA CON DUPLICADOS\n");
		imprimirLista();
		System.out.println("\n*************************");
		System.out.println("\n\tLISTA SIN DUPLICADOS\n");
		duplicados();
		
	}

	static void imprimirLista() {
		for (Conexion conexion : listadoConDuplicados) {
			System.out.println(conexion);
		}
	}

	static void duplicados() {

		for (Conexion conexion : listadoConDuplicados) {// bucle para leer el listadoConDuplicados

			// si en listadoSinDuplicados NO existe el nombre del objeto de la listaConDuplicados se inserta como nuevo
			if (listadoSinDuplicados.get(conexion.getNombreAlumno()) == null) {
				
				listadoSinDuplicados.put(conexion.getNombreAlumno(), conexion.getHorasConexion());
				
			} else {//si ya existe suma los minutos
				
				int minutos = conexion.getHorasConexion();
				int key = listadoSinDuplicados.get(conexion.getNombreAlumno());
				listadoSinDuplicados.put(conexion.getNombreAlumno(), key + conexion.getHorasConexion());
			}

		}

		// IMPRIMIR el listado SIN DUPLICADOS

		for (String i : listadoSinDuplicados.keySet()) {
			System.out.println("Nombre: " + i + ", Tiempo de conexion: " + listadoSinDuplicados.get(i) + " minutos");
		}

	}

}
