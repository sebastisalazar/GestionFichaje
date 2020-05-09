package conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CargaListaConexion {

	static ArrayList<Conexion> getLista() {
		ArrayList<Conexion> listaDeConexiones = new ArrayList<Conexion>();
		try {
			BufferedReader br;
			File f = new File("tiemposConexion.csv");
			FileReader fr = new FileReader(f.getAbsolutePath());
			br = new BufferedReader(fr);
			
			String linea;
			br.readLine();//lee la primer linea pero no la guarda ya que es el encabezado

			//se verifica si la linea que se lee al momento es null o no
			while ((linea=br.readLine())!= null) {

				Conexion c = new Conexion();
				//Quita todas las comas de la linea y las parte por palabras guardandolas en un array
				String[] datos = linea.split(",");
				//Del array de datos obtiene el nombre y le quita la primera comilla "
				String nombre=datos[0].replace("\"","");
				/**
				 * Del nombre solo queremos el primero (si existiesen dos) asi que se le dice que corte el nombre 
				 * diciencole que empiece desde la letra 0(index del string) hasta el primer espacio
				 */
				nombre=nombre.substring(0,nombre.indexOf(" "));
				
				//se le asigna el nombre obtenido al objeto
				c.setNombreAlumno(nombre);
				
				/**
				 * Se borra la coma que contiene al final
				 */
				String minutos = datos[4].replace("\"", "");
				/**
				 * El String contiene letras por ejemplo "180 minutos"
				 * pero queremos que solo 180 para poder parsearlo
				 * para ello cortamos el string desde la letra 0(index String) hasta el primer espacio
				 */
				minutos = minutos.substring(0, minutos.indexOf(" "));
				
				//se le asigna los minutos obtenido al objeto
				c.setHorasConexion(Integer.parseInt(minutos));
				
				//se guarda el objeto en el arraylist de objetos
				listaDeConexiones.add(c);
			}
			
			br.close();//cierra buffer
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDeConexiones;//devuelve la lista
	}
}
