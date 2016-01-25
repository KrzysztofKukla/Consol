package pl.kukla.krzys.consol.web;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.kukla.krzys.consol.model.Account;
import pl.kukla.krzys.consol.service.AccountService;

/**
 * This controller handles registartion's requests.
 */
@Controller
@RequestMapping(value="/")
public class RegistrationController {
	private final Logger log = Logger.getLogger(this.getClass());
	
	private static final String USER_HAS_BEEN_REGISTERED = "User has been registered";
	private static final String ERRORS = "Cannot register new user. Please try again";
	private static final String REGISTRATION = "registration";
	private static final String REGISTRATION_OK = "registrationOk";
	
	@Autowired
	private AccountService accountService;
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setAllowedFields(new String[]{"login", "password"});
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String registration(Model model) {
		log.info("Registration");
		model.addAttribute("account", new Account());
		return REGISTRATION;
	}
	
	//In real application default error codes should be replaced
	//but to simplify I omitted that
	@RequestMapping(value="", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("account") Account account, BindingResult result){
		if (!result.hasErrors() && accountService.register(account, result)){
			log.info(USER_HAS_BEEN_REGISTERED);
			return "redirect:"+REGISTRATION_OK;
		}
		log.error(ERRORS);
		return REGISTRATION;
	}
	
	@RequestMapping(value="/checkUser/{login}", produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@ResponseBody
	public boolean checkUser(@PathVariable String login){
		log.info("Checking user exist");
		return accountService.isFreeLogin(login);
	}
	
	@RequestMapping(value="/registrationOk", method = RequestMethod.GET)
	public String registrationOk(){
		return REGISTRATION_OK;
	}
	
}
