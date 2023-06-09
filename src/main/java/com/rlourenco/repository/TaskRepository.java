package com.rlourenco.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rlourenco.entity.Task;

public class TaskRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public TaskRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public TaskRepository() {

	}

	public Task findById(Long id) {
		return entityManager.find(Task.class, id);
	}

	public List<Task> search(String search) {
		TypedQuery<Task> query = entityManager.createQuery("from Task where title like :title", Task.class);
		query.setParameter("title", search + "%");
		return query.getResultList();
	}

	public List<Task> searchWithCriteria(String search) {
	    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Task> criteriaQuery = criteriaBuilder.createQuery(Task.class);
	    Root<Task> root = criteriaQuery.from(Task.class);
	    criteriaQuery.select(root);

	    // Criação do predicado composto
	    Predicate predicate = criteriaBuilder.or(
	        criteriaBuilder.like(root.get("title"), "%" + search + "%"),
	        criteriaBuilder.like(root.get("description"), "%" + search + "%")
	    );
	    criteriaQuery.where(predicate);

	    TypedQuery<Task> query = entityManager.createQuery(criteriaQuery);
	    return query.getResultList();
	}


	public List<Task> findAll() {
		TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM Task t", Task.class);
		return query.getResultList();
	}

	public Task save(Task task) {
		return entityManager.merge(task);
	}

	public void delete(Task task) {
		task = findById(task.getId());
		entityManager.remove(task);
	}
}
