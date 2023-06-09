package com.rlourenco.enumerator;

public enum PriorityLevelEnum {
	HIGH("Urgente"),
	MEDIUM("Média"),
	LOW("Baixa");
	
	private String description;

	private PriorityLevelEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
