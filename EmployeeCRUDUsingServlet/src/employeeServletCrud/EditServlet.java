package employeeServletCrud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<h1> Update Employee Details</h1>");
		String stringId=request.getParameter("id");
		int id= Integer.parseInt(stringId);
		Employee editEmployee=EmployeeDao.getEmpById(id);
		out.println("<form action='UpdateServlet' method='post'>");
		out.println("<table >");
		out.println("<tr><td>Employee ID:</td><td><input type='hidden' name='id' value='"+editEmployee.getId()+"'/></td></tr>");
		out.println("<tr><td>Employee Name:</td><td><input type='text' name='newName' value='"+editEmployee.getName()+"'/></td></tr>"); 
		out.println("<tr><td>Employee Email:</td><td><input type='email' name='newEmail' value='"+editEmployee.getEmail()+"'/></td></tr>");
		out.println("<tr><td>Employee Password:</td><td><input type='password' name='newPassword' value='"+editEmployee.getPassword()+"'/></td></tr>");
		out.println("<tr><td>Employee Country:</td><td>");  
		out.println("<select name='newCountry' style='width:150px'>");
		out.println("<option value=\"India\">India</option>");  
	    out.println("<option value=\"UK\">UK</option>");  
	    out.println("<option value=\"USA\">USA</option>");  
	    out.println("<option value=\"Other\">Other</option>");
		out.println("</select>");
		out.println("</td></tr>");
		out.println("<tr><td><input type='submit' value='Update & Save '/></td></tr>");  
		out.println("</table >");
		out.println("</form>");
	}
}
