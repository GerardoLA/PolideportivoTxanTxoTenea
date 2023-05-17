package modelo.bean;

public class Proveedor {

	private String id_proveedor;
	private String nombre;
	private String apellido;
	private String tfno;
	private String mail;
	
	public Proveedor() {
		super();
	}

	public Proveedor(String id_proveedor, String nombre, String apellido, String tfno, String mail) {
		super();
		this.id_proveedor = id_proveedor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tfno = tfno;
		this.mail = mail;
	}

	public String getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(String id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Proveedor [id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", apellido=" + apellido + ", tfno="
				+ tfno + ", mail=" + mail + "]";
	}
	
	
	
}
