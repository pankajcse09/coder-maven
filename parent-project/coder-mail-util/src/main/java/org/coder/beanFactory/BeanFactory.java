package org.coder.beanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {
	static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}
}