package splitwiseDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> users;
    public UserController(){
    	users=new ArrayList<>();
    }
    public void addUser(User user) {
    	users.add(user);
    }
    public User retriveUser(int userId) {
    	for(User user: users) {
    		if(user.userId==userId) {
    			return user;
    		}
    	}
    	return null;
    }
    public List<User> retriveAllUsers(){
    	return users;
    }
}
