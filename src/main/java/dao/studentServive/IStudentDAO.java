package dao.studentServive;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    void insertStudent(Student student) throws SQLException;

    Student selectStudent(int id);

    List<Student> selectAllStudents();

    boolean deleteStudent(int id) throws SQLException;

    boolean updateStudent(Student student) throws SQLException;

    List<Student> selectStudentInClass(int classroomId);
}
