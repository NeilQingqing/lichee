package study.java.foundation.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 定义一个拦截器。在调用目标方法时，CGLib会回调MethodInterceptor接口方法拦截，
 * 来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口。
 * 
 *  参数：Object为由CGLib动态生成的代理类实例，Method为上文中实体类所调用的被代理的方法引用，Object[]为参数值列表，MethodProxy为生成的代理类对方法的代理引用。
	返回：从代理实例的方法调用返回的值。
	其中，proxy.invokeSuper(obj,arg)：
	调用代理类实例上的proxy方法的父类方法（即实体类TargetObject中对应的方法）
 */
public class CGLibTargetInterceptor implements MethodInterceptor{  
  
    /** 
     * 重写方法拦截在方法前和方法后加入业务 
     * Object obj为目标对象 
     * Method method为目标方法 
     * Object[] params 为参数， 
     * MethodProxy proxy CGlib方法代理对象 
     */  
    public Object intercept(Object obj, Method method, Object[] params,  
            MethodProxy proxy) throws Throwable {  
        System.out.println("调用前");  
        Object result = proxy.invokeSuper(obj, params);  
        System.out.println(" 调用后"+result);  
        return result;  
    }  
  
  
}  
