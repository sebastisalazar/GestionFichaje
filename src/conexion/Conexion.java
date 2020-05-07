package conexion;

public class Conexion {

	private String nombreAlumno;
	private int horasConexion;

	public Conexion() {
		super();
		this.nombreAlumno = "";
		this.horasConexion = 0;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public int getHorasConexion() {
		return horasConexion;
	}

	public void setHorasConexion(int horasConexion) {
		this.horasConexion = horasConexion;
	}

	@Override
	public String toString() {
		return "Conexion [nombreAlumno=" + nombreAlumno + ", horasConexion=" + horasConexion +" minutos"+ "]";
	}

}
