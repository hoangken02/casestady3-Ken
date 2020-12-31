package dao.studentServive;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentDAO implements IStudentDAO {

    public StudentDAO() {
    }

    @Override
    public void insertStudent(Student student) throws SQLException {

    }

    @Override
    public Student selectStudent(int id) {
        return null;
    }

    @Override
    public List<Student> selectAllStudents() {
        return null;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        return false;
    }
}
