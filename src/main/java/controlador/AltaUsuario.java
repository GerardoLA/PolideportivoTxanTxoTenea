package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Usuario;
import modelo.dao.ModeloJefe;

/**
 * AltaUsuario, manda a AltaUsuarioForm.jsp,recibe los datos, comprueba que la contrasena cumple los requisitos y  crea el usuario si no vuelve al formulario de altausuarioForm
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("AltaUsuarioForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ModeloJefe modJefe = new ModeloJefe();
		
		Usuario usuario = new Usuario();
		String id_usuario = request.getParameter("id_usuario");
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		
		usuario.setId_usuario(id_usuario);
		usuario.setNombre(nombre);
		usuario.setContrasena(contrasena);
		
		
		if(usuario.comprobarContraseña()) {
			try {
				modJefe.AltaUsuario(usuario);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("VerUsuarios").forward(request, response);
		}else {
			request.setAttribute("error", "La contrasena tiene que tener 8 digitos y un numero como minimo");
			request.getRequestDispatcher("AltaUsuarioForm.jsp").forward(request, response);
		}
		
		
	}

}
