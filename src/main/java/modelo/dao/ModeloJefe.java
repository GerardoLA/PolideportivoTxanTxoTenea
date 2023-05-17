package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Date;

import modelo.Conector;
import modelo.bean.Empleado;
import modelo.bean.Trabajo;
import modelo.bean.Usuario;

public class ModeloJefe extends Conector{	
	PreparedStatement pst;
	
	// EMPLEADOS
	/**
	 * inserta empleado en la base de datos
	 * @param empleado
	 * @return devuelve variable de confirmacion de insercion
	 * @throws ClassNotFoundException
	 */
	public boolean altaEmpleado(Empleado empleado) throws ClassNotFoundException {
		try {
			conectar();
			pst = getCon().prepareStatement("INSERT INTO empleados (nombre, apellido, dni, edad, antiguedad, id_jefe, id_usuario, id_trabajo)VALUES(?,?,?,?,CURRENT_DATE,?,?,?)");
			pst.setString(1, empleado.getNombre());
			pst.setString(2, empleado.getApellido());
			pst.setString(3, empleado.getDni());
			pst.setInt(4, empleado.getEdad());
			pst.setInt(5, empleado.getId_jefe());
			pst.setString(6, empleado.getUsuario().getId_usuario());
			pst.setInt(7, empleado.getTrabajo().getId_trabajo());
			
			
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return false;
		}		
}
	
	/**
	 * elimina empleado  de la base de datos segun el id dado
	 * @param id_empleado
	 * @return devuelve variable de confirmacion de eliminacion.
	 * @throws ClassNotFoundException
	 */
	public boolean bajaempleado(int id_empleado) throws ClassNotFoundException {
		try {
			conectar();			
			pst = getCon().prepareStatement("DELETE FROM imparten where id_empleado=?");
			pst.setInt(1, id_empleado);
			pst.execute();
			
			
			pst = getCon().prepareStatement("DELETE FROM empleados where id=?");
			pst.setInt(1, id_empleado);
			pst.execute();
			
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return false;
		}
		
	}
	
	/**
	 * Modifica datos de empleado segun la id dada
	 * @param empleado
	 * @return devuelve variable de confirmacion de modificacion
	 * @throws ClassNotFoundException
	 */
	public boolean modificarDatosEmpleado(Empleado empleado) throws ClassNotFoundException {
		try {
			conectar();
			pst = getCon().prepareStatement("UPDATE empleados SET nombre=?,apellido=?, dni=?,edad=?, antiguedad=?, id_jefe=?, id_usuario=?,id_trabajo=? where id=?");
			pst.setString(1, empleado.getNombre());
			pst.setString(2, empleado.getApellido());
			pst.setString(3, empleado.getDni());
			pst.setInt(4, empleado.getEdad());
			pst.setDate(5, new Date(empleado.getAntiguedad().getTime()));
			pst.setInt(6, empleado.getId_jefe());
			pst.setString(7, empleado .getUsuario().getId_usuario());
			pst.setInt(8, empleado.getTrabajo().getId_trabajo());
			pst.setInt(9, empleado.getId_empleado());
			
			
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return false;
		}	
	}
	
	/**
	 * selecciona empleado segun el dni dado
	 * @param dni
	 * @return empleado
	 * @throws ClassNotFoundException
	 */
	public Empleado getEmpleado(String dni) throws ClassNotFoundException {
		Empleado empleado = new Empleado();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* from empleados where dni=?");
			pst.setString(1, dni);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			empleado.setId_empleado(resultado.getInt("id_empleado"));
			empleado.setNombre(resultado.getString("nombre"));
			empleado.setApellido(resultado.getString("apellido"));
			empleado.setDni(resultado.getString("dni"));
			empleado.setEdad(resultado.getInt("edad"));
			empleado.setAntiguedad(resultado.getDate("antiguedad"));
			empleado.setId_jefe(resultado.getInt("id_jefe"));
			empleado.setUsuario(getUsuario(resultado.getString("id_usuario")));
			empleado.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
			
		return empleado;
	}
	
