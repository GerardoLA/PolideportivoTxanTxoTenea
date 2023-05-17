package modelo.bean;

public class Trabajo {
	
	private int id_trabajo;
	private String nombre;
	
	
	
	public Trabajo() {
		super();
	}

	public Trabajo(int id_trabajo, String nombre) {
		super();
		this.id_trabajo = id_trabajo;
		this.nombre = nombre;
	}

	public int getId_trabajo() {
		return id_trabajo;
	}

	public void setId_trabajo(int id_trabajo) {
		this.id_trabajo = id_trabajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Trabajo [id_trabajo=" + id_trabajo + ", nombre=" + nombre + "]";
	}
	
	
	
	

}
