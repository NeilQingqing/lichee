package study.java.foundation.proto;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

	@Remote(value = "saveUser")
	public void saveUser(User user){
		
	}
}
