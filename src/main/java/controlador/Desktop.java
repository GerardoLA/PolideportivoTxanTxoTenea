	package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.bean.Usuario;
import modelo.dao.ModeloLogin;

/**
 * Manda a Login.jsp, recibe el nombre y contrasena, si la contrasena coincide y la id del usuario contiene la cadena indicada redirecciona a menuJefe,menuempleado o verActividades
 */
@WebServlet("/Desktop")
public class Desktop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Desktop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contrasena = request.getParameter("contrasena");
		String nombre = request.getParameter("nombre");
		
		ModeloLogin ml = new ModeloLogin();
		Usuario usuario = ml.getContrasena(nombre);
		HttpSession session= request.getSession();

		if(contrasena.equals(usuario.getContrasena())){
				try {
					session.setAttribute("id_empleado", ml.getIdEmpleado(usuario.getId_usuario()));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(usuario.getId_usuario().contains("MON") || usuario.getId_usuario().equals("MON")){
				response.sendRedirect("VerActividades");
			}
			else if(usuario.getId_usuario().contains("REC") || usuario.getId_usuario().equals("REC")){
				response.sendRedirect("MenuRecepcionista.jsp");
			}
			else if(usuario.getId_usuario().contains("JEF") || usuario.getId_usuario().equals("JEF")) {
				response.sendRedirect("MenuJefe.jsp");
			}
		}
		else {
			request.setAttribute("error", "Usuario o contrasena erroneos");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	
		
		}
	}


