package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Usuario;
import modelo.dao.ModeloJefe;

/**
 * Selecciona el objeto usuario de la base de datos segun id_usuario y lo manda al formulario
 */
@WebServlet("/ModificarUsuarioForm")
public class ModificarUsuarioForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuarioForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		
		ModeloJefe mj = new ModeloJefe();
		String id_usuario = request.getParameter("id_usuario");
		try {
			usuario = mj.getUsuarioPorId(id_usuario);
			try {
				mj.getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("usuario",usuario);
		request.getRequestDispatcher("ModificarUsuarioForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
