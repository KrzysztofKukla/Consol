package pl.kukla.krzys.consol.model;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Entity class for Account
 * 
 * @author Krzysztof
 *
 */
@Entity
@Table(name="account",
		indexes = { @Index(name = "login_index", columnList = "login", unique = true) }
	)
public class Account extends AbstractEntity{
//	@Size(min=6)
//	@Pattern(regexp="^[A-Za-z0-9]+$")
	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
