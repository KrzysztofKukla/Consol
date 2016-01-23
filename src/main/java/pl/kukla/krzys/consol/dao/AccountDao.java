package pl.kukla.krzys.consol.dao;

import org.springframework.data.repository.CrudRepository;

import pl.kukla.krzys.consol.model.Account;

/**
 * DAO interface for Account entity
 *  
 * @author Krzysztof
 *
 */
public interface AccountDao extends CrudRepository<Account, Long>{
	/**
	 * This method checks if given login exist
	 * 
	 * @param login
	 * @return true or false
	 */
	boolean exist(String login);
}
