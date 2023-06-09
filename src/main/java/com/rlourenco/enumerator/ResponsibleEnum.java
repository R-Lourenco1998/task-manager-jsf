package com.rlourenco.enumerator;

public enum ResponsibleEnum {
	RICARDO("Ricardo"),
	JOAO("João"),
	MARIA("Maria");
	
	private String description;

	private ResponsibleEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
