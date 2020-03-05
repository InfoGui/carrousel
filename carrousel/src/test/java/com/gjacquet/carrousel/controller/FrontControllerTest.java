package com.gjacquet.carrousel.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FrontControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Tag("dao")
	@DisplayName("Appel de la page d'accueil")
	@ParameterizedTest
	@ValueSource(strings = { "", "/repertoire1" })
	public void callIndex(String repertoire) {
		ResponseEntity<String> response;
		try {
			response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/" + repertoire).toString(),
					String.class);
			assertEquals(HttpStatus.OK, response.getStatusCode());
		} catch (RestClientException | MalformedURLException e) {
			fail("La page d'accueil ne répond pas.");
		}
	}

}
