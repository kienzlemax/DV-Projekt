import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addNachname {
	

	public int eintragen(String notiz) {
		
	    String url = "jdbc:mysql://localhost:3306/todoliste";
	    String user = "root";
	    String pass = "";
	    
		try { 
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			return stmt.executeUpdate("INSERT INTO user(Nachname) VALUES" + notiz + "´)");	//SQL-Sprache, eintragen in die Nachnamen Spalte
		}
		catch (SQLException e) {
			return 0;
		}
		}
}
