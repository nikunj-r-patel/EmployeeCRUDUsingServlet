package employeeServletCrud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDao {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empservlet", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return connection;
	}
	public static int save(Employee employee) {
		int check = 0;
		try {
			Connection connectiontoAdd = EmployeeDao.getConnection();
			java.sql.PreparedStatement insertQuery = connectiontoAdd
					.prepareStatement("insert into employees(name,email,password,country)values(?,?,?,?)");
			insertQuery.setString(1, employee.getName());
			insertQuery.setString(2, employee.getEmail());
			insertQuery.setString(3, employee.getPassword());
			insertQuery.setString(4, employee.getCountry());
			check = insertQuery.executeUpdate();
			connectiontoAdd.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return check;
	}
	public static int update(Employee employee) {
		int check=0;
		try {
			Connection connectionToUpdate=EmployeeDao.getConnection();
			java.sql.PreparedStatement updateQuery=connectionToUpdate.prepareStatement("update employees set name=?,email=?,password=?,country=? where id=?");
			updateQuery.setString(1, employee.getName());
			updateQuery.setString(2, employee.getEmail());
			updateQuery.setString(3, employee.getPassword());
			updateQuery.setString(4, employee.getCountry());
			updateQuery.setInt(5, employee.getId());
			check= updateQuery.executeUpdate();
			connectionToUpdate.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}
	public static int delete(int id) {
		int check=0;
		try {
			Connection connectionToDelete=EmployeeDao.getConnection();
			java.sql.PreparedStatement deleteQuery=connectionToDelete.prepareStatement("delete from employees where id=?");
			deleteQuery.setInt(1,id);
			check=deleteQuery.executeUpdate();
			connectionToDelete.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public static Employee getEmpById(int id) {
		Employee empData= new Employee();
		try {
			Connection connectionToGetData=EmployeeDao.getConnection();
			java.sql.PreparedStatement getEmployeeData=connectionToGetData.prepareStatement("select * from employees where id=?");
			getEmployeeData.setInt(1, id);
			ResultSet empDetail=getEmployeeData.executeQuery();
			if(empDetail.next()) {
				empData.setId(empDetail.getInt(1));
				empData.setName(empDetail.getString(2));
				empData.setEmail(empDetail.getString(3));
				empData.setPassword(empDetail.getString(4));
				empData.setCountry(empDetail.getString(5));
			}
			connectionToGetData.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return empData;
	}
	public static List<Employee> getAllEmpList(){
		List<Employee> listOfEmps=new ArrayList<Employee>();
		try {
			Connection connectionToSeeAll=EmployeeDao.getConnection();
			PreparedStatement showAllQuery=connectionToSeeAll.prepareStatement("select * from employees");
			ResultSet allEmpDetail= showAllQuery.executeQuery();
			while (allEmpDetail.next()) {
				Employee eachEmployee=new Employee(allEmpDetail.getInt(1), allEmpDetail.getString(2), allEmpDetail.getString(3), allEmpDetail.getString(4), allEmpDetail.getString(5));
				listOfEmps.add(eachEmployee);	
			}
			connectionToSeeAll.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listOfEmps;
	}
}
