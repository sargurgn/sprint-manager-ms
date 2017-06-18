package com.sprintmanager.app.service;

import java.util.List;
import com.sprintmanager.app.dataobjects.Sprint;

public interface SprintService {

	public List<Sprint> getSprintList();

	public Sprint getSprint(String sprintNumber);

	public void addSprint(Sprint sprint);

	public void updateSprint(String sprintNumber, Sprint sprintToUpdate);

	public void deleteSprint(String sprintNumber);

}