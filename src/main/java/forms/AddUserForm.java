package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.User;
import dao.UserDAO;

public class AddUserForm {
	private static final String INPUT_NAME 					= "name";
	private static final String INPUT_LASTNAME 				= "lastName";
	private static final String INPUT_LOGIN 				= "login";
	private static final String INPUT_PASSWORD				= "password";
	private static final String INPUT_PASSWORD_CONFIRMATION = "passwordConfirmation";
	
	//HELPING ATTRIBUTES
	private HttpServletRequest request;
	private Map<String, String> errors;
	private User user;
	private boolean status;
	private String statusMessage;
	private static final String MESSAGE_ADD_USER_FAILED =  "Echec de l'ajout d'un nouvel utilisateur";
	private static final String MESSAGE_ADD_USER_SUCCEEDED = "L'ajout de l'utilisateur a été effectué avec succès";
	private static final String MESSAGE_EMPTY_FIELD_ERROR = "Vous devez renseigner ce champ";
	private static final String MESSAGE_DIFFERENT_PASSWORD_ERROR = "Les mots de passe fournis ne sont pas similaires";
	private UserDAO userDAO = new UserDAO();
	public AddUserForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = MESSAGE_ADD_USER_FAILED;
		this.errors = new HashMap<String, String>();
	}
	public boolean ajouter() {
		String name = this.getParameter(INPUT_NAME);
		String lastName = this.getParameter(INPUT_LASTNAME);
		String login = this.getParameter(INPUT_LOGIN);
		String password = this.getParameter(INPUT_PASSWORD);
		this.user = new User(name, lastName, login, password);
		this.validateFormInputs(INPUT_NAME, INPUT_LASTNAME, INPUT_LOGIN, INPUT_PASSWORD, INPUT_PASSWORD_CONFIRMATION);
		this.validatePasswords();
		
		if(this.errors.isEmpty()) {
			userDAO.addUser(user);
			this.status = true;
			this.statusMessage = MESSAGE_ADD_USER_SUCCEEDED;
		}
		return this.status;
	}
	public String getParameter(String parameter) {
		String value = this.request.getParameter(parameter);
		return ( value == null || value.trim().isEmpty() ) ? null : value.trim();
	}
	public void validateFormInputs(String ...inputs) {
		for(String input: inputs) {
			if(this.getParameter(input) == null) {
				errors.put(input, MESSAGE_EMPTY_FIELD_ERROR);
			}
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void validatePasswords() {
		String password = this.getParameter(INPUT_PASSWORD);
		String passwordConfirmation = this.getParameter(INPUT_PASSWORD_CONFIRMATION);
		if( password != null && !password.equals(passwordConfirmation) ) {
			errors.put(INPUT_PASSWORD, MESSAGE_DIFFERENT_PASSWORD_ERROR);
			errors.put(INPUT_PASSWORD_CONFIRMATION, MESSAGE_DIFFERENT_PASSWORD_ERROR);
		}
	}

	public User getUser() {
		return user;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}
}
