package EmployeeSystem.webapp;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmployeeSystem.dao.Employeedao;
import EmployeeSystem.model.Employee;
@WebServlet("/")
public class EmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private Employeedao employeedao;
    public EmployeeServlet() {
        //super();
    	this.employeedao = new Employeedao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		switch(action) {
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			try {
			insertEmployee(request,response);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteEmployee(request,response);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
			showEditForm(request,response);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateEmployee(request,response);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			break;
		default:
			try {
				listEmployee(request,response);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			break;
		}
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
		throws SQLException,IOException
	{
		int id =Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String maritalstatus = request.getParameter("maritalStatus");
		String active = request.getParameter("active");
		Employee newEmployee = new Employee(id,name,age,address,maritalstatus,active);
		employeedao.insertEmployee(newEmployee);
		response.sendRedirect("list");
	}
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
	 			throws IOException, SQLException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		employeedao.deleteEmployee(id);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		throws IOException, SQLException,ServletException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existEmployee = employeedao.selectEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("employee", existEmployee);
		dispatcher.forward(request, response);
	}
	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException,IOException, ServletException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String maritalstatus = request.getParameter("maritalStatus");
		String active = request.getParameter("active");
		
		Employee employee = new Employee(id,name,age,address,maritalstatus,active);
		employeedao.updateEmployee(employee);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
//		dispatcher.forward(request, response);
		response.sendRedirect("list");

	}
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException,IOException,ServletException{
		List<Employee> listEmployee = employeedao.selectAllEmployee();
		request.setAttribute("listEmployee", listEmployee);   
		System.out.print(listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}
}
	
		













