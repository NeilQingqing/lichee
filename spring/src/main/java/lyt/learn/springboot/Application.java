package lyt.learn.springboot;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
public class Application  extends WebMvcConfigurerAdapter{
	
	//方式一
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		/**
		 * 定义一个转换消息的对象 FastJsonHttpMessageConverter
		 * 添加 FastJsonConfig的配置项
		 * FastJsonConfig 添加到 FastJsonHttpMessageConverter
		 * FastJsonHttpMessageConverter 添加 到 converters
		 */
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig 	fastJsonConfig = new FastJsonConfig();
		
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		
		converters.add(fastJsonHttpMessageConverter);
		converters.add(responseBodyConverter());
	}

	/**
	 * 方式二
	 * 使用bean注入的方式
	 */
//	@Bean
//	public HttpMessageConverters  fastJsonHttpMessageConverter(){
//		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//		FastJsonConfig 	fastJsonConfig = new FastJsonConfig();
//		
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//		
//		HttpMessageConverter<?> httpMessageConverter = fastJsonHttpMessageConverter;
//        
//		return new HttpMessageConverters(httpMessageConverter);
//	}
	
	/**
	 * 解决中文乱码问题
	 */
	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
	    StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
	    return converter;
	}
	
	/**
	 * 在 main 方法中启动app, 不能再workspace中引入tomcat等server，否则会启动不了
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
	
	

}
