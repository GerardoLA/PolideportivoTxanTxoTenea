package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Alquiler;
import modelo.bean.Cliente;
import modelo.bean.Grupo;
import modelo.bean.Inscripcion;
import modelo.bean.Sala;

public class ModeloRecepcion extends Conector{
	
	PreparedStatement pst;
	
	//CLIENTE
	/**
	 * inserta un cliente en la base de datos.
	 * @param cliente
	 * @return Devuelve variable confirmando si se ha realizado la insercion o no.
	 * @throws ClassNotFoundException
	 */
	public boolean crearCliente(Cliente cliente) throws ClassNotFoundException {
		
		try {
			conectar();

			pst = getCon().prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?,CURRENT_DATE)");
			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getNombre());
			pst.setString(3, cliente.getApellido());
			pst.setString(4, cliente.getTelefono());
			pst.setString(5, cliente.getMail());
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
	 * Elimina cliente segun el dni.
	 * @param dni
	 * @return Variable de si se ha realizado la eliminación.
	 * @throws ClassNotFoundException
	 */
	public boolean eliminarCliente(String dni) throws ClassNotFoundException {
		try {
			conectar();
			
			
			
			pst = getCon().prepareStatement("DELETE FROM alquiler where dni_cliente=?");
			pst.setString(1, dni);
			pst.execute();
			
			pst = getCon().prepareStatement("DELETE FROM inscripciones where dni_cliente=?");
			pst.setString(1, dni);
			pst.execute();
			
			pst = getCon().prepareStatement("DELETE FROM clientes where dni=?");
			pst.setString(1, dni);
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
	 * Modifica el cliente segun el dni indicado.
	 * @param cliente
	 * @return Variable 
	 * @throws ClassNotFoundException
	 */
	public boolean modificarCliente(Cliente cliente) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("UPDATE clientes SET nombre=?,apellido=?,telefono=?,mail=?, antiguedad=? where dni=?");
			
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getApellido());
			pst.setString(3, cliente.getTelefono());
			pst.setString(4, cliente.getMail());
			pst.setDate(5, new Date(cliente.getAntiguedad().getTime()));
			pst.setString(6, cliente.getDni());
			
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
	 * Selecciona cliente segun el dni dado.
	 * @param dni
	 * @return cliente.
	 * @throws ClassNotFoundException
	 */
	public Cliente getCliente(String dni) throws ClassNotFoundException {
		Cliente cliente = new Cliente();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM clientes WHERE dni=?");
			pst.setString(1, dni);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			
			cliente.setDni(resultado.getString("dni"));
			cliente.setNombre(resultado.getString("nombre"));
			cliente.setApellido(resultado.getString("apellido"));
			cliente.setTelefono(resultado.getString("telefono"));
			cliente.setMail(resultado.getString("mail"));
			cliente.setAntiguedad(resultado.getDate("antiguedad"));
			
			getCon().close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cliente;
	}
	/**
	 * Devuelve una lista de clientes desde la base de datos
	 * @return Lista de clientes
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Cliente>getClientes() throws ClassNotFoundException{
		ArrayList<Cliente>clientes = new ArrayList<>();
		
		try {
			conectar();
			
			pst = getCon().prepareStatement("SELECT * FROM clientes");
			
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setDni(resultado.getString("dni"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setApellido(resultado.getString("apellido"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setMail(resultado.getString("mail"));
				cliente.setAntiguedad(resultado.getDate("antiguedad"));
				
				clientes.add(cliente);
				
			}
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}
	
//FIN CLIENTE
	
//INSCRIPCION
	/**
	 * Crea una inscripcion
	 * @param inscripcion
	 * @return Variable que indica si ha sido creado o no.
	 * @throws ClassNotFoundException
	 */
	public boolean crearInscripcion(Inscripcion inscripcion) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("INSERT INTO inscripciones VALUES (?,?,?,CURRENT_DATE)");
			pst.setString(1,inscripcion.getCliente().getDni());
			pst.setString(2,inscripcion.getActividad().getId_actividad());
			pst.setString(3, inscripcion.getGrupo().getId_grupo());
			
			
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
	 * Devuelve una inscripcion según el dni del cliente
	 * @param dni
	 * @return inscripcion
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Inscripcion> getInscripcionCliente(String dni) throws ClassNotFoundException {
		ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM inscripciones WHERE dni_cliente=?");
			pst.setString(1,dni);
			
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next()) {
				Inscripcion inscripcion = new Inscripcion();
				
				inscripcion.setCliente(getCliente(resultado.getString("dni_cliente")));
				inscripcion.setActividad(getActividad(resultado.getString("id_actividad")));
				inscripcion.setGrupo(getGrupo(resultado.getString("id_grupo")));
				inscripcion.setFecha(resultado.getDate("fecha"));
				
				inscripciones.add(inscripcion);
			}
			
			
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inscripciones;
	}
	/**
	 * Devuelve una lista de inscripciones segun la id de la actividad
	 * @param nombreActividad
	 * @return lista de inscripciones
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Inscripcion> getInscripcionActividad(String nombreActividad) throws ClassNotFoundException {
		ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		try {
			conectar();

			
			PreparedStatement pt = getCon().prepareStatement("SELECT id FROM actividades WHERE nombreac=?");
			pt.setString(1, nombreActividad);
			
			
			ResultSet result = pt.executeQuery();
			result.next();
			
			pst = getCon().prepareStatement("SELECT * FROM inscripciones WHERE id_actividad=?");
			pst.setString(1, result.getString("id"));
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
		
				Inscripcion inscripcion = new Inscripcion();
				
				inscripcion.setCliente(getCliente(resultado.getString("dni_cliente")));
				inscripcion.setActividad(getActividad(resultado.getString("id_actividad")));
				inscripcion.setGrupo(getGrupo(resultado.getString("id_grupo")));
				inscripcion.setFecha(resultado.getDate("fecha"));
				
				inscripciones.add(inscripcion);
			}
			
			
			
		
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inscripciones;
	}
	
	/**
	 * Devuelve una lista de inscripciones desde la base de datos
	 * @return lista de inscripciones
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Inscripcion>getInscripciones() throws ClassNotFoundException{
		ArrayList<Inscripcion>inscripciones = new ArrayList<>();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT *  FROM inscripciones");
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Inscripcion inscripcion = new Inscripcion();
					
				inscripcion.setCliente(getCliente(resultado.getString("dni_cliente")));
				inscripcion.setActividad(getActividad(resultado.getString("id_actividad")));
				inscripcion.setGrupo(getGrupo(resultado.getString("id_grupo")));
				inscripcion.setFecha(resultado.getDate("fecha"));
				
				inscripciones.add(inscripcion);
				getCon().close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inscripciones;
	}
	
	/**
	 * Elimina inscripcion según el dni del cliente y la id del grupo
	 * @param dni
	 * @param id_grupo
	 * @return Devuelve variable confirmando si se ha llevado a cabo o no.
	 * @throws ClassNotFoundException
	 */
	public boolean eliminarDeActividad(String dni,String id_grupo) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("DELETE FROM inscripciones WHERE dni_cliente=? and id_grupo=?");
			pst.setString(1, dni);
			pst.setString(2, id_grupo);
			
			
			pst.execute();
			getCon().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	//FIN INSCRIPCION
	
