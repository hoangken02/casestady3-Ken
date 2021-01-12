package dao.classroomService;

import model.Classroom;

import java.sql.SQLException;
import java.util.List;

public interface IClassroomDAO {
    public boolean insertClassroom(Classroom classroom) throws SQLException;
    public Classroom selectClassroom(int id);
    public List<Classroom> selectAllClassrooms();
    public boolean deleteClassroom(int id) throws SQLException;
    public boolean updateClassroom(Classroom classroom) throws SQLException;
}
