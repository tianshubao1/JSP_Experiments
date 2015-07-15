package edu.sbu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VehicleServlet
 */
@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new Dao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		if(request.getParameter("btn").equals("delete")){
			String vin = request.getParameter("dvin");
			
			dao.deleteVehicle(vin);
			
			List<Vehicle> vlist = dao.getAllVehicle(username);
			session.setAttribute("vlist", vlist);
			response.sendRedirect("vehicle.jsp");
			
		}else if(request.getParameter("btn").equals("edit")){
			String vin = request.getParameter("vin");
			if(dao.checkVin(vin)){
				Vehicle v = new Vehicle();
				v.setVin(request.getParameter("vin"));
				v.setMake(request.getParameter("make"));
				v.setModel(request.getParameter("mode"));
				v.setType(request.getParameter("type"));
				v.setYearofmake(request.getParameter("yearofmake"));
				v.setPicture(request.getParameter("picture"));
				v.setUsername(username);
				
				dao.updateVehicle(v);
				List<Vehicle> vlist = dao.getAllVehicle(username);
				session.setAttribute("vlist", vlist);
				response.sendRedirect("vehicle.jsp");}
			else{
				request.setAttribute("error", "invalid vin!!");
				request.getRequestDispatcher("/vehicle.jsp").forward(request, response);
			}
		}else if(request.getParameter("btn").equals("new")){
			
			Vehicle v = new Vehicle();
			v.setVin(request.getParameter("vin"));
			v.setMake(request.getParameter("make"));
			v.setModel(request.getParameter("mode"));
			v.setType(request.getParameter("type"));
			v.setYearofmake(request.getParameter("yearofmake"));
			v.setPicture(request.getParameter("picture"));
			v.setUsername(username);
			
			dao.createVehicle(v);
			List<Vehicle> vlist = dao.getAllVehicle(username);
			session.setAttribute("vlist", vlist);
			response.sendRedirect("vehicle.jsp");
		}else if(request.getParameter("btn").equals("back")){
			response.sendRedirect("customer.jsp");
		}
	}

}
