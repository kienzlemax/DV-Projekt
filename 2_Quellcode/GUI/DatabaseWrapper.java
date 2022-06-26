import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseWrapper {

	private Connection dbConnection;

	/**
	 *this function generates a standardized connection to the database, this can be reused in different places
	 * to have only one function generating the connection
	 * saves the connection into a class variable
	 * 
	 * @author nicom, davidjl21
	 */	
	public void generateConnection() {
		String url = "jdbc:mysql://localhost:3306/todoliste";
		String user = "root";
		String pass = "";

		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Verbunden mit Datenbank");
			this.dbConnection = con;
		} catch (SQLException e) {

		}
	}
	
	/**
	 * adds a User with the the fields which are handed over
	 * @param firstname The firstname of the user
	 * @param lastname The lastname of the user
	 * @param password The password of the user
	 * @param email The validated email of the user
	 * @author nicom, davidjl21
	 */
	public int addUser(String firstname, String lastname, String password, String email) {

		try {

			Statement stmt = this.dbConnection.createStatement();
			return stmt.executeUpdate("INSERT INTO `user` (`Vorname`, `Nachname`, `EMail`, `Matrikelnr`) VALUES ('"
					+ firstname + "', '" + lastname + "', '" + email + "', '" + password + "');");
		} catch (SQLException e) {
			return 0;
		}
	}
	public ResultSet searchUser(String email, String password) {
		ResultSet rs = null;
		try {

			Statement stm = this.dbConnection.createStatement();
			

			String abfrageUser = "SELECT `EMail`,`Matrikelnr` FROM `user` WHERE `EMail` = '"+ email + "' AND `Matrikelnr` = "+ Integer.parseInt(password);
			
			rs = stm.executeQuery(abfrageUser);
		} catch (SQLException e) {
		}
		return rs;
		
	}

}