package employeeServletCrud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String stringId= request.getParameter("id");
		int id=Integer.parseInt(stringId);
		String newName= request.getParameter("newName");
		String newEmail= request.getParameter("newEmail");
		String newPassword= request.getParameter("newPassword");
		String newCountry= request.getParameter("newCountry");
		Employee newEmpDetails=new Employee(id, newName, newEmail, newPassword, newCountry);
		System.out.println(newEmpDetails);
		int check=EmployeeDao.update(newEmpDetails);
		System.out.println(check);
		if(check>0) {
			//out.println("<h2>Employee Updated Sucessfully</h2>");
			response.sendRedirect("ShowListServlet");
		}else {
			out.println("Employee is not in the list ");
			//request.getRequestDispatcher("index.html").include(request, response);
		}
	}
}
