package poly.manhnd.webapp.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import poly.manhnd.webapp.entities.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		if (user.getUsername().isEmpty()) {
			errors.rejectValue("username", "message.error.user.username.empty");
		} else if (user.getUsername().length() < 5) {
			errors.rejectValue("username", "message.error.user.username.too_short");
		} else if (user.getUsername().length() > 32) {
			errors.rejectValue("username", "message.error.user.username.too_long");
		}

		if (user.getPassword().isEmpty()) {
			errors.rejectValue("password", "message.error.user.password.empty");
		} else if (user.getPassword().length() < 6) {
			errors.rejectValue("password", "message.error.user.password.too_short");
		} else if (user.getPassword().length() > 32) {
			errors.rejectValue("password", "message.error.user.password.too_long");
		}

	}

}
