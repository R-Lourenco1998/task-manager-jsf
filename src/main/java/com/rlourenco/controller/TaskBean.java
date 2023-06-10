package com.rlourenco.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.rlourenco.entity.Task;
import com.rlourenco.enumerator.PriorityLevelEnum;
import com.rlourenco.enumerator.ResponsibleEnum;
import com.rlourenco.enumerator.SituationEnum;

@Named("taskBean")
@ViewScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Task task = new Task();

	public Task getTask() {
		return task;
	}

	public void save() {
		System.out.println("Título: " + task.getTitle() + "Descrição: " + task.getDescription() + "Prioridade: "
				+ task.getPriority() + "Deadline: " + task.getDeadline() + "Responsável: " + task.getResponsible());
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
