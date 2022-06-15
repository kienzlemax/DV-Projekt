import java.sql.*;

public class Nutzer {

public static void main(String[] args){

    String url = "jdbc:mysql://localhost:3306/todoliste";
    String user = "root";
    String pass = "";

    try {
        Connection con = DriverManager.getConnection(url, user, pass);
        
        System.out.println("Erfolgreich mit Datenbank verbunden!");
        
        Statement stm = con.createStatement();
        String abfrage = "SELECT * FROM user";
        ResultSet rs = stm.executeQuery(abfrage);

        int columns = rs.getMetaData().getColumnCount();
        for(int i = 1; i<=columns; i++)
        	System.out.println();
        
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
