package com.sprintmanager.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sprintmanager.app.dataobjects.Sprint;

/**
 * @author nakulsargur
 *
 */
@Service
public class SprintServiceImpl implements SprintService {

	private List<Sprint> sprintList =  new ArrayList<Sprint>(Arrays.asList(new Sprint(1, "17.1.1", "17.1", new Date(), new Date()),
			new Sprint(2, "17.1.2", "17.1", new Date(), new Date()),
			new Sprint(3, "17.1.3", "17.1", new Date(), new Date())));

	@Override
	public List<Sprint> getSprintList() {
		return sprintList;
	}

	@Override
	public Sprint getSprint(String sprintNumber) {
		return sprintList.stream().filter(sprint -> sprint.getSprintNumber().equals(sprintNumber)).findFirst().get();
	}

	@Override
	public void addSprint(Sprint sprint) {
		sprintList.add(sprint);
	}

	@Override
	public void updateSprint(String sprintNumber, Sprint sprintToUpdate) {
		for (int i = 0; i < sprintList.size(); i++) {
			if (sprintList.get(i).getSprintNumber().equals(sprintNumber)) {
				sprintList.set(i, sprintToUpdate);
				break;
			}
		}
	}

	@Override
	public void deleteSprint(String sprintNumber) {
		sprintList.removeIf(sprint -> sprint.getSprintNumber().equals(sprintNumber));
	}
}
