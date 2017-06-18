package com.sprintmanager.app;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Basic integration tests for service demo application.
 * 
 * @author nakulsargur
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SprintManagerApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class SprintManagerAppTest {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	@SuppressWarnings("rawtypes")
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/sprints", Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	@SuppressWarnings("rawtypes")
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/info", Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
