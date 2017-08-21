package com.sprintmanager.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sprintmanager.app.dataobjects.Sprint;

/**
 * @author nakulsargur
 *
 */
@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${datasource.endpointurl}")
	private String endPointUrl;

	public List<Sprint> reliable() {
		System.out.println("Inside fallback method");
		return new ArrayList<Sprint>();
	}

	@HystrixCommand(fallbackMethod="reliable")
	@Override
	public List<Sprint> getSprintList() throws Exception {
		List<Sprint> sprintList;
		String uri = "http://" + endPointUrl + "/sprints";
		ObjectMapper objMap = new ObjectMapper();
		String jsonResponse = restTemplate.getForObject(uri, String.class);
		sprintList = objMap.readValue(jsonResponse, new TypeReference<List<Sprint>>(){});

		return sprintList;
	}

	@Override
	public Sprint getSprint(String sprintNumber) throws Exception {
		Sprint sprint = null;
		String uri = "http://" + endPointUrl + "/sprints/1";
		ObjectMapper objMap = new ObjectMapper();
		String jsonResponse = restTemplate.getForObject(uri, String.class);
		sprint = objMap.readValue(jsonResponse, new TypeReference<Sprint>(){});

		return sprint;
	}

	@Override
	public void addSprint(Sprint sprint) {
		String uri = "http://" + endPointUrl + "/sprints";
		HttpEntity<Sprint> request = new HttpEntity<Sprint>(sprint);
		sprint = restTemplate.postForObject(uri, request, Sprint.class);
	}

	@Override
	public void updateSprint(String sprintNumber, Sprint sprintToUpdate) {
		String uri = "http://" + endPointUrl + "/sprints/" + sprintNumber;
		restTemplate.put(uri, sprintToUpdate);
	}

	@Override
	public void deleteSprint(String sprintNumber) {
		String uri = "http://" + endPointUrl + "/sprints/" + sprintNumber;
		restTemplate.delete(uri);
	}
}