package dao.studentServive;

import dao.ConnectDB;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private final String INSERT_STUDENT = "INSERT INTO student " + " (firstname,lastname,email,phoneNumber,classroomId) values " + " (?,?,?,?,?);";
    private final String SELECT_STUDENT_BY_ID = "select id,firstname,lastname,courseId,email,phoneNumber,classroomId from student where id =?;";
    private final String SELECT_ALL_STUDENT = "select * from student;";
    private final String DELETE_STUDENT = "delete from student where id = ?;";
    private final String UPDATE_STUDENT = "update student set firstname=?,lastname=?,courseId=?,email=?,phoneNumber=?,classroomId=?;";

    List<Student> students = new ArrayList<>();

    public StudentDAO() {
    }

    @Override
    public boolean insertStudent(Student student) throws SQLException {
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            preparedStatement.setString(1, student.getFirstname());
            preparedStatement.setString(2, student.getLastname());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setInt(5, student.getClassroomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                int classroomId = resultSet.getInt("classroomId");
                student = new Student(id, firstname, lastname, email, phoneNumber, classroomId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudents() {
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                int classroomId = resultSet.getInt("classroomId");
                students.add(new Student(id, firstname, lastname, email, phoneNumber, classroomId));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDelete;
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdate;
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, student.getFirstname());
            preparedStatement.setString(2, student.getLastname());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setInt(5, student.getClassroomId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public List<Student> selectStudentInClass(int classroomId) {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where classroomId = ?;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                students.add(new Student(id, firstname, lastname, email, phoneNumber, classroomId));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }
}
