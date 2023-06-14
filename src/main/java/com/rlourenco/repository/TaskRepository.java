package com.rlourenco.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rlourenco.entity.Task;
import com.rlourenco.enumerator.PriorityLevelEnum;
import com.rlourenco.enumerator.ResponsibleEnum;
import com.rlourenco.enumerator.SituationEnum;

public class TaskRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public TaskRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public TaskRepository() {

	}

	public Task findById(Long id) {
		return entityManager.find(Task.class, id);
	}

	public List<Task> searchWithCriteria(String search, Long idFilter, PriorityLevelEnum priorityFilter,
			ResponsibleEnum responsibleFilter, SituationEnum situationFilter) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Task> criteriaQuery = criteriaBuilder.createQuery(Task.class);
		Root<Task> root = criteriaQuery.from(Task.class);
		criteriaQuery.select(root);

		Predicate predicate = criteriaBuilder.conjunction();

		if (search != null) {
			String searchLower = search.toLowerCase();
			predicate = criteriaBuilder.or(
					criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + searchLower + "%"),
					criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + searchLower + "%"));
		}

		if (priorityFilter != null) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("priority"), priorityFilter));
		}

		if (responsibleFilter != null) {
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(root.get("responsible"), responsibleFilter));
		}

		if (situationFilter != null) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("situation"), situationFilter));
		}

		if (idFilter != null) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), idFilter));
		}

		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
		criteriaQuery.where(predicate);
		TypedQuery<Task> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<Task> findAll() {
		TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM Task t ORDER BY t.id", Task.class);
		return query.getResultList();
	}

	public Task save(Task task) {
		return entityManager.merge(task);
	}

	public void delete(Task task) {
		entityManager.remove(task);
	}
}
