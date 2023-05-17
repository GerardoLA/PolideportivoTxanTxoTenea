package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		try {
			HttpSession session = request.getSession();
			
			if((Integer) session.getAttribute("id_empleado")==null) {
				request.setAttribute("error", "Inicia sesion antes de hacer cualquier operacion");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else{

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
						boolean funciona=false;
						funciona=modJefe.AltaUsuario(usuario);
						if(funciona) {
							request.setAttribute("confirmacion", "Usuario insertado correctamente");
						}
						else {
							request.setAttribute("error", "No se ha insertado el usuario correctamente");
						}
						
						request.getRequestDispatcher("VerUsuarios").forward(request, response);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
					}
					
					
				}else {
					request.setAttribute("error", "La contrasena tiene que tener 8 digitos y un numero como minimo");
					request.getRequestDispatcher("AltaUsuarioForm.jsp").forward(request, response);
				}
				
			}
			
		} catch (Exception e) {
			request.setAttribute("error", "Ha ocurrido un error, inicio sesion de nuevo porfavor");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		
	}

}