	/**
	 * selecciona empleado segun la id dada
	 * @param id_empleado
	 * @return empleado
	 * @throws ClassNotFoundException
	 */
	public Empleado getEmpleado(int id_empleado) throws ClassNotFoundException {
		Empleado empleado = new Empleado();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* from empleados WHERE id=?");
			pst.setInt(1, id_empleado);
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			empleado.setId_empleado(resultado.getInt("id"));
			empleado.setNombre(resultado.getString("nombre"));
			empleado.setApellido(resultado.getString("apellido"));
			empleado.setDni(resultado.getString("dni"));
			empleado.setEdad(resultado.getInt("edad"));
			empleado.setAntiguedad(resultado.getDate("antiguedad"));
			empleado.setId_jefe(resultado.getInt("id_jefe"));
			empleado.setUsuario(getUsuarioPorId(resultado.getString("id_usuario")));
			empleado.setTrabajo(getTrabajo(resultado.getInt("id_trabajo"))); 
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return empleado;
	}
	
	/**
	 *seleciona lista de empleados desde la base de datos 
	 * @return lista de empleados
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Empleado> getEmpleados() throws ClassNotFoundException{
		ArrayList<Empleado>empleados= new ArrayList<>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT * FROM empleados");
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Empleado empleado = new Empleado();
				empleado.setId_empleado(resultado.getInt("id"));
				empleado.setNombre(resultado.getString("nombre"));
				empleado.setApellido(resultado.getString("apellido"));
				empleado.setDni(resultado.getString("dni"));
				empleado.setEdad(resultado.getInt("edad"));
				empleado.setAntiguedad(resultado.getDate("antiguedad"));
				empleado.setId_jefe(resultado.getInt("id_jefe"));
				empleado.setUsuario(getUsuarioPorId(resultado.getString("id_usuario")));
				empleado.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
				 
				empleados.add(empleado);
			}
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return empleados;
	}
	
	//FIN EMPLEADOS
	
	//USUARIOS
	
	/**
	 * inserta usuario en la base de datos
	 * @param usuario
	 * @return devuelve variable de confirmacion de insercion
	 * @throws ClassNotFoundException
	 */
	public boolean AltaUsuario(Usuario usuario) throws ClassNotFoundException {
		try {
			conectar();
			pst = getCon().prepareStatement("INSERT INTO usuarios (id,nombre,contrasena) VALUES  (?,?,?)");
			pst.setString(1, usuario.getId_usuario());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getContrasena());
			
			
			pst.execute();
			getCon().close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return false;
	}
	
