import java.sql.*;

public class addUser {
	

	public int eintragen(String notiz) {
		
	    String url = "jdbc:mysql://localhost:3306/todoliste";
	    String user = "root";
	    String pass = "";
	    
		try { 
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			return stmt.executeUpdate("INSERT INTO user(Vorname) VALUES" + notiz + "´)");	//SQL-Sprache, eintragen in die Vornamen Spalte
		}
		catch (SQLException e) {
			return 0;
		}
		}
}
// für jede Variable machen
