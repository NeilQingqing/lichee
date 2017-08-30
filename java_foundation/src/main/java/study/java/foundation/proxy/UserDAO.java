package study.java.foundation.proxy;

public interface UserDAO {
	public boolean add(User user);

	public boolean delete(Integer id);

	public boolean modify(User user);

	public Object query(Integer id);
}
