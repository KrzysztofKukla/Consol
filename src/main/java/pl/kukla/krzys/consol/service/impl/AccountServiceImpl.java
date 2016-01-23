package pl.kukla.krzys.consol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kukla.krzys.consol.dao.AccountDao;
import pl.kukla.krzys.consol.model.Account;
import pl.kukla.krzys.consol.service.AccountService;


@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public boolean isFreeLogin(String login) {
		return !accountDao.exist(login);
	}
	
	@Transactional(readOnly = false)
	@Override
	public boolean registration(String login, String password) {
		if (accountDao.exist(login)){
			// throw myException
			return false;
		}
		Account account = new Account();
		account.setLogin(login);
		account.setPassword(password);
		accountDao.save(account);
		return true;
	}
	
}
