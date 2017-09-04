package lyt.learn.springboot.jpa;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 使用  @Repository 标注这是一个持久化操作对象
 *
 */
@Repository
public class JdbcDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public Cat selectByCatName(String catName){
		/**
		 * 1.定义一个Sql语句
		 * 2.定义一个RowMapper
		 * 3.执行查询
		 */
		
		String sql = "select * from cat where cat_name = ?";
		RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<>(Cat.class);
		Cat cat = (Cat) jdbcTemplate.queryForObject(sql, new Object[]{catName},rowMapper);
		return cat;
		
	}
}
