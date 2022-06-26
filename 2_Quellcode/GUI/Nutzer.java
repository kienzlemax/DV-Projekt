import java.sql.*;

public class Nutzer {

public static void main(String[] args){

	/**creates the path to the server. String url contains the JDBC Driver could be seen as the Interface 
	 * between the software and the database. Like a translator it allows to use the language 
	 * of the database in the software.
	 * Mysql is the name of the database. It safes, shows and changes data in tables.
	 * localhost:3306 is the address (the computer) where the database is located on.
	 * todoliste is the name of the database.
	 * string user is called root and it is the first folder of the database.
	 * string pass could be needed if you want the database to be secured
	 @author nicom*/
    String url = "jdbc:mysql://localhost:3306/todoliste";       
    String user = "root";
    String pass = "";

    try {
    	/**DriverManager.getConnection initialises the Connection to the database
    	@author nicom*/
        Connection con = DriverManager.getConnection(url, user, pass); 
        
      /**Creates a Statement object for sendingSQL statements to the database.@author nicom*/
        Statement stm = con.createStatement(); 
        
      /**The command "SELECT*FROM user" commands the database to show their datas. 
        It is a Structured Query Language (SQL) and is the language of the relational database we are using
        @author nicom*/
        String abfrage = "SELECT * FROM user"; 
        
        /**Returns an integer representing the number of rows affected by the SQL statement.@author nicom*/
        ResultSet rs = stm.executeQuery(abfrage);

        /**Counts the columns and gets the data in the Columns@author nicom*/
        int columns = rs.getMetaData().getColumnCount();
        for(int i = 1; i<=columns; i++)
        	System.out.println();
        
        /**shows the datas in the columns@author nicom*/
        while(rs.next()){                               
            System.out.println(rs.getString(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getString(4)	);
        }


    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    

}
}
