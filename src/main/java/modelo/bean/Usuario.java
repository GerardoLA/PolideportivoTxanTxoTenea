package modelo.bean;

public class Usuario {
	
	private String id_usuario;
	private String nombre;
	private String contrasena;
	
	public Usuario() {
		super();
	}
	public Usuario(String id_usuario, String nombre, String contrasena) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}
	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public boolean comprobarContraseña() {
		boolean apto=false;
		if(this.contrasena.length()<8) {
			apto=false;
		}
		
		for (char c: this.contrasena.toCharArray()) {
			if (Character.isDigit(c)) {
				apto=true;
			}
		}
		return apto;
	}
	
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", contrasena=" + contrasena + "]";
	}
	
	

}
