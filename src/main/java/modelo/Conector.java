package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
private Connection con;
	
	public void conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String HOST="jdbc:mysql://localhost/";
		final String BBDD="polideportivo_final";
		final String USERNAME="root";
		final String PASSWORD="";
		con=DriverManager.getConnection(HOST+BBDD,USERNAME,PASSWORD);
	}
	
	public void cerrar() throws SQLException {
		con.close();
	}

	public Connection getCon() {
		return con;
	}

}
