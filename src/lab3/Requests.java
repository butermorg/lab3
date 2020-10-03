package lab3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Requests {
/* Вывести информацию о преподавателях, работающих в заданный день
недели в заданной аудитории.*/
    public static void request1(Connection connection, String dayoflesson, int classroom) throws SQLException {
        Statement statement = null;
        statement = connection.createStatement();
        String sql = "SELECT prep.*\n"
                + " FROM prep INNER JOIN lesson ON prep.idlesson=lesson.idlesson\n"
                + " GROUP BY lesson.dayoflesson, lesson.classroom\n"+
                "HAVING lesson.dayoflesson = \""
                + dayoflesson + "\" and lesson.classroom = \""
                + classroom + "\";";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int idprep = resultSet.getInt("prep.idprep");
            String nameprep = resultSet.getString("prep.name");
            String namelesson = resultSet.getString("lesson.name");
            String daylesson = resultSet.getString("lesson.dayoflesson");
            int classroomlesson = resultSet.getInt("lesson.classroom");
            System.out.println("idprep: " + idprep+
                    "\nName: " + nameprep+
                    "\nName: " + namelesson+
                    "\ndaylesson: " + daylesson+
                    "\nclassroomlesson: " + classroomlesson);
        }
        resultSet.close();
        statement.close();
    }
    /*Вывести информацию о преподавателях, которые не ведут занятия в за
    данный день недели*/
    public static void request2(Connection connection, String dayoflesson) throws SQLException {
        Statement statement = null;
        statement = connection.createStatement();
        String sql = "SELECT prep.*\n"+
                "FROM prep INNER JOIN lesson ON prep.idlesson=lesson.idlesson\n"+
                "GROUP BY lesson.classroom, lesson.dayoflesson\n"+
                "HAVING lesson.dayoflesson NOT IN (\""
                + dayoflesson + "\");";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int idprep = resultSet.getInt("prep.idprep");
            String nameprep = resultSet.getString("prep.name");
            String namelesson = resultSet.getString("lessons.name");
            String daylesson = resultSet.getString("lessons.dayofweak");
            int classroomlesson = resultSet.getInt("lessons.class");
            System.out.println("idprep: " + idprep+
                    "\nName: " + nameprep+
                    "\nName: " + namelesson+
                    "\ndaylesson: " + daylesson+
                    "\nclassroomlesson: " + classroomlesson);
        }
        resultSet.close();
        statement.close();
    }
}
