package com.sanchezih.di.spring.service.impl;

import com.sanchezih.di.spring.service.Converter;
import org.springframework.stereotype.Component;

@Component
public class ARSToGBPConverter implements Converter {
	
	private static final double RATE = 160.90;

	@Override
	public Double convert(Double cantidad) {
		return cantidad * RATE;
	}

}
