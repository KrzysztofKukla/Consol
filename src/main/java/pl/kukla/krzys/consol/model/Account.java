package pl.kukla.krzys.consol.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	private static final String ALPHANUMERIC = "^[A-Za-z0-9]+$";
	private static final String ONE_NUMERIC_UPPER_LOWWER = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$";
	
	@NotEmpty
	@Size(min=6, max=100)
	@Pattern(regexp=ALPHANUMERIC)
	private String login;
	@NotEmpty
	@Size(min=8, max=100)
	@Pattern(regexp=ONE_NUMERIC_UPPER_LOWWER)
	private String password;
	@Transient
	private String confirmPassword;
	
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
	
}
