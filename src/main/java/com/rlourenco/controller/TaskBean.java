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

	public void save() {
		System.out.println("Título: " + task.getTitle() + "Descrição: " + task.getDescription() + "Prioridade: "
				+ task.getPriority() + "Deadline: " + task.getDeadline() + "Responsável: " + task.getResponsible());
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
}
