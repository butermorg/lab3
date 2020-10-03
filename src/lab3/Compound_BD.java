
package lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Compound_BD {

    static final String DB_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:/c:/JavaPrj/db/JBDC";

    public static Connection compound() throws ClassNotFoundException, SQLException {
        //Проверяем наличие JDBC драйвера для работы с БД
        Class.forName(DB_DRIVER);
        System.out.println("JDBC DBMS driver is found.");
        //соединениес БД
        Connection connection = DriverManager.getConnection(DB_URL);
        System.out.println("The connection to the DBMS is made.");
        return connection;
    }
    
}
