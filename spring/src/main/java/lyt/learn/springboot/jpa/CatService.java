package lyt.learn.springboot.jpa;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class CatService {

	@Resource
	private CatRepository catRepository; 
	
	@Resource
	private CustomRepository customRepository;
	
	@Resource
	private JdbcDao jdbcDao;
	
	
	@Transactional
	public void save(Cat cat){
		catRepository.save(cat);
	}
	
	@Transactional
	public void delete(Cat cat){
		catRepository.delete(cat);
	}
	
	public Iterable<Cat> getAll(){
		return catRepository.findAll();
	}
	
	public Cat findCatByCatName(String catName){
		return customRepository.findCatByCatName(catName);
	}
	
	public Cat getCatByCatName(String catName){
		return customRepository.getCatByCatName(catName);
	}
	
	public Cat selectByCatName(String catName){
		return jdbcDao.selectByCatName(catName);
	}
}
