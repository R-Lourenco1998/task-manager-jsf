package com.rlourenco.enumerator;

public enum PriorityLevelEnum {
	HIGH("Alta"),
	MEDIUM("Média"),
	LOW("Baixa");
	
	private String description;

	PriorityLevelEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
