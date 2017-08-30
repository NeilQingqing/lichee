package study.java.foundation.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理
 * 
 * 如果想要使用动态代理，目标类必须是一个接口实现类，由于UserDAOImpl是一个接口实现类，
 * 满足使用Java动态代理的条件，我们可以使用Java动态代理避免出现太多重复性代码的问题。
 * 
 * 对于非接口实现类，CGlib可以作为动态代理一个很好的补充，Spring AOP针对非接口实现类使用CGlib实现
 */
public class CGlibTransactionHandler implements InvocationHandler {  
    private UserDAO userDAO;  
      
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        this.beginTransaction();  
        Object obj =  method.invoke(userDAO, args);  
        this.endTransaction();  
        return obj;  
    }  
      
    public UserDAO createProxy(UserDAO userDAO){  
        this.userDAO = userDAO;  
        return (UserDAO)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),   
                userDAO.getClass().getInterfaces(), this);  
    }  
      
    private void beginTransaction(){  
        System.out.println("Begin transaction");  
    }  
      
    private void endTransaction(){  
        System.out.println("End transaction");  
    }  
}
