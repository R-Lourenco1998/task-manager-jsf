package com.rlourenco.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rlourenco.enumerator.PriorityLevelEnum;
import com.rlourenco.enumerator.ResponsibleEnum;

@Entity
@Table(name = "task")
public class Task implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false, length = 120)
	private String title;
	
	@Column(name = "description", nullable = false, length = 120)
	private String description;
	
	@Column(name = "priority_level")
    @Enumerated(EnumType.STRING)
    private PriorityLevelEnum priority;
    
	@Temporal(TemporalType.TIMESTAMP)
    private Date deadline;
    
    @Column(name = "responsible")
    @Enumerated(EnumType.STRING)
    private ResponsibleEnum responsible;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PriorityLevelEnum getPriority() {
		return priority;
	}

	public void setPriority(PriorityLevelEnum priority) {
		this.priority = priority;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public ResponsibleEnum getResponsible() {
		return responsible;
	}

	public void setResponsible(ResponsibleEnum responsible) {
		this.responsible = responsible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + "]";
	}

	public Task(Long id, String title, String description, PriorityLevelEnum priority, Date deadline,
			ResponsibleEnum responsible) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.deadline = deadline;
		this.responsible = responsible;
	}

	public Task() {
		super();
	}
    
}