	/**
	 * Selecciona usuario segun el nombre dado
	 * @param nombreUsuario
	 * @return usuario
	 * @throws ClassNotFoundException
	 */
	public Usuario getUsuario(String nombreUsuario) throws ClassNotFoundException {
		Usuario usuario = new Usuario();
		 try {
			 conectar();
			 
			pst = getCon().prepareStatement("SELECT* FROM usuarios WHERE nombre=?");
			pst.setString(1, nombreUsuario);
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			usuario.setId_usuario(resultado.getString("id"));
			usuario.setNombre(resultado.getString("nombre"));
			usuario.setContrasena(resultado.getString("contrasena"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return usuario;
	}
	
	/**
	 * selecciona usuario segun la id dada
	 * @param id_usuario
	 * @return usuario
	 * @throws ClassNotFoundException
	 */
	public Usuario getUsuarioPorId(String id_usuario) throws ClassNotFoundException {
		Usuario usuario = new Usuario();
		 try {
			 conectar();
			 
			pst = getCon().prepareStatement("SELECT* FROM usuarios WHERE id=?");
			pst.setString(1, id_usuario);
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			usuario.setId_usuario(resultado.getString("id"));
			usuario.setNombre(resultado.getString("nombre"));
			usuario.setContrasena(resultado.getString("contrasena"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return usuario;
	}
	

	 /**
	  * selecciona lista de usuarios 
	  * @return lista de usuarios
	  * @throws ClassNotFoundException
	  */
	public ArrayList<Usuario>getUsuarios() throws ClassNotFoundException{
		ArrayList<Usuario>usuarios = new ArrayList<>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT * FROM  usuarios");
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId_usuario(resultado.getString("id"));
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setContrasena(resultado.getString("contrasena"));
				
				usuarios.add(usuario);
				
			}
			getCon().close();
		} catch (SQLException e) {
		
			
		}
		
		return usuarios;
	}

	/**
	 * modifica los datos del usuario especificado por id
	 * @param usuario
	 * @return devuelve variable de confirmacion de modificacion.
	 */
	public boolean ModificarUsuario(Usuario usuario) {
		try {
			conectar();
			pst = getCon().prepareStatement("UPDATE usuarios SET nombre=?,contrasena=? where id=?");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getContrasena());
			pst.setString(3, usuario.getId_usuario());
			pst.execute();
			getCon().close();
			return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		return false;
	}
	
	/**
	 * selecciona lista de usuarios disponible(que no estan asignados a ningun empleado)
	 * @returnlista de usuarios
	 */
	public ArrayList<Usuario> getUsuariosParaform(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			conectar();
			pst= getCon().prepareStatement("SELECT * FROM usuarios WHERE id NOT IN(SELECT id_usuario FROM empleados)");
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId_usuario(result.getString("id"));
				usuario.setNombre(result.getString("nombre"));
				usuario.setContrasena(result.getString("contrasena"));
				
				usuarios.add(usuario);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return usuarios;
	}

	//FIN USUARIO
	
	//TRABAJOS
	
	/**
	 * selecciona trabajo segun la id dada
	 * @param id_trabajo
	 * @return trabajo
	 * @throws ClassNotFoundException
	 */
	public Trabajo getTrabajo(int id_trabajo) throws ClassNotFoundException {
		Trabajo trabajo = new Trabajo();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM  trabajos WHERE id =?");
			pst.setInt(1, id_trabajo);
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			trabajo.setId_trabajo(resultado.getInt("id"));
			trabajo.setNombre(resultado.getString("nombre"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return trabajo;	
	}
	 /**
	  * selecciona trabajo segun el nombre dado
	  * @param nombre_trabajo
	  * @return trabajo
	  * @throws ClassNotFoundException
	  */
	public Trabajo getTrabajo(String nombre_trabajo) throws ClassNotFoundException {
		Trabajo trabajo = new Trabajo();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM  trabajos where nombre=?");
			pst.setString(1, nombre_trabajo);
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			trabajo.setId_trabajo(resultado.getInt("id"));
			trabajo.setNombre(resultado.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return trabajo;	
	}

	/**
	 * selecciona lista de trabajos desde la baase de datos
	 * @return lista de trabajos
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Trabajo>getTrabajos () throws ClassNotFoundException{
		ArrayList<Trabajo>trabajos=new ArrayList<>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* from trabajos");
			ResultSet resultado =pst.executeQuery();
			while(resultado.next()) {
				Trabajo trabajo = new Trabajo();
				trabajo.setId_trabajo(resultado.getInt("id"));
				trabajo.setNombre(resultado.getString("nombre"));
				
				trabajos.add(trabajo);
			}
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return trabajos;
	}
	 /**
	  * inserta trabajo nuevo
	  * @param trabajo
	  * @return devuelve variable de confirmacion de insercion
	  * @throws ClassNotFoundException
	  */
	public boolean AltaTrabajo(Trabajo trabajo) throws ClassNotFoundException {
		try {
			conectar();
			pst= getCon().prepareStatement("INSERT INTO trabajos (nombre) VALUES (?)");
			pst.setString(1, trabajo.getNombre());
			pst.execute();
			cerrar();
			return true;
		} catch (SQLException e) {
			
			return false;
		}
	}
	
//FIN TRABAJOS
	
}
	

