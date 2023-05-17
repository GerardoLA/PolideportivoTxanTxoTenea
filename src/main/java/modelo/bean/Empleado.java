package modelo.bean;

import java.util.Date;

public class Empleado {
	private int id_empleado;
	private String nombre;
	private String apellido;
	private String dni;
	private int edad;
	private Date antiguedad;
	private int id_jefe;
	Usuario usuario;
	Trabajo trabajo;
	
	
	public Empleado() {
		super();
	}


	public Empleado(int id_empleado, String nombre, String apellido, String dni, int edad, Date antiguedad,
			int id_jefe, Usuario usuario, Trabajo trabajo) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.antiguedad = antiguedad;
		this.id_jefe = id_jefe;
		this.usuario = usuario;
		this.trabajo = trabajo;
	}


	public int getId_empleado() {
		return id_empleado;
	}


	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public Date getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}


	public int getId_jefe() {
		return id_jefe;
	}


	public void setId_jefe(int id_jefe) {
		this.id_jefe = id_jefe;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Trabajo getTrabajo() {
		return trabajo;
	}


	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}


	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", edad=" + edad + ", antiguedad=" + antiguedad + ", id_jefe=" + id_jefe + ", usuario=" + usuario
				+ ", trabajo=" + trabajo + "]";
	}

	
	

}

