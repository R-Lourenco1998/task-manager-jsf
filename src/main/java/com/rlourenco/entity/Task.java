package com.rlourenco.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rlourenco.enumerator.PriorityLevelEnum;
import com.rlourenco.enumerator.ResponsibleEnum;

@Entity
@Table(name = "task")
public class Task implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
    @Enumerated(EnumType.STRING)
    private PriorityLevelEnum priority;
    
    private Date deadline;
    
    @Enumerated(EnumType.STRING)
    private ResponsibleEnum responsible;
}
