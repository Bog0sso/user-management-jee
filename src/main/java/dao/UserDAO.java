package dao;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.User;

public class UserDAO {
	/*
	static ArrayList<User> users = new ArrayList<User>();
	static int yieldId = 0;
	 */
	//CONNECTION ATTRIBUTES
	Connection connexion;
	Statement statement;
	PreparedStatement preparedStatement;
	//

	/*static {
		users.add(new User(1,"Moussa", "SAMBE","Elpepe","passer"));
		users.add(new User("Abdoulaye", "SAMBE","Bog0sso","passer"));
	}*/
	public UserDAO(){
		try {
			Class.forName("org.postgresql.Driver");
			this.connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users_jee_db","user_manager","user_manager");
			this.statement = connexion.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void addUser(User user){
		/* IN MEMORY STORING
		user.setId(yieldId++);
		users.add(user);
		IN MEMORY STORING*/

		// POSTGRES STORING
		try {
			this.preparedStatement = this.connexion.prepareStatement("INSERT INTO users (lastName, name, login, password) VALUES (?, ?, ?, ?)");
			this.preparedStatement.setString(1, user.getLastName());
			this.preparedStatement.setString(2, user.getName());
			this.preparedStatement.setString(3, user.getLogin());
			this.preparedStatement.setString(4, user.getPassword());
			this.preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// POSTGRES STORING
		
	}
//	private ArrayList<User> listUser() {
//		return users;
//	}
	public ArrayList<User> listUser() {
		/* IN MEMORY STORING
		return users;
		*/
		User user;
		ArrayList<User> users = new ArrayList<>();
		try {
		ResultSet results = this.statement.executeQuery("SELECT * FROM users");
		while(results.next()) {
			user = new User();
		
			user.setId(results.getInt("userId"));
			
			if(results.getString("login") != null) {
				user.setLogin(results.getString("login"));
			}
			
			if(results.getString("password") != null) {
				user.setPassword(results.getString("password"));
			}
			if(results.getString("lastName") != null) {
				user.setLastName(results.getString("lastName"));
			}
			if(results.getString("name") != null) {
				user.setName(results.getString("name"));
			}
			users.add(user);
		}
		return users;
		}catch(Exception e) {
			System.err.print(e);
		}
		return null;

	}
	public void deleteUser(int userId) {
		
		/* IN MEMORY STORING
		 * 
		users.remove(getUser(userId));
		*/
		try {
		
			PreparedStatement pres = this.connexion.prepareStatement("DELETE FROM users WHERE userId = ?;");
			pres.setInt(1, userId);
			pres.executeUpdate();	
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	public User getUser(int userId) {
		/*
		 * IN MEMORY 
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			if(userId == user.getId())
				return user;
		}
		return null;
		*/
		User user = new User();
		try {
			ResultSet result = this.statement.executeQuery("SELECT * FROM users WHERE userId="+userId+";");
			while(result.next()) {
				user.setId(userId);
	
				if(result.getString("login") != null) {
					user.setLogin(result.getString("login"));
				}
				
				if(result.getString("password") != null) {
					user.setPassword(result.getString("password"));
				}
				
				if(result.getString("lastName") != null) {
					user.setLastName(result.getString("lastName"));
				}
				
				if(result.getString("name") != null) {
					user.setName(result.getString("name"));
				}
			}
			return user;
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void updateUser(int userId, String name, String lastName, String login, String password) {
		/*
		User user = getUser(id);
		if(user != null) {
			user.setLastName(lastName);
			user.setName(name);
			user.setLogin(login);
			user.setPassword(password);
		}
		*/
		try {
		
			this.preparedStatement = this.connexion.prepareStatement("UPDATE users SET lastName=?, name=?, login=?, password=? WHERE userId=?");
			this.preparedStatement.setString(1, lastName);
			this.preparedStatement.setString(2, name);
			this.preparedStatement.setString(3, login);
			this.preparedStatement.setString(4, password);
			this.preparedStatement.setInt(5, userId);	
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	

	
}
