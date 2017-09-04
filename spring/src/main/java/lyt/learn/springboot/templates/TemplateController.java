package lyt.learn.springboot.templates;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/templates")
public class TemplateController {

	// http://127.0.0.1:8080/templates/thymeleaf
	@RequestMapping(value="/thymeleaf2")
	public String thymeleafHello(Map<String,Object> result){
//		ModelAndView modelAndView = new ModelAndView("thymeleaf") ;
//		return modelAndView;
		result.put("name", "thymeleaf");
		// ||
		return "thymeleaf"; //返回值值就是 templates 的名称
	}
	
	@RequestMapping(value="/freemarker1")
	public String freemarkerHello(Map<String,Object> result){
//		ModelAndView modelAndView = new ModelAndView("thymeleaf") ;
//		return modelAndView;
		result.put("name", "freemarker");
		// ||
		return "freemarker"; //返回值值就是 templates 的名称
	}
	
	
	@RequestMapping(value="/jsp1")
	public String jspHello(Map<String,Object> result){
//		ModelAndView modelAndView = new ModelAndView("thymeleaf") ;
//		return modelAndView;
		result.put("name", "JSP");
		// ||
		return "index"; //返回值值就是 templates 的名称
	}
	
}
