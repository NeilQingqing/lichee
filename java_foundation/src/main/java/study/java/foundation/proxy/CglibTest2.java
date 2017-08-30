package study.java.foundation.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class CglibTest2 {
	public static void main(String args[]) {  
        Enhancer enhancer =new Enhancer();  
        enhancer.setSuperclass(CGLibTargetObject.class);  
        CallbackFilter callbackFilter = new CGLibTargetMethodCallbackFilter();  
          
        /** 
         * (1)callback1：方法拦截器 
           (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。 
           (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。 
         */  
        Callback noopCb=NoOp.INSTANCE;  
        Callback callback1=new CGLibTargetInterceptor();  
        Callback fixedValue=new CGLibTargetResultFixed();  
        Callback[] cbarray=new Callback[]{callback1,noopCb,fixedValue};  
        //enhancer.setCallback(new TargetInterceptor());  
        enhancer.setCallbacks(cbarray);  
        enhancer.setCallbackFilter(callbackFilter);  
        CGLibTargetObject targetObject2=(CGLibTargetObject)enhancer.create();  
        System.out.println(targetObject2);  
        System.out.println(targetObject2.method1("mmm1"));  
        System.out.println(targetObject2.method2(100));  
        System.out.println(targetObject2.method3(100));  
        System.out.println(targetObject2.method3(200));  
    }  
}
