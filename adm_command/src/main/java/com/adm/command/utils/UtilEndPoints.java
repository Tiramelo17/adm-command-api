package com.adm.command.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class UtilEndPoints {

	public static String FORNECEDORAPI;

	public static String getFORNECEDORAPI() {
		return FORNECEDORAPI;
	}

	@Value("${rest.api.FORNECEDORAPI}")
	public void setFORNECEDORAPI(String fornecedorApi) {
        FORNECEDORAPI = fornecedorApi;
    }

	
	

}
