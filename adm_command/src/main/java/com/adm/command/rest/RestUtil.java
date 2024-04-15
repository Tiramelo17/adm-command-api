package com.adm.command.rest;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtil {
	
	private final RestTemplate restTemplate;
	
	public RestUtil(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	
   public <T> List<T> getRestTemplate(String url, Class<T> classe ) throws Exception{
	   
	   
	   ResponseEntity<List<T>> response;
	try {
		response = restTemplate.exchange(
				   url,
		           HttpMethod.GET,
		           null,
		           new ParameterizedTypeReference<List<T>>() {}
		   );
	} catch (ResourceAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception("Erro ao consultar API");
	}
	   
	   if(!response.getStatusCode().equals(HttpStatus.OK)) {
		   throw new Exception("Erro ao consultar API");
	   }
	   
	   return response.getBody();
   }
   
   public List<Object> postRestTemplate(String url) throws Exception{
	   ResponseEntity<List<Object>> response= restTemplate.exchange(
			   url,
			   HttpMethod.POST,
			   null,
			   new ParameterizedTypeReference<List<Object>>() {}
			   );
	   
	   if(!response.getStatusCode().equals(HttpStatus.OK)) {
		   throw new Exception("Erro ao consultar API");
	   }
	   
	   return response.getBody();
   }

}
