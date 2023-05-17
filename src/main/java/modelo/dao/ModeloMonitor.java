package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Empleado;
import modelo.bean.Grupo;
import modelo.bean.Imparten;
import modelo.bean.Trabajo;
import modelo.bean.Usuario;

public class ModeloMonitor extends Conector{
PreparedStatement pst;	

//ACTIVIDADES
	/**
	 * Inserta una actividad en la base de datos.
	 * @param actividad
	 * @return Variable confirmando la insercion.
	 * @throws ClassNotFoundException
	 */
	public boolean insertarActividad(Actividad actividad) throws ClassNotFoundException {
		try {
			conectar();

	
			pst = getCon().prepareStatement("INSERT INTO  actividades VALUES (?,?,?)");
			pst.setString(1, actividad.getId_actividad());
			pst.setString(2, actividad.getNombreActividad());
			pst.setDouble(3, actividad.getPrecio());
	
	
			pst.execute();
			getCon().close();
			return true;
	
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
/**
 * Elimina actividad segun la id de actividad.
 * @param id_actividad
 * @return variable de confirmacion o no de eliminacion realizada.
 * @throws ClassNotFoundException
 */
	public boolean eliminarActividad(String id_actividad) throws ClassNotFoundException {
		try {
			conectar();
		
			pst = getCon().prepareStatement("DELETE FROM inscripciones WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			pst.execute();
			
			pst = getCon().prepareStatement("SELECT id_grupo FROM imparten WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			
			ResultSet result = pst.executeQuery();
			result.next();
			String id_grupo= result.getString("id_grupo");
			
			eliminargrupo(id_grupo);
			
			pst = getCon().prepareStatement("DELETE FROM imparten WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			pst.execute();
			
			pst = getCon().prepareStatement("DELETE FROM actividades WHERE id=?");
			pst.setString(1, id_actividad);
			pst.execute();
			
			
			
			getCon().close();
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
/**
 * Modifica actividad segun la id dada.
 * @param actividad
 * @return Devuelve variable de conformacion  de modicicaion realizada o no.
 * @throws ClassNotFoundException
 */
	public boolean modificarActividad(Actividad actividad) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("UPDATE actividades SET Nombreac=?,precio=? WHERE id=?");
			pst.setString(1, actividad.getNombreActividad());
			pst.setDouble(2, actividad.getPrecio());
			pst.setString(3, actividad.getId_actividad());
		
		
			pst.execute();
			getCon().close();
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Selecciona lista de actividades impartidas segun la id de la actividad  y la id del empleado.
	 * @param id_actividad
	 * @param id_empleado
	 * @return lista de actividades
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Imparten>getActividades(String id_actividad,int id_empleado) throws ClassNotFoundException{
		ArrayList<Imparten> actividades = new ArrayList<>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT * FROM imparten WHERE id_empleado=? AND id_actividad=?");
			pst.setInt(1, id_empleado);
			pst.setString(2, id_actividad);
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Imparten imparten = new Imparten();
				
				imparten.setEmpleado(getEmpleado(resultado.getInt("id_empleado")));
				imparten.setActividad(getActividad(resultado.getString("id_actividad")));
				imparten.setGrupo(getGrupo(resultado.getString("id_grupo")));
				
				actividades.add(imparten);
			}

			getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return actividades;	
	}
	
	/**
	 * 
	 * @param id_empleado
	 * @return Devuelve una lista de las actividades que son impartidas por el usuario logineado
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Imparten>getActividades(int id_empleado) throws ClassNotFoundException{
		ArrayList<Imparten> actividades = new ArrayList<>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT * FROM imparten WHERE id_empleado=?");
			pst.setInt(1, id_empleado);
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Imparten imparten = new Imparten();
				
				imparten.setEmpleado(getEmpleado(resultado.getInt("id_empleado")));
				imparten.setActividad(getActividad(resultado.getString("id_actividad")));
				imparten.setGrupo(getGrupo(resultado.getString("id_grupo")));
				
				actividades.add(imparten);
			}

			getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return actividades;	
	}
	
	/**
	 * Selecciona actividad segun la id de actividad.
	 * @param id_actividad
	 * @return actividad
	 * @throws ClassNotFoundException
	 */
	public Actividad getActividad(String id_actividad) throws ClassNotFoundException{
		Actividad actividad=null;
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM actividades WHERE id=?");
			pst.setString(1, id_actividad);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			actividad = new Actividad(resultado.getString("id"),resultado.getString("Nombreac"),resultado.getDouble("precio"));
			getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return actividad;	
	}
	/**
	 * Selecciona lista de actividades segun la id del empleado.
	 * @param id_empleado
	 * @return lista de actividades.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Actividad> getActividade(int id_empleado) throws ClassNotFoundException{
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT id_actividad FROM imparten WHERE id_empleado=?");
			pst.setInt(1, id_empleado);
			ResultSet resultado = pst.executeQuery();			
			
			while(resultado.next()) {
				PreparedStatement pt = getCon().prepareStatement("SELECT * FROM actividades WHERE id=?");
				pt.setString(1, resultado.getString("id_actividad"));
				ResultSet result = pt.executeQuery();
				
				result.next();
				
				Actividad actividad= new Actividad();
				
				actividad.setId(result.getString("id"));
				actividad.setNombreActividad(result.getString("nombreac"));
				actividad.setPrecio(result.getDouble("precio"));
				
				actividades.add(actividad);
			}

			getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return actividades;
	}


	//FIN ACTIVIDADES
	
	//GRUPOS
	/**
	 * inserta un grupo en la tabla imparten
	 * @param grupo
	 * @param id_actividad
	 * @param id_empleado
	 * @return variable de confirmacion de insercion realizada.
	 * @throws ClassNotFoundException
	 */
	public boolean insertarGrupo(Grupo grupo, String id_actividad, int id_empleado) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("INSERT INTO grupos VALUES (?,?,?,?,?)");
			pst.setString(1, grupo.getId_grupo());
			pst.setString(2, grupo.getDias());
			pst.setString(3, grupo.getHorarios());
			pst.setInt(4, grupo.getMaxPartic());
			pst.setInt(5, grupo.getNumPartic());
		
			
			pst.execute();
			getCon().close();
			
			Imparten imparten = new Imparten(getEmpleado(id_empleado), getActividad(id_actividad), grupo);
			
			insertarCruso(imparten);
			
			
			return true;
		
		} catch (SQLException e) {
			// TODO 	Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	/**
	 * insertar grupo  en la base de datos
	 * @param grupo
	 * @return variable de confirmacion de insercion realizada.
	 * @throws ClassNotFoundException
	 */
	public boolean insertarGrupo(Grupo grupo) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("INSERT INTO grupos VALUES (?,?,?,?,?)");
			pst.setString(1, grupo.getId_grupo());
			pst.setString(2, grupo.getDias());
			pst.setString(3, grupo.getHorarios());
			pst.setInt(4, grupo.getMaxPartic());
			pst.setInt(5, grupo.getNumPartic());
		
			
			pst.execute();
			getCon().close();
			
			
			return true;
		
		} catch (SQLException e) {
			// TODO 	Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
/**
 * Eliminar grupo segun la id de grupo.
 * @param id_grupo
 * @return devuelve variable de confirmacion de eliminacion.
 * @throws ClassNotFoundException
 */
	public boolean eliminargrupo(String id_grupo) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("DELETE FROM imparten WHERE id_grupo=?");
			pst.setString(1, id_grupo);
			pst.execute();
		
			pst = getCon().prepareStatement("DELETE FROM inscripciones WHERE id_grupo=?");
			pst.setString(1, id_grupo);
			pst.execute();
		
			pst = getCon().prepareStatement("DELETE FROM grupos WHERE id=?");
			pst.setString(1, id_grupo);
			pst.execute();
		
		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
/**
 * Modifica grupo segun id de grupo dada.
 * @param grupo
 * @return devuelve variable de confirmacion de modificacion.
 * @throws ClassNotFoundException
 */
	public boolean modificarGrupo(Grupo grupo) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("UPDATE grupos SET  dias=?, horarios=?, maxpartic=?,numpartic=? where id=?");
			pst.setString(1, grupo.getDias());
			pst.setString(2, grupo.getHorarios());
			pst.setInt(3, grupo.getMaxPartic());
			pst.setInt(4, grupo.getNumPartic());
			pst.setString(5, grupo.getId_grupo());
		
		
			pst.execute();
			getCon().close();
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	/**
	 * Selecciona lista de grupos segun la id de empleado.
	 * @param id_empleado
	 * @return lista de grupos.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Grupo>getGrupos(int id_empleado) throws ClassNotFoundException{
		ArrayList<Grupo>grupos = new ArrayList<>();
	
		try {
			conectar();

			pst = getCon().prepareStatement("Select id_grupo FROM imparten WHERE id_empleado=?");
			pst.setInt(1, id_empleado);
		
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				PreparedStatement pt = getCon().prepareStatement("SELECT* FROM grupos WHERE id_grupo=?");
				pt.setString(1, resultado.getString("id_grupo"));
				ResultSet rs = pt.executeQuery();
				rs.next();
				
				Grupo grupo = new Grupo();
				grupo.setId_grupo(rs.getString("id_grupo"));
				grupo.setDias(rs.getString("dias"));
				grupo.setHorarios(rs.getString("horarios"));
				
				grupos.add(grupo);
				
				
				}
				getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return grupos;
	}
	
	
	/**
	 * Selecciona grupo segun id dada.
	 * @param id_grupo
	 * @return grupo.
	 * @throws ClassNotFoundException
	 */
	public Grupo getGrupo(String id_grupo) throws ClassNotFoundException{
		Grupo grupo = new Grupo();
	
		try {
			conectar();

			pst = getCon().prepareStatement("Select * FROM grupos WHERE id=?");
			pst.setString(1, id_grupo);
		
			
			ResultSet resultado = pst.executeQuery();
			resultado.next() ;
							
			grupo.setId_grupo(resultado.getString("id"));
			grupo.setDias(resultado.getString("dias"));
			grupo.setHorarios(resultado.getString("horarios"));
			grupo.setMaxPartic(resultado.getInt("maxPartic"));
			grupo.setNumPartic(resultado.getInt("numPartic"));
				
			getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return grupo;
	}
	
	//FIN GRUPOS
	
	//INSERTAR
	/**
	 * inserta curso impartido en base de datos.
	 * @param imparten
	 * @return devuelve variable de confirmacion de insercion.
	 */
	public boolean insertarCruso(Imparten imparten)  {
		try {
			conectar();
			pst=getCon().prepareStatement("INSERT INTO imparten VALUES(?,?,?)");
			
			pst.setInt(1, imparten.getEmpleado().getId_empleado());
			pst.setString(2, imparten.getActividad().getId_actividad());
			pst.setString(3, imparten.getGrupo().getId_grupo());
			
			pst.execute();
			getCon().close();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
//FIN INSERTAR
	
	
	
//EMPLEADOS
	/**
	 * Slecciona empleado segun la id dada.
	 * @param id_empleado
	 * @return Empleado.
	 * @throws ClassNotFoundException
	 */
	public Empleado getEmpleado(int id_empleado) throws ClassNotFoundException {
		Empleado empleado = new Empleado();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT * FROM empleados where id=?");
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
			empleado.setUsuario(getUsuario(resultado.getString("id_usuario")));
			empleado.setTrabajo(getTrabajo(resultado.getInt("id_trabajo")));
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return empleado;
	}
	//FIN EMPLEADOS
	
	//USUARIOS
	/**
	 * Selecciona usuario segun la id dada.
	 * @param id_usuario
	 * @return Usuario.
	 * @throws ClassNotFoundException
	 */
	public Usuario getUsuario(String id_usuario) throws ClassNotFoundException {
		Usuario usuario = new Usuario();
		 try {
			 conectar();
			 
			pst = getCon().prepareStatement("SELECT* from usuarios where id=?");
			pst.setString(1, id_usuario);
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			usuario.setId_usuario(resultado.getString("id"));
			usuario.setNombre(resultado.getString("nombre"));
			usuario.setContrasena(resultado.getString("contrasena"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
	}
	//FIN USUARIOS
	
	
	//TRABAJOS
	/**
	 * Selecciona trabajo segun la id dada.
	 * @param id_trabajo
	 * @return Trabajo.
	 * @throws ClassNotFoundException
	 */
	public Trabajo getTrabajo(int id_trabajo) throws ClassNotFoundException {
		Trabajo trabajo = new Trabajo();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT* FROM  trabajos where id =?");
			pst.setInt(1, id_trabajo);
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return trabajo;	
	}
}
//FIN TRABAJOS