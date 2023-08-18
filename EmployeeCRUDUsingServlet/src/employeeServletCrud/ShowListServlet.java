package employeeServletCrud;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ShowListServlet")
public class ShowListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.html'>Add new Employee</a>");
		out.println("<h1>All Employees List: </h1>");
		List<Employee> allEmployees = EmployeeDao.getAllEmpList();
		out.println("<table border='1' 	width= '50%'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Country</th><th colspan='2'>Edit Opetions</th></tr>");
		for (Employee oneEmployee : allEmployees) {
			out.println("<tr>"
							+ "<td>" + oneEmployee.getId() + "</td>"
							+ "<td>" + oneEmployee.getName() + "</td>"
							+ "<td>" + oneEmployee.getEmail() + "</td>"
							+ "<td>" + oneEmployee.getPassword() + "</td>"
							+ "<td>"+ oneEmployee.getCountry() + "</td>"
							+ "<td><a href='EditServlet?id="+oneEmployee.getId()+"'>Update</a></td>"
							+ "<td><a href='DeleteServlet?id="+oneEmployee.getId()+"'>Delete</a></td>"
							+ "</tr>");
		}
		out.println("</table>");
	}
}
