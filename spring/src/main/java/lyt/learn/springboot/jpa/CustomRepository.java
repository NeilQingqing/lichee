package lyt.learn.springboot.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface CustomRepository extends Repository<Cat,Integer>,PagingAndSortingRepository<Cat, Integer>{
	/**
	 * 查询方法以 get | find  | query  | read
	 * 设计条件查询时，条件的属性用条件关键字连接，要注意的是条件属性以首字母大写
	 */
	//根据catName进行查询
	public Cat findCatByCatName(String catName);
	/**
	 * Hibernate ---> HQL
	 * JPQL <===> HQL
	 */
	@Query("from Cat where catName=:catName")
	public Cat getCatByCatName(@Param("catName")String catName);
	
}
