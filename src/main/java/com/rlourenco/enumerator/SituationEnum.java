package com.rlourenco.enumerator;

public enum SituationEnum {

	IN_PROGRESS("Em Andamento"),
	COMPLETED("Concluída");
	
	private String description;
	
	SituationEnum(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
