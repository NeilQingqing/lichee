package study.java.foundation.proxy;

import net.sf.cglib.proxy.Dispatcher;

public class CGlibConcreteClassDispatcher implements Dispatcher{  
  
    public Object loadObject() throws Exception {  
        System.out.println("before Dispatcher...");  
        CGlibPropertyBean propertyBean = new CGlibPropertyBean();  
        propertyBean.setKey("xxx");  
        propertyBean.setValue(new CGLibTargetObject());  
        System.out.println("after Dispatcher...");  
        return propertyBean;  
    }  
}
