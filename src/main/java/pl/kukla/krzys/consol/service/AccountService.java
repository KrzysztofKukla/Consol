package pl.kukla.krzys.consol.service;

/**
 * Service for Account
 * 
 * @author Krzysztof
 *
 */
public interface AccountService {
	
	/**
	 * This method checks if given login is free and returns response
	 * 
	 * @param login
	 * @return true of false
	 */
	boolean isFreeLogin(String login);
	/**
	 * Registration new user
	 * <br/> This method returns true if registration is successful or false if not
	 * 
	 * @param login
	 * @param password
	 * 
	 * return true or false
	 */
	boolean registration(String login, String password);
}
