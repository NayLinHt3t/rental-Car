package user;

public class UserService {
    private UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public User createUser(User user) {
        User newUser = userDAO.addUser(user);
        return newUser;
    }
    public User[] getAllUsers() {
        return userDAO.getAllUsers();
    }
    public User getUserById(String id) {
        return userDAO.getUserById(id);
    }
}
