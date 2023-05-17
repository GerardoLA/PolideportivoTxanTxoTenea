package modelo.bean;

public class Imparten {
	
	Empleado empleado;
	Actividad actividad;
	Grupo grupo;
	
	public Imparten() {
		super();
	}

	public Imparten(Empleado empleado, Actividad actividad, Grupo grupo) {
		super();
		this.empleado = empleado;
		this.actividad = actividad;
		this.grupo = grupo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Imparten [empleado=" + empleado + ", actividad=" + actividad + ", grupo=" + grupo + "]";
	}
	
	

	
	
	

}
