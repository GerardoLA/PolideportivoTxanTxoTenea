package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Empleado;
import modelo.dao.ModeloJefe;

/**
 * Muestra todos los empleados de la base de datos
 */
@WebServlet("/VerEmpleados")
public class VerEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloJefe mj = new ModeloJefe();
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			empleados = mj.getEmpleados();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("empleados", empleados);
		
		request.getRequestDispatcher("VerEmpleados.jsp").forward(request, response);
	}
		
		

		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
