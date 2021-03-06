package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Employee;
//lol
public class EmployeeDao {
	private PreparedStatement preparedStatement;
	private char[] PreparedStatement;

	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee" +
	"(id, first_name, last_name, username, password, address, contact) VALUES" +
				"(?, ?, ?, ?, ?, ?, ?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");
			
		//Step 2: Create a statement using connection object
	PreparedStatement prepareStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, employee.getFirstname());
			preparedStatement.setString(3, employee.getLastname());
			preparedStatement.setString(4, employee.getUsername());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getContact());
			
			System.out.println(PreparedStatement);
			
	//Step 3: Execute the Query or Update query
			
			result = preparedStatement.executeUpdate();			
			
		} catch (SQLException e) {
		
		//process sql exception
			e.printStackTrace();
		}
		
		return result;
			
	}

}
