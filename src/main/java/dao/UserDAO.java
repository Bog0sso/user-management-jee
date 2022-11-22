package dao;

import java.util.ArrayList;
import java.util.Iterator;

import bean.User;

public class UserDAO {
	static ArrayList<User> users = new ArrayList<User>();
	static int yieldId = 2;
	
	static {
		users.add(new User(1,"Moussa", "SAMBE","Elpepe","passer"));
//		users.add(new User("Abdoulaye", "SAMBE","Bog0sso","passer"));
	}
	
	public static void addUser(User user){
		user.setId(yieldId++);
		users.add(user);
	}
//	private ArrayList<User> listUser() {
//		return users;
//	}
	public static ArrayList<User> listUser() {
		return users;
	}
	public static void deleteUser(int userId) {
		users.remove(getUser(userId));
	}
	public static User getUser(int userId) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			if(userId == user.getId())
				return user;
		}
		return null;
	}
	public static void updateUser(int id, String name, String lastName, String login, String password) {
		User user = getUser(id);
		if(user != null) {
			user.setLastName(lastName);
			user.setName(name);
			user.setLogin(login);
			user.setPassword(password);
		}
	}
	

	
}
