package modelo.bean;

import java.util.Date;

public class Alquiler {
	
	Cliente cliente;
	Sala sala;
	private Date fecha;
	private String hora;
	
	public Alquiler() {
		
	}

	public Alquiler(Cliente cliente, Sala sala, Date fecha, String hora) {
		this.cliente = cliente;
		this.sala = sala;
		this.fecha = fecha;
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		return "Alquiler [cliente=" + cliente + ", sala=" + sala + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	

	
	

}
