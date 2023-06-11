package com.rlourenco.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rlourenco.entity.Task;
import com.rlourenco.enumerator.PriorityLevelEnum;
import com.rlourenco.enumerator.ResponsibleEnum;
import com.rlourenco.enumerator.SituationEnum;

public class PersistanceLoader {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskManagerPU");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		TaskRepository taskRepository = new TaskRepository(entityManager);

		Task task1 = new Task();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date deadline = sdf.parse("15/06/2023");
			task1.setDeadline(deadline);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		task1.setTitle("Teste técnico ESIG");
		task1.setDescription("Gerenciador de Tarefas");
		// task1.setDeadline(deadline);
		task1.setResponsible(ResponsibleEnum.RICARDO);
		task1.setPriority(PriorityLevelEnum.HIGH);
		task1.setSituation(SituationEnum.IN_PROGRESS);

		taskRepository.save(task1);

		entityManager.getTransaction().commit();

		List<Task> tasksLists = taskRepository.search("");
		System.out.println(tasksLists);

		entityManager.close();
		entityManagerFactory.close();

	}

}
