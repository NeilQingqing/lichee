package study.java.foundation.proxy;


/**
 * 静态代理
 * 
 * 重复代码太多，不利于维护
 */
public class UserDAOProxy implements UserDAO {  
    private UserDAO userDAO;  
      
    public UserDAOProxy(UserDAO userDAO){  
        this.userDAO = userDAO;  
    }  
  
    public boolean add(User user) {  
        this.beginTransaction();  
        boolean result = userDAO.add(user);  
        this.endTransaction();  
        return result;  
    }  
  
    public boolean delete(Integer id) {  
        this.beginTransaction();  
        boolean result = userDAO.delete(id);  
        this.endTransaction();  
        return result;  
    }  
  
    public boolean modify(User user) {  
        this.beginTransaction();  
        boolean result = userDAO.modify(user);  
        this.endTransaction();  
        return result;  
    }  
  
    public Object query(Integer id) {  
        this.beginTransaction();  
        Object obj = userDAO.query(id);  
        this.endTransaction();  
        return obj;  
    }  
      
    private void beginTransaction(){  
        System.out.println("Begin transaction");  
    }  
      
    private void endTransaction(){  
        System.out.println("End transaction");  
    } 

}
