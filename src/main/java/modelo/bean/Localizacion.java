package modelo.bean;

import java.util.Date;

public class Localizacion {
	
	Actividad actividad;
	Sala sala;
	private Date fecha;
	private String hora;
	
	public Localizacion() {
		super();
	}

	public Localizacion(Actividad actividad, Sala sala, Date fecha, String hora) {
		super();
		this.actividad = actividad;
		this.sala = sala;
		this.fecha = fecha;
		this.hora = hora;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Localizacion [actividad=" + actividad + ", sala=" + sala + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
	

}
