package lyt.learn.springboot;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController == (@Controller 和 @ResponseBody)
 *
 */
@RestController
public class HelloController {

	/**
	 * http://127.0.0.1:8080/hello
	 */
	@RequestMapping(value="/hello")
	public String hello1(){
		return "hello1-2017";
	}
	
	/**
	 * 返回的对象直接被转为Json格式的数据，Spring boot使用的是Jackson
	 * http://127.0.0.1:8080/demo
	 * 
	 * {"id":1,"name":"Xiaoming"}
	 */
	@RequestMapping(value="/demo")
	public JsonFormatDemo demo(){
		JsonFormatDemo demo = new JsonFormatDemo();
		demo.setId(1);
		demo.setName("Ximi");
		return demo;
	}
	
	/**
	 * 自定义json的输出
	 * http://127.0.0.1:8080/demoCus
	 * 
	 * { "createDate":"2017-09-04 18:35", "id":1, "name":"Xiaoming" }
	 */
	@RequestMapping(value="/demoCus" ,produces="text/plain;charset=UTF-8")
	public JsonFormatDemo demoCus(){
		JsonFormatDemo demo = new JsonFormatDemo();
		demo.setId(1);
		demo.setName("Xiaoming");
		demo.setCreateDate(new Date());
		demo.setRemark("这是备注信息！");//中文会乱码
		return demo;
	}
	
	
}
