package com.rlourenco.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.rlourenco.entity.Task;
import com.rlourenco.enumerator.PriorityLevelEnum;
import com.rlourenco.enumerator.ResponsibleEnum;
import com.rlourenco.enumerator.SituationEnum;
import com.rlourenco.service.TaskService;

@Named()
@ViewScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Task> tasksList;

	@Inject
	private TaskService taskService;

	private Task task = new Task();

	private Long idFilter;

	private String titleDescriptionFilter;
	
	private PriorityLevelEnum priorityFilter;
	
	private ResponsibleEnum responsibleFilter;
	
	private SituationEnum situationFilter;

	public void search() {
		tasksList = taskService.searchTasks(titleDescriptionFilter, idFilter, priorityFilter, responsibleFilter, situationFilter);
	}

	public Task getTask() {
		return task;
	}

	public void AllTasks() {
		tasksList = taskService.getAllTasks();
	}

	public List<Task> getTasksList() {
		return tasksList;
	}

	public PriorityLevelEnum[] getPriorityLevels() {
		return PriorityLevelEnum.values();
	}

	public ResponsibleEnum[] getResponsibles() {
		return ResponsibleEnum.values();
	}

	public SituationEnum[] getSituations() {
		return SituationEnum.values();
	}

	public Long getIdFilter() {
		return idFilter;
	}

	public void setIdFilter(Long idFilter) {
		this.idFilter = idFilter;
	}

	public String getTitleDescriptionFilter() {
		return titleDescriptionFilter;
	}

	public void setTitleDescriptionFilter(String titleDescriptionFilter) {
		this.titleDescriptionFilter = titleDescriptionFilter;
	}

	public PriorityLevelEnum getPriorityFilter() {
		return priorityFilter;
	}

	public void setPriorityFilter(PriorityLevelEnum priorityFilter) {
		this.priorityFilter = priorityFilter;
	}

	public ResponsibleEnum getResponsibleFilter() {
		return responsibleFilter;
	}

	public void setResponsibleFilter(ResponsibleEnum responsibleFilter) {
		this.responsibleFilter = responsibleFilter;
	}

	public SituationEnum getSituationFilter() {
		return situationFilter;
	}

	public void setSituationFilter(SituationEnum situationFilter) {
		this.situationFilter = situationFilter;
	}
	
	

}
