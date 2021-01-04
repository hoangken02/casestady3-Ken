package dao.classroomService;

import dao.ConnectDB;
import model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO implements IClassroomDAO {
    private final String INSERT_CLASSROOM = "INSERT INTO classroom " + " (id,name,centerId,courseId,userId,recentModuleId,startDate,endDate) values " + " (?,?,?,?,?,?,?,?);";
    private final String SELECT_CLASSROOM_BY_ID = "select id,name,centerId,courseId,userId,recentModuleId,startDate,endDate from classroom where id =?;";
    private final String SELECT_ALL_CLASSROOM = "select * from classroom;";
    private final String DELETE_CLASSROOM = "delete from classroom where id = ?;";
    private final String UPDATE_CLASSROOM = "update classroom set id=?,name=?,centerId=?,courseId=?,userId=?,recentModuleId=?,startDate=?,endDate=?;";

    List<Classroom> classrooms = new ArrayList<>();

    public ClassroomDAO() {
    }

    @Override
    public void insertClassroom(Classroom classroom) throws SQLException {
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLASSROOM)) {
            preparedStatement.setInt(1, classroom.getId());
            preparedStatement.setString(2, classroom.getName());
            preparedStatement.setInt(3, classroom.getCenterId());
            preparedStatement.setInt(4, classroom.getCourseId());
            preparedStatement.setInt(5, classroom.getUserId());
            preparedStatement.setInt(6, classroom.getRecentModuleId());
            preparedStatement.setString(7, classroom.getStartDate());
            preparedStatement.setString(8, classroom.getEndDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Classroom selectClassroom(int id) {
        Classroom classroom = null;
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASSROOM_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int centerId = resultSet.getInt("centerId");
                int courseId = resultSet.getInt("courseId");
                int userId = resultSet.getInt("userId");
                int recentModuleId = resultSet.getInt("recentModuleId");
                String startDate = resultSet.getString("startDate");
                String endDate = resultSet.getString("endDate");
                classroom = new Classroom(id, name, centerId, courseId, userId, recentModuleId, startDate, endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }

    @Override
    public List<Classroom> selectAllClassrooms() {
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASSROOM)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int centerId = resultSet.getInt("centerId");
                int courseId = resultSet.getInt("courseId");
                int userId = resultSet.getInt("userId");
                int recentModuleId = resultSet.getInt("recentModuleId");
                String startDate = resultSet.getString("startDate");
                String endDate = resultSet.getString("endDate");
                classrooms.add(new Classroom(id, name, centerId, courseId, userId, recentModuleId, startDate, endDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }

    @Override
    public boolean deleteClassroom(int id) throws SQLException {
        boolean rowDelete;
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLASSROOM)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }


    @Override
    public boolean updateClassroom(Classroom classroom) throws SQLException {
        boolean rowUpdate;
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLASSROOM)) {
            preparedStatement.setString(1, classroom.getName());
            preparedStatement.setInt(2, classroom.getCenterId());
            preparedStatement.setInt(3, classroom.getCourseId());
            preparedStatement.setInt(4, classroom.getUserId());
            preparedStatement.setInt(5, classroom.getRecentModuleId());
            preparedStatement.setString(6, classroom.getStartDate());
            preparedStatement.setString(7, classroom.getEndDate());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
}
