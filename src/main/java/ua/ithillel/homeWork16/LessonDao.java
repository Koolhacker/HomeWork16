package ua.ithillel.homeWork16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {

    public static int save(Lesson lesson) {
        int status = 0;
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into lesson(name,homework_id,id) values (?,?,?)");
            ps.setString(1, lesson.getName());
            ps.setString(2, lesson.getHomework());
            ps.setInt(3, lesson.getId());
            status = ps.executeUpdate();
           connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from lesson where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return status;
    }

    public static List<Lesson> getAllLessons() {
        List<Lesson> listLessons = new ArrayList<>();
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from lesson");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getInt(1));
                lesson.setName(rs.getString(2));
                lesson.setHomework(rs.getString(4));
                listLessons.add(lesson);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listLessons;
    }

    public static Lesson getLessonById(int id) {
        Lesson lesson = new Lesson();
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from lesson where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lesson.setId(rs.getInt(1));
                lesson.setName(rs.getString(2));
                lesson.setHomework(rs.getString(4));
            }
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return lesson;
    }

    public static int update(Lesson lesson) {
        int status = 0;
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("update lesson set name=?,homework_id=? where id=?");
            ps.setString(1, lesson.getName());
            ps.setString(2, lesson.getHomework());
//            ps.setInt(3, lesson.getId());
            status = ps.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }
}
