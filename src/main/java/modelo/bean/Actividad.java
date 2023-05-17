package modelo.bean;

public class Actividad {
	
	private String id_actividad;
	private String nombreActividad;

	private double precio;
	
	
	public Actividad() {
		super();
	}
	
	public Actividad(String id_actividad, String nombreActividad, double precio) {
		super();
		this.id_actividad = id_actividad;
		this.nombreActividad = nombreActividad;
		this.precio = precio;
		
	}
	
	public String getId_actividad() {
		return id_actividad;
	}
	public void setId(String id_actividad) {
		this.id_actividad = id_actividad;
	}
	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	

	@Override
	public String toString() {
		return "Actividad [id_actividad=" + id_actividad + ", nombreActividad=" + nombreActividad  + ", precio=" + precio + "]";
	}
	
	
	
	

}
