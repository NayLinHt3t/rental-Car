package user;
import java.util.List;
import java.util.ArrayList;
public class UserDAO {
    private static List<User> users = new ArrayList<>();
    private static int count = 0;

    public  User addUser(User user) {
        if(count == 10){
            throw new RuntimeException("Maximum number of users reached.");
        }
        users.add(user);
        count++;
        return user;
    }
    public  List<User> getAllUsers() {  
        return users;
    }
    public User getUserById(String id) {
        for (User user : users) {
            if (user != null && user.getId().toString().equals(id)) {
                return user;
            }
        }
        throw new RuntimeException("User with ID " + id + " not found.");
    }
    
}
