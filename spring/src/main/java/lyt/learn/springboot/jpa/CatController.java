package lyt.learn.springboot.jpa;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/cat")
public class CatController {

	@Resource
	private CatService catService;
	
	// http://127.0.0.1:8080/cat/save
	@RequestMapping(value="/save")
	public Object save(){
		Cat cat = new Cat();
		cat.setCatName("xiaoX");
		cat.setCatAge(8);
		//一次只能插入一条  第一条会插入为空
		Cat cat2 = new Cat();
		cat.setCatName("xiaoG");
		cat.setCatAge(3);
		
		catService.save(cat);
		catService.save(cat2);
		return "save ok." + cat;
	} 
	
	
	@RequestMapping(value="/getAll")
	public Object getAll(){
		return catService.getAll();
	}
	
	
	@RequestMapping(value="/delete")
	public String delete(){
		Cat cat = new Cat();
		cat.setCatName("xiaoM");
		cat.setCatAge(2);
		
		catService.delete(cat);
		
		return "delete ok.";
	}
	
	@RequestMapping(value="/findCatByCatName")
	public Cat findCatByCatName(){
		String catName = "xiaoM";
		return catService.findCatByCatName(catName);
	}
	//  http://127.0.0.1:8080/cat/getCatByCatName
	@RequestMapping(value="/getCatByCatName")
	public Cat getCatByCatName(){
		String catName = "xiaoM";
		return catService.getCatByCatName(catName);
	}
	
	/**
	 * http://127.0.0.1:8080/cat/selectByCatName?catName=xiaoM
	 */
	@RequestMapping(value="/selectByCatName")
	public Cat selectByCatName(String catName){
//		String catName = "xiaoM";
		return catService.selectByCatName(catName);
	}
}

