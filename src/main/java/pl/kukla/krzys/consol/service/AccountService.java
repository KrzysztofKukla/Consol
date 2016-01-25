package pl.kukla.krzys.consol.service;

import org.springframework.validation.BindingResult;

import pl.kukla.krzys.consol.model.Account;

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
	 * @param account
	 * @param result
	 * 
	 * return true or false
	 */
	boolean register(Account account, BindingResult result);
}
