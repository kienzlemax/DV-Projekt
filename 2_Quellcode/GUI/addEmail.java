import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addEmail {		//Klasse für Email Button
	

	public int eintragen(String notiz) {		
		
	    String url = "jdbc:mysql://localhost:3306/todoliste";
	    String user = "root";
	    String pass = "";
	    
		try { 
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			return stmt.executeUpdate("INSERT INTO user(E-Mail) VALUES" + notiz + "´)"); //Eingabe in Spalte Email hinzufügen, SQL-Sprache
		}
		catch (SQLException e) {
			return 0;
		}
		}
}
