package pl.kukla.krzys.consol.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.kukla.krzys.consol.model.Account;
import pl.kukla.krzys.consol.service.AccountService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/")
public class RegistrationController {
	
	private final Logger log = Logger.getLogger(this.getClass());
	private static final String JSON = "application/json; charset=utf-8";
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String registration(Model model) {
		log.info("Registration");
		model.addAttribute("account", new Account());
		return "registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(){
//		boolean registration = accountService.registration(login, password);
		return "registrationOk";
	}
	
	@RequestMapping(value="/checkUser/{login}", produces = JSON, method = RequestMethod.GET)
	@ResponseBody
	public boolean checkUser(@PathVariable String login){
		log.info("checkUserExist");
		return accountService.isFreeLogin(login);
	}
	
}
