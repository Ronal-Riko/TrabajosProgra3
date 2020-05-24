package com.ronal.controlador;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Ronaal.DAO.ProductoDAO;
import com.google.gson.Gson;

import web.ronal.model.Inventario;

/**
 * Servlet implementation class ServeletControler
 */
public class ServeletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
Inventario in= new Inventario();
		
		ProductoDAO cld= new ProductoDAO();
		String id =null;
		String nombrep =null;
		String preciop =null;
		String cantidadp =null;
		String totalp =null;
		
		try {
			id	= request.getParameter("Id");
			nombrep = request.getParameter("Nproductos");
			preciop = request.getParameter("Pproductos");
			cantidadp = request.getParameter("Cproductos");
			totalp = request.getParameter("Tproductos");
			
			
			in.setId(Integer.parseInt(id));
			in.setNombreProducto(nombrep);
			in.setPrecioProducto(Double.parseDouble(preciop));
			in.setCantidadProducto(Integer.parseInt(cantidadp));
			in.setTotalProducto(Double.parseDouble(totalp));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		String action = request.getParameter("btn");
		
		
		if(action.equals("GUARDAR")) {
			in.setId(Integer.parseInt(id));
			in.setNombreProducto(nombrep);
			in.setPrecioProducto(Double.parseDouble(preciop));
			in.setCantidadProducto(Integer.parseInt(cantidadp));
			in.setTotalProducto(Double.parseDouble(totalp));
		cld.agregarDatos(in);
		}
		else if (action.equals("ACTUALIZAR")) {
			
		
			in.setId(Integer.parseInt(id));
			in.setNombreProducto(nombrep);
			in.setPrecioProducto(Double.parseDouble(preciop));
			in.setCantidadProducto(Integer.parseInt(cantidadp));
			in.setTotalProducto(Double.parseDouble(totalp));
		cld.actualizarDatos(in);
		
	}else if (action.equals("ELIMINAR")) {
		in.setId(Integer.parseInt(id));
		cld.eliminarDatos(in);
	}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
ProductoDAO cldao= new ProductoDAO();
		
		Gson json= new Gson();
		
		
		try {
			
			response.getWriter().append(json.toJson(cldao.productoLista()));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
			
		//doGet(request, response);
		 
		
	}

}
