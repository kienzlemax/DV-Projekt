import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addNummer {
	

	public int eintragen(int notiz) {
		
	    String url = "jdbc:mysql://localhost:3306/todoliste";
	    String user = "root";
	    String pass = "";
	    
		try { 
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			return stmt.executeUpdate("INSERT INTO user(Matrikelnummer) VALUES" + notiz + "´)");	//SQL-Sprache, eintragen in die Matrikelnummer Spalte
		}
		catch (SQLException e) {
			return 0;
		}
		}
}
