package modelo.bean;

import java.util.Date;

public class Incidencia {
	
	Material material;
	Empleado empleado;
	private Date fecha;
	private String incidencia;
	
	public Incidencia() {
		super();
	}

	public Incidencia(Material material, Empleado empleado, Date fecha, String incidencia) {
		super();
		this.material = material;
		this.empleado = empleado;
		this.fecha = fecha;
		this.incidencia = incidencia;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	@Override
	public String toString() {
		return "Incidencia [material=" + material + ", empleado=" + empleado + ", fecha=" + fecha + ", incidencia="
				+ incidencia + "]";
	}
	
	

	
	
	

}
