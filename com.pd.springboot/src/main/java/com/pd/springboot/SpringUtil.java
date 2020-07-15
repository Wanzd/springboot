package com.pd.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		ctx = applicationContext;
	}

	public static ApplicationContext getContext() {
		return ctx;
	}

	public static <T> T getBean(String beanName, Class<T> className) {
		if (ctx == null) {
			return null;
		}
		try {
			return ctx.getBean(beanName, className);
		} catch (Exception e) {
			return null;
		}
	}
}
