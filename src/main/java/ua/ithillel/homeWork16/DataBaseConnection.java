package ua.ithillel.homeWork16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection extends LessonDao {
    public static void main(String[] args) {
        Lesson lesson = new Lesson();
        Lesson lesson2 = new Lesson();
        lesson.setName("lesson2");
        lesson.setHomework("Write Hello world");
        Lesson lesson1 = new Lesson(99, "About generic", "sam chitay");
//        getConnection();
//        save(lesson2);
//        save(lesson2);
//        save(lesson);
//        closeConnection();
//        delete(0);
//        System.out.println(getAllLessons());
        System.out.println(getLessonById(99));

    }

    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/employee"; ///// Attention
        String user = "postgres";
        String password = "user";

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        return connection;
    }

    public static void closeConnection() {   // зачем  он в домашке ? это же стандартный метод
        try {
            Connection connection = DataBaseConnection.getConnection();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

