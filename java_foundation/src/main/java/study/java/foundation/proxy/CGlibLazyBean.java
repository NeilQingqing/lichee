package study.java.foundation.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CGlibLazyBean {
	  private String name;  
	    private int age;  
	    private CGlibPropertyBean CGlibPropertyBean;  
	    private CGlibPropertyBean CGlibPropertyBeanDispatcher;  
	  
	    public CGlibLazyBean(String name, int age) {  
	        System.out.println("lazy bean init");  
	        this.name = name;  
	        this.age = age;  
	        this.CGlibPropertyBean = createCGlibPropertyBean();  
	        this.CGlibPropertyBeanDispatcher = createCGlibPropertyBeanDispatcher();  
	    }  
	  
	      
	  
	    /** 
	     * 只第一次懒加载 
	     * @return 
	     */  
	    private CGlibPropertyBean createCGlibPropertyBean() {  
	        /** 
	         * 使用cglib进行懒加载 对需要延迟加载的对象添加代理，在获取该对象属性时先通过代理类回调方法进行对象初始化。 
	         * 在不需要加载该对象时，只要不去获取该对象内属性，该对象就不会被初始化了（在CGLib的实现中只要去访问该对象内属性的getter方法， 
	         * 就会自动触发代理类回调）。 
	         */  
	        Enhancer enhancer = new Enhancer();  
	        enhancer.setSuperclass(CGlibPropertyBean.class);  
	        CGlibPropertyBean pb = (CGlibPropertyBean) Enhancer.create(CGlibPropertyBean.class,  
	                new CGlibConcreteClassLazyLoader());  
	        return pb;  
	    }  
	    /** 
	     * 每次都懒加载 
	     * @return 
	     */  
	    private CGlibPropertyBean createCGlibPropertyBeanDispatcher() {  
	        Enhancer enhancer = new Enhancer();  
	        enhancer.setSuperclass(CGlibPropertyBean.class);  
	        CGlibPropertyBean pb = (CGlibPropertyBean) Enhancer.create(CGlibPropertyBean.class,  
	                new CGlibConcreteClassDispatcher());  
	        return pb;  
	    }  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    public int getAge() {  
	        return age;  
	    }  
	  
	    public void setAge(int age) {  
	        this.age = age;  
	    }  
	  
	    public CGlibPropertyBean getCGlibPropertyBean() {  
	        return CGlibPropertyBean;  
	    }  
	  
	    public void setCGlibPropertyBean(CGlibPropertyBean CGlibPropertyBean) {  
	        this.CGlibPropertyBean = CGlibPropertyBean;  
	    }  
	  
	    public CGlibPropertyBean getCGlibPropertyBeanDispatcher() {  
	        return CGlibPropertyBeanDispatcher;  
	    }  
	  
	    public void setCGlibPropertyBeanDispatcher(CGlibPropertyBean CGlibPropertyBeanDispatcher) {  
	        this.CGlibPropertyBeanDispatcher = CGlibPropertyBeanDispatcher;  
	    }  
	  
	    @Override  
	    public String toString() {  
	        return "CGlibLazyBean [name=" + name + ", age=" + age + ", CGlibPropertyBean="  
	                + CGlibPropertyBean + "]";  
	    } 
}
