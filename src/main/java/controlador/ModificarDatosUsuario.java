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
 * Recibe los datos de usuario y los modifica en la base de datos, comprobando que cumpla con los requisitos(contrasena 8 dgitos y un numero como minimo)
 */
@WebServlet("/ModificarDatosUsuario")
public class ModificarDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatosUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloJefe mp = new ModeloJefe();
		Usuario usuario = new Usuario();

		usuario.setId_usuario(request.getParameter("id_usuario"));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setContrasena(request.getParameter("contrasena"));
		
		if(usuario.comprobarContraseña()) {
			mp.ModificarUsuario(usuario);
			request.getRequestDispatcher("VerUsuarios").forward(request, response);
		}else {
			request.setAttribute("error", "La contrasena tiene que tener 8 digitos y un numero como minimo");
			request.getRequestDispatcher("ModificarUsuarioForm").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
