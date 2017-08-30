package study.java.foundation.proxy;

public class UserDAOImpl implements UserDAO {  
    public boolean add(User user) {  
        System.out.println("Add a new user");  
        return true;  
    }  
  
    public boolean delete(Integer id) {  
        System.out.println("Delete a new user");  
        return true;  
    }  
  
    public boolean modify(User user) {  
        System.out.println("Modify a new user");  
        return true;  
    }  
  
    public Object query(Integer id) {  
        System.out.println("Query a new user");  
        return new User();  
    }  
}
