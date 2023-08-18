package employeeServletCrud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlate")
public class SaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name= request.getParameter("empName");
		String email= request.getParameter("empEmail");
		String password= request.getParameter("empPassword");
		String country= request.getParameter("empCountry");
		Employee addEmployee=new Employee();
		addEmployee.setName(name);
		addEmployee.setEmail(email);
		addEmployee.setPassword(password);
		addEmployee.setCountry(country);
		int check=EmployeeDao.save(addEmployee);
		if(check>0) {
			out.println("<h1>Employee is Saved Successfully</h1>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else {
			out.println("The Employee is not saved to List");
		}
	}
}
