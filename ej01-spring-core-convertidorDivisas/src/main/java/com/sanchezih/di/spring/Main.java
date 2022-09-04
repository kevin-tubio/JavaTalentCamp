package com.sanchezih.di.spring;

import com.sanchezih.di.spring.config.SpringConfig;
import com.sanchezih.di.spring.service.Converter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		double cantidad = 100;

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(SpringConfig.class);
		context.refresh();

		Converter c = (Converter) context.getBean("ARSToUSDConverter");
		System.out.println(c.convert(cantidad));

	}
}
