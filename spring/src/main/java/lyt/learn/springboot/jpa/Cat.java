package lyt.learn.springboot.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 1.使用 @Entity 进行实体的持久化操作，当JPA检测到 @Entity 注解的时候会在数据库创建对象的表结构；
 * 2.使用 @Id 指定主键 
 *
 */
@Entity
public class Cat {

	/**
	 * 使用  @GeneratedValue(strategy=GenerationType.AUTO) 指定主键生成策略
	 * Mysql默认自增长
	 */
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String catName;
	private int catAge;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public int getCatAge() {
		return catAge;
	}
	public void setCatAge(int catAge) {
		this.catAge = catAge;
	}
	
	
	
}
