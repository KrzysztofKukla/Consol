package pl.kukla.krzys.consol.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import pl.kukla.krzys.consol.dao.AccountDao;
import pl.kukla.krzys.consol.model.Account;
import pl.kukla.krzys.consol.service.AccountService;


@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public boolean isFreeLogin(String login) {
		return !accountDao.exist(login);
	}
	
	@Transactional(readOnly = false)
	@Override
	public boolean register(Account form, BindingResult result) {
		if (accountDao.exist(form.getLogin())){
			result.rejectValue("login",null, 
					messageSource.getMessage("account.form.unique_login",null, null));
			return false;
		}
		if (!(form.getPassword().equals(form.getConfirmPassword()))){
			result.rejectValue("confirmPassword",null, 
					messageSource.getMessage("account.form.same_passwords",null, null));
			return false;
		}
		Account account = new Account();
		account.setLogin(form.getLogin());
		//In real application password should be encrypted in SHA or something else
		account.setPassword(form.getPassword());
		return accountDao.save(account)!=null;
	}
	
}
