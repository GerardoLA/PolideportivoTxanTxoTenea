package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Alquiler;
import modelo.dao.ModeloRecepcion;

/**
 * Seleciona sala por id-sala y cliente por dni , redireccona al formulario de ReservarPista.jsp, se recibe el dasto de "horas", se realiza la reserva y se acaba en VerReservas.
 */
@WebServlet("/ReservarPista")
public class ReservarPista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservarPista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloRecepcion modRec = new ModeloRecepcion();
		
		try {
			request.setAttribute("salas", modRec.getSalas());
			request.setAttribute("clientes", modRec.getClientes());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("ReservarPista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModeloRecepcion modRec = new ModeloRecepcion();
		
		Alquiler alquiler = new Alquiler();
		
		try {
			alquiler.setCliente(modRec.getCliente(request.getParameter("dni")));
			alquiler.setSala(modRec.getSala(modRec.getIdSala(request.getParameter("sala"))));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alquiler.setHora(request.getParameter("horas"));
		
		try {
			modRec.realizarReservaPista(alquiler);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("VerReservas").forward(request, response);
	}

}
