package training.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAOImpl implements CustomerDAO {

	public Customer getCustomer(String name) {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Customer where id=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteCustomer(Integer id) {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();

			statement.executeUpdate("delete * from Customer where id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("URL", "User", "Password");
	}

}
