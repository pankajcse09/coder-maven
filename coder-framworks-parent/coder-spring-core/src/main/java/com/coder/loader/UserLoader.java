package com.coder.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coder.bean.UserDetails;

public class UserLoader {
	private static Logger logger = LoggerFactory.getLogger(UserLoader.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
		UserDetails userDetails = (UserDetails) context.getBean("userDetails");
		new UserLoader().getUserDetails(userDetails);
		System.out.println(userDetails.getName());
		((ConfigurableApplicationContext) context).close();
		
		/**
		 * Spring Manual: 3.6.1.6 Shutting down the Spring IoC container
		 * gracefully in non-web applications
		 **/
		((AbstractApplicationContext) context).registerShutdownHook();
	}

	private void getUserDetails(UserDetails userDetails) {
		logger.debug("UserLoader : getUserDetails : Started");
		userDetails.setName("Pankaj Bharti");
		logger.debug("UserLoader : getUserDetails : Ended");
	}
}
