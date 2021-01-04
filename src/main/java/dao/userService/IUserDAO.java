package dao.userService;

import model.User;

import java.util.List;

public interface IUserDAO {
    public List<User> selectAllUser();

}
