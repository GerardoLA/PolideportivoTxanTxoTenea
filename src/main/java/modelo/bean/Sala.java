package modelo.bean;

public class Sala {
	
	private int id_sala;
	private String codigo;
	
	public Sala() {
		super();
	}
	
	public Sala(int id_sala, String codigo) {
		super();
		this.id_sala = id_sala;
		this.codigo = codigo;
	}
	
	public int getId_sala() {
		return id_sala;
	}
	public void setId_sala(int id_sala) {
		this.id_sala = id_sala;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "Sala [id_sala=" + id_sala + ", codigo=" + codigo + "]";
	}
	
	

}
