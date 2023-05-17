package modelo.bean;

import java.util.Date;

public class Inscripcion {

	Cliente cliente;
	Actividad actividad;
	Grupo grupo;
	private Date fecha;
	
	public Inscripcion() {
		super();
	}

	public Inscripcion(Cliente cliente, Actividad actividad, Grupo grupo, Date fecha) {
		this.cliente = cliente;
		this.actividad = actividad;
		this.grupo = grupo;
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Inscripcion [cliente=" + cliente + ", actividad=" + actividad + ", grupo=" + grupo + ", fecha=" + fecha
				+ "]";
	}
	
	
	
	
}
