package study.java.foundation.proto;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * ApplicationListener 这个类的onApplicationEvent方法会在spring容器初始化之后开始执行
 */

@Component
public class MediaInitialize implements ApplicationListener<ContextRefreshedEvent>,Ordered {

	public void onApplicationEvent(ContextRefreshedEvent event) {
		Map<String,Object> beanMap = event.getApplicationContext().getBeansWithAnnotation(Controller.class);
	    
		for(String key:beanMap.keySet()){
			Object bean = beanMap.get(key);
			Method[] methods = bean.getClass().getDeclaredMethods();
			if(methods == null || methods.length == 0){
				continue;
			}	
			
			for(Method m : methods){
				if(m.isAnnotationPresent(Remote.class)){
					Remote remote = m.getAnnotation(Remote.class);
					String cmd = remote.value();
					
					MethodBean methodBean = new MethodBean();
					methodBean.setBean(bean);
					methodBean.setMethod(m);
					Media.methodBeans.put(cmd, methodBean);
					
					System.out.println("cmd ===== " + cmd);
				}
			}
		}
	}

	public int getOrder() {
		return 0;
	}

}
