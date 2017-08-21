package com.sprintmanager.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprintmanager.app.dataobjects.Sprint;
import com.sprintmanager.app.service.SprintService;

@RestController
public class SprintController {

	@Autowired
	private SprintService sprintService;

	@RequestMapping("/sprints")
	public List<Sprint> getSprints() throws Exception {
		return sprintService.getSprintList();
	}

	@RequestMapping("/sprints/{sprintNumber:.+}")
	public Sprint getSprint(@PathVariable String sprintNumber) throws Exception {
		System.out.println("Inside controller value is " + sprintNumber);
		return sprintService.getSprint(sprintNumber);
	}

	@RequestMapping(value = "/sprints", method = RequestMethod.POST)
	public void addSprint(@RequestBody Sprint sprintToAdd) {
//		sprintService.addSprint(sprintToAdd);
	}
	
	@RequestMapping(value = "/sprints/{sprintNumber:.+}", method = RequestMethod.PUT)
	public void updateSprint(@PathVariable String sprintNumber, @RequestBody Sprint sprintToUpdate) {
//		sprintService.updateSprint(sprintNumber, sprintToUpdate);
	}

	@RequestMapping(value = "/sprints/{sprintNumber:.+}", method = RequestMethod.DELETE)
	public void deleteSprint(@PathVariable String sprintNumber) {
//		sprintService.deleteSprint(sprintNumber);
	}
}