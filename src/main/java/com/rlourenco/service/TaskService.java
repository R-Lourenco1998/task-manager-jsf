package com.rlourenco.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.rlourenco.entity.Task;
import com.rlourenco.repository.TaskRepository;
import com.rlourenco.util.Transactional;

public class TaskService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TaskRepository repository;

	@Transactional
	public void save(Task task) {
		repository.save(task);
	}

	@Transactional
	public void delete(Task task) {
		repository.delete(task);
	}

	@Transactional
	public List<Task> getAllTasks() {
		return repository.findAll();
	}
}
