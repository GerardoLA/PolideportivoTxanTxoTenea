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
 * Redirecciona a VerEmpleados.jsp y muestra el empleado indicado por idEmpleado
 */
@WebServlet("/VerEmpleado")
public class VerEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerEmpleado() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloJefe mj = new ModeloJefe();
		ArrayList<Empleado>empleados = new ArrayList<Empleado>();
		
		try {
			empleados.add(mj.getEmpleado(Integer.parseInt(request.getParameter("idEmpleado"))));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
