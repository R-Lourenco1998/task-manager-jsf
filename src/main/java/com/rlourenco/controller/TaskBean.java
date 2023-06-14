package com.rlourenco.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.rlourenco.entity.Task;
import com.rlourenco.enumerator.PriorityLevelEnum;
import com.rlourenco.enumerator.ResponsibleEnum;
import com.rlourenco.enumerator.SituationEnum;
import com.rlourenco.service.TaskService;
//import com.rlourenco.util.FacesMessages;

@Named()
@ViewScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Task> tasksList;

//	@Inject
//	private FacesMessages messages;

	@Inject
	private TaskService taskService;

	private Task task = new Task();

	private Task selectedTask = new Task();

	private Long idFilter;

	private String titleDescriptionFilter;

	private PriorityLevelEnum priorityFilter;

	private ResponsibleEnum responsibleFilter;

	private SituationEnum situationFilter;

	public void search() {
		tasksList = taskService.searchTasks(titleDescriptionFilter, idFilter, priorityFilter, responsibleFilter,
				situationFilter);
	}

	public void prepareNewTask() {
		task = new Task();
	}

	public void prepareEditTask() {
		setSelectedTask(new Task());
	}

	public void save() {
		task.setSituation(SituationEnum.IN_PROGRESS);
		taskService.save(task);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa criada com sucesso!"));
		PrimeFaces.current().ajax().update("form:messages");
		getAllTasks();
	}

	public void updateTask() {
		taskService.save(selectedTask);
	}
	
	public void deleteTask() {
		taskService.delete(selectedTask);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa Excluída com sucesso!"));
		PrimeFaces.current().ajax().update("form:messages");
		getAllTasks();
	}
	
	public void concludeTask() {
		selectedTask.setSituation(SituationEnum.COMPLETED);
		taskService.save(selectedTask);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa Concluída com sucesso!"));
		PrimeFaces.current().ajax().update("form:messages");
		getAllTasks();
	}

	public Task getTask() {
		return task;
	}

	public void getAllTasks() {
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

	public Task getSelectedTask() {
		return selectedTask;
	}

	public void setSelectedTask(Task selectedTask) {
		this.selectedTask = selectedTask;
	}

}
