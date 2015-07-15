package edu.sbu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CustomerSerlvet
 */
@WebServlet("/CustomerSerlvet")
public class CustomerSerlvet extends HttpServlet {
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
		if(request.getParameter("btn").equals("view")){
			
			String username = request.getParameter("username");
			if(dao.checkUsername(username)){
				session.setAttribute("username", username);
				List<Vehicle> vlist = dao.getAllVehicle(username);
				session.setAttribute("vlist", vlist);
				response.sendRedirect("vehicle.jsp");
			}
			else{
				request.setAttribute("error", "invalid username!!");
				request.getRequestDispatcher("/customer.jsp").forward(request, response);
			}
			
		}else if(request.getParameter("btn").equals("edit")){
			String username = request.getParameter("username2");
			if(dao.checkUsername(username)){
				Customer c = new Customer();
				c.setUsername(request.getParameter("username2"));
				c.setFirstname(request.getParameter("firstname"));
				c.setLastname(request.getParameter("lastname"));
				c.setPolicyno(request.getParameter("policyno"));
				c.setPhoneno(request.getParameter("phoneno"));
				c.setEmail(request.getParameter("email"));
				c.setPolicyco(request.getParameter("policyco"));
				c.setAAA(request.getParameter("AAA"));
				
				dao.updateCustomer(c);
				List<Customer> list = dao.getAllCustomer();
				session.setAttribute("list", list);
				response.sendRedirect("customer.jsp");}
			else{
				request.setAttribute("error", "invalid username!!");
				request.getRequestDispatcher("/customer.jsp").forward(request, response);
			}
			
		}else if(request.getParameter("btn").equals("delete")){
			String username = request.getParameter("username");
			dao.deleteCustomer(username);
			
			List<Customer> list = dao.getAllCustomer();
			session.setAttribute("list", list);
			response.sendRedirect("customer.jsp");
			
		}else if(request.getParameter("btn").equals("new")){
			Customer c = new Customer();
			c.setUsername(request.getParameter("username2"));
			c.setFirstname(request.getParameter("firstname"));
			c.setLastname(request.getParameter("lastname"));
			c.setPolicyno(request.getParameter("policyno"));
			c.setPhoneno(request.getParameter("phoneno"));
			c.setEmail(request.getParameter("email"));
			c.setPolicyco(request.getParameter("policyco"));
			c.setAAA(request.getParameter("AAA"));
			
			dao.createCustomer(c);
			List<Customer> list = dao.getAllCustomer();
			session.setAttribute("list", list);
			response.sendRedirect("customer.jsp");
			
		}else if(request.getParameter("btn").equals("log out")){
			session.invalidate();
			dao.close();
			response.sendRedirect("login.jsp");
		}
	}

}
