package com.sprintmanager.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintmanager.app.dataobjects.Sprint;
import com.sprintmanager.app.service.SprintService;

@RestController
@RequestMapping("/sprints")
public class SprintController {

	@Autowired
	private SprintService sprintService;

	@GetMapping
	public List<Sprint> getSprints() throws Exception {
		return sprintService.getSprintList();
	}

	@GetMapping("/{sprintNumber:.+}")
	public Sprint getSprint(@PathVariable String sprintNumber) throws Exception {
		return sprintService.getSprint(sprintNumber);
	}

	@PostMapping
	public void addSprint(@RequestBody Sprint sprintToAdd) {
		// sprintService.addSprint(sprintToAdd);
	}

	@PutMapping(value = "/{sprintNumber:.+}")
	public void updateSprint(@PathVariable String sprintNumber, @RequestBody Sprint sprintToUpdate) {
		// sprintService.updateSprint(sprintNumber, sprintToUpdate);
	}

	@DeleteMapping(value = "/{sprintNumber:.+}")
	public void deleteSprint(@PathVariable String sprintNumber) {
		// sprintService.deleteSprint(sprintNumber);
	}
}