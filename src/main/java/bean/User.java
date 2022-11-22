/**
 * 
 */
package bean;

/**
 * @author bog0sso
 *
 */
public class User {
	private int id;
	private String name, lastName,login,password;
	public User() {}
	public User(String name, String lastName, String login, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}
	public User(int id, String name, String lastName, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public  String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
