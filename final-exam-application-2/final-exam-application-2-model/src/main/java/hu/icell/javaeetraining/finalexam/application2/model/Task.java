package hu.icell.javaeetraining.finalexam.application2.model;

public class Task extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	private int priority;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
