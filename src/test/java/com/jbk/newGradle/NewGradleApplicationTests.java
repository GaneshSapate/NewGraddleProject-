package com.jbk.newGradle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class NewGradleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetAllEmployee() throws URISyntaxException {

		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/employee/allEmployee";
		URI uri=new URI(url);
		ResponseEntity response= restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());
	}

}