	//ACTIVIDADES
	

	/**
	 * Selecciona una actividad segun la id de la actividad
	 * @param id_actividad
	 * @return Devuelve una actividad.
	 * @throws ClassNotFoundException
	 */
	public Actividad getActividad(String id_actividad) throws ClassNotFoundException {
		Actividad actividad = new Actividad();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM actividades WHERE id=?");
			pst.setString(1, id_actividad);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			actividad.setId(resultado.getString("id"));
			actividad.setNombreActividad(resultado.getString("Nombreac"));
			actividad.setPrecio(resultado.getInt("precio"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actividad;
	}
	
	/**
	 * Selecciona la id de una actividad segun la id del grupo.
	 * @param id_grupo
	 * @return Devuelve la id de la actividad
	 * @throws ClassNotFoundException
	 */
	public Actividad getActividadPorGrupo(String id_grupo) throws ClassNotFoundException {
		Actividad actividad = new Actividad();
		try {
			conectar();

			
			PreparedStatement pt = getCon().prepareStatement("SELECT id_actividad FROM imparten WHERE id_grupo=?");
			pt.setString(1, id_grupo);
			
			ResultSet result = pt.executeQuery();
			result.next();
			pst = getCon().prepareStatement("SELECT * FROM actividades WHERE id=?");
			pst.setString(1, result.getString("id_actividad"));
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			actividad.setId(resultado.getString("id"));
			actividad.setNombreActividad(resultado.getString("Nombreac"));
			actividad.setPrecio(resultado.getInt("precio"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actividad;
	}
	
	
	/**
	 * Devuelve lista de actividades desde la base de datos.
	 * @return Lista de actividades.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Actividad> getActividades() throws ClassNotFoundException {
		ArrayList<Actividad> actividades=new ArrayList<Actividad>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT * FROM actividades");
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Actividad actividad = new Actividad();
				
				actividad.setId(resultado.getString("id"));
				actividad.setNombreActividad(resultado.getString("Nombreac"));
				actividad.setPrecio(resultado.getInt("precio"));
				
				actividades.add(actividad);
			}
			
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actividades;
	}

	/**
	 * Devuelve lista de actividades segun la id de actividad
	 * @return lista de actividades
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Actividad> getActividadesImpartidas() throws ClassNotFoundException {
		ArrayList<Actividad> actividades=new ArrayList<Actividad>();
		try {
			conectar();
			
			PreparedStatement pt = getCon().prepareStatement("SELECT DISTINCT id_actividad FROM imparten");
			ResultSet result = pt.executeQuery();
			
			while(result.next()) {
				pst = getCon().prepareStatement("SELECT * FROM actividades WHERE id=?");
				pst.setString(1, result.getString("id_actividad"));
				ResultSet resultado = pst.executeQuery();
				while(resultado.next()) {
					Actividad actividad = new Actividad();
					
					actividad.setId(resultado.getString("id"));
					actividad.setNombreActividad(resultado.getString("Nombreac"));
					actividad.setPrecio(resultado.getInt("precio"));
					
					actividades.add(actividad);
				}
			}
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actividades;
	}
	
	/**
	 * Devuelve la id de actividad segun la id del grupo
	 * @param id_grupo
	 * @return id de actividad
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String getIdActividad(String id_grupo) throws SQLException, ClassNotFoundException {
		String id_actividad="";

		conectar();

		
		pst=getCon().prepareStatement("SELECT id_actividad FROM inscripciones WHERE id_grupo=?");
		
		pst.setString(1, id_grupo);
		
		try {
			
			ResultSet result=pst.executeQuery();
			result.next();
			id_actividad=result.getString("id_actividad");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id_actividad;
	}

	//FIN ACTIVIDADES
	
	
	//SALAS
	
	/**
	 * Selecciona la sala segun la id.
	 * @param id_sala
	 * @return sala
	 * @throws ClassNotFoundException
	 */
	public Sala getSala(int id_sala) throws ClassNotFoundException {
		Sala sala = new Sala();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM salas WHERE id=?");
			pst.setInt(1, id_sala);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			sala.setId_sala(Integer.parseInt(resultado.getString("id")));
			sala.setCodigo(resultado.getString("codigo"));
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sala;
	}
	/**
	 * Devuelve la id de la sala segun el codigo.
	 * @param codigo
	 * @return id de sala.
	 * @throws ClassNotFoundException
	 */
	public int getIdSala(String codigo) throws ClassNotFoundException {
		int id_sala=0;
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT id FROM salas WHERE codigo=?");
			pst.setString(1, codigo);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			id_sala=(Integer.parseInt(resultado.getString("id")));
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id_sala;
	}
	/**
	 * Devuelve lista de salas desde la base de datos.
	 * @return lista de sala.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Sala> getSalas() throws ClassNotFoundException {
		ArrayList<Sala> salas = new ArrayList<Sala>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM salas ");
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Sala sala = new Sala();
				
				sala.setId_sala(Integer.parseInt(resultado.getString("id")));
				sala.setCodigo(resultado.getString("codigo"));
				
				salas.add(sala);
			}
			
			
			getCon().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salas;
	}
	//FIN SALAS
	
	//ALQUILER
	/**
	 * Selecciona alquiler segun el dni de cliente y la id de sala.
	 * @param dni_cliente
	 * @param id_sala
	 * @return alquiler
	 * @throws ClassNotFoundException
	 */
	public Alquiler getAlquiler(String dni_cliente,int id_sala) throws ClassNotFoundException {
		Alquiler alquiler = new Alquiler();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM alquileres WHERE dni_cliente=? AND id_sala=?");
			pst.setString(1, dni_cliente);
			pst.setInt(2, id_sala);
			
			
			ResultSet resultado = pst.executeQuery();
			resultado.next();
			alquiler.setCliente(getCliente(resultado.getString("dni")));
			alquiler.setSala(getSala(Integer.parseInt(resultado.getString("id_sala"))));
			alquiler.setFecha(resultado.getDate("fecha"));
			alquiler.setHora(resultado.getString("hora"));
			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alquiler;
	}
	
	/**
	 * Devuelve la lista de alquileres segun la id de sala.
	 * @param id_sala
	 * @return lista de alquileres.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Alquiler> getAlquilerSala(int id_sala) throws ClassNotFoundException {
		ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM alquiler WHERE id_sala=?");
			pst.setInt(1, id_sala);
			
			ResultSet resultado = pst.executeQuery();

			while(resultado.next()) {
				Alquiler alquiler = new Alquiler();
				
				alquiler.setCliente(getCliente(resultado.getString("dni_cliente")));
				alquiler.setSala(getSala(Integer.parseInt(resultado.getString("id_sala"))));
				alquiler.setFecha(resultado.getDate("fecha"));
				alquiler.setHora(resultado.getString("hora"));
				
				alquileres.add(alquiler);
				getCon().close();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return alquileres;
	}
	/**
	 * Devuelve lista de alquileres segun el dni de cliente.
	 * @param dni_cliente
	 * @return lista de clientes.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Alquiler> getAlquilerCliente(String dni_cliente) throws ClassNotFoundException {
		ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();
		
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT * FROM alquiler WHERE dni_cliente=? ");
			pst.setString(1, dni_cliente);
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Alquiler alquiler = new Alquiler();
				
				alquiler.setCliente(getCliente(resultado.getString("dni_cliente")));
				alquiler.setSala(getSala(Integer.parseInt(resultado.getString("id_sala"))));
				alquiler.setFecha(resultado.getDate("fecha"));
				alquiler.setHora(resultado.getString("hora"));
				
				alquileres.add(alquiler);
			}
			

			
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alquileres;
	}
	/**
	 * Devuelve la lista de todos los alquileres desde la base de datos.
	 * @return lista de alquileres.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Alquiler>getAlquileres() throws ClassNotFoundException{
		ArrayList<Alquiler>alquileres = new ArrayList<>();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT *  FROM alquiler");
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Alquiler alquiler = new Alquiler();
				alquiler.setCliente(getCliente(resultado.getString("dni_cliente")));
				alquiler.setSala(getSala(Integer.parseInt(resultado.getString("id_sala"))));
				alquiler.setFecha(resultado.getDate("fecha"));
				alquiler.setHora(resultado.getString("hora"));
				
				alquileres.add(alquiler);
				getCon().close();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return alquileres;
	}
	
	/**
	 * Inserta los datos de la reserva en la base de datos.
	 * @param alquiler
	 * @return Devuelve variable confirmando si se ha realizado la  insercion o no.
	 * @throws ClassNotFoundException
	 */
	public boolean realizarReservaPista(Alquiler alquiler) throws ClassNotFoundException {
		try {
			conectar();

			pst = getCon().prepareStatement("INSERT INTO alquiler VALUES (?,?,CURRENT_DATE,?)");
			pst.setString(1, alquiler.getCliente().getDni());
			pst.setInt(2, alquiler.getSala().getId_sala());
			pst.setString(3, alquiler.getHora());
			
			
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
	 * Elimina la reserva según el dni del cliente y la id de la sala.
	 * @param dni
	 * @param id_sala
	 * @return Devuelve variable confirmando si se ha realizado la eliminacion o no.
	 * @throws ClassNotFoundException
	 */
	public boolean cancelarReservaPista(String dni,int id_sala) throws ClassNotFoundException {
		
		try {
			conectar();

			pst = getCon().prepareStatement("DELETE from alquiler where dni_cliente=? and id_sala=?");
			pst.setString(1, dni);
			pst.setInt(2, id_sala);
			
			pst.execute();
			getCon().close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	//FIN ALQUILER
	
	//GRUPOS
	/**
	 * Selecciona grupo segun la id de grupo.
	 * @param id_grupo
	 * @return grupo.
	 * @throws ClassNotFoundException
	 */
	public Grupo getGrupo (String id_grupo) throws ClassNotFoundException {
		Grupo grupo = new Grupo();
		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM  grupos WHERE id=?");
			pst.setString(1, id_grupo);
			
			ResultSet resultado = pst.executeQuery();
			
			resultado.next();
			
			grupo.setId_grupo(resultado.getString("id"));
			grupo.setDias(resultado.getString("dias"));
			grupo.setHorarios(resultado.getString("horarios"));
			grupo.setMaxPartic(resultado.getInt("maxpartic"));
			grupo.setNumPartic(resultado.getInt("numpartic"));
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupo;
	}
	
	/**
	 * Selecciona lista de grupos segun la id de actividad.
	 * @param id_actividad
	 * @return lista de actividades.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Grupo>getGrupos(String id_actividad) throws ClassNotFoundException{
		ArrayList<Grupo>grupos = new ArrayList<>();

		try {
			conectar();

			pst = getCon().prepareStatement("SELECT* FROM grupos WHERE id_actividad=?");
			pst.setString(1, id_actividad);
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Grupo grupo= new Grupo();
				grupo.setId_grupo(resultado.getString("id_grupo"));
				grupo.setDias(resultado.getString("dias"));
				grupo.setHorarios(resultado.getString("horarios"));
				grupo.setMaxPartic(resultado.getInt("maxpartic"));
				grupo.setNumPartic(resultado.getInt("numpartic"));
				grupos.add(grupo);
				getCon().close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupos;
	}
	
	/**
	 * Selecciona lista de grupos desde la base de datos.
	 * @return lista de grupos.
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Grupo>getGrupos() throws ClassNotFoundException{
		ArrayList<Grupo>grupos = new ArrayList<>();

		try {
			conectar();

			pst = getCon().prepareStatement("SELECT * FROM grupos");
			
			
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Grupo grupo= new Grupo();
				grupo.setId_grupo(resultado.getString("id"));
				grupo.setDias(resultado.getString("dias"));
				grupo.setHorarios(resultado.getString("horarios"));
				grupo.setMaxPartic(resultado.getInt("maxpartic"));
				grupo.setNumPartic(resultado.getInt("numpartic"));
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
	 * Seleciona los grupos que estan siendo impartidos 
	 * @return Lista de grupos
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Grupo>getGruposImpartidos() throws ClassNotFoundException{
		ArrayList<Grupo>grupos = new ArrayList<>();
		
		try {
			
			for (Actividad actividad: getActividadesImpartidas()) {
				conectar();
				PreparedStatement pt = getCon().prepareStatement("SELECT id_grupo FROM imparten WHERE id_actividad=?");
				pt.setString(1, actividad.getId_actividad());
				ResultSet result = pt.executeQuery();
				while(result.next()) {
					pst = getCon().prepareStatement("SELECT * FROM grupos WHERE id=?");
					pst.setString(1, result.getString("id_grupo"));
					
					ResultSet resultado = pst.executeQuery();
					while(resultado.next()) {
						Grupo grupo= new Grupo();
						grupo.setId_grupo(resultado.getString("id"));
						grupo.setDias(resultado.getString("dias"));
						grupo.setHorarios(resultado.getString("horarios"));
						grupo.setMaxPartic(resultado.getInt("maxpartic"));
						grupo.setNumPartic(resultado.getInt("numpartic"));
						grupos.add(grupo);
					}
				}
			}
		getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupos;
	}
	
	//FIN GRUPOS

}	
	


