package lab3;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = Compound_BD.compound();
            Requests.request1(connection, "th", 156);
            Requests.request2(connection, "mn");
            // обработка ошибки  Class.forName
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.out.println("JDBC DBMS driver not found!");
            // обработка ошибок  DriverManager.getConnection
        } catch (SQLException e) {
            e.printStackTrace(); 
            System.out.println("error SQL !");
        } finally {
                connection.close();
                System.out.println("Disconnection from the DBMS is completed.");
            
        }
    }
}
