package user;
public class UserDAO {
    private static User[] users = new User[10];
    private static int count = 0;

    public  User addUser(User user) {
        if(count == 10){
            throw new RuntimeException("Maximum number of users reached.");
        }
        users[count] = user;
        count++;
        return user;
    }
    public  User[] getAllUsers() {  
        User[] result = new User[count];
        System.arraycopy(users, 0, result, 0, count);
        return result;
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
