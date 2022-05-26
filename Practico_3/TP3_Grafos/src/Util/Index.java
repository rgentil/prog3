package Util;

public enum Index {
	AMARILLO("amarillo"), BLANCO("blanco"), NEGRO("negro");

	private String label;

	Index(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
