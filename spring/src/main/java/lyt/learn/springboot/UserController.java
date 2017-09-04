package lyt.learn.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value="/getUser")
	public String getUser(){
		return "xm";
	}
}
