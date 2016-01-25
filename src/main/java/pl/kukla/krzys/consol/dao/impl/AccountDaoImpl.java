package pl.kukla.krzys.consol.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.kukla.krzys.consol.dao.AccountDao;
import pl.kukla.krzys.consol.model.Account;

/**
 * Dao implementation for Account entity
 * 
 * @author Krzysztof
 *
 */
@Repository
public class AccountDaoImpl extends AbstractDao<Account> implements AccountDao{

	@Override
	public boolean exist(String login) {
		return criteria().add(Restrictions.eq("login", login)).uniqueResult()!=null ? true : false;
	}


}
