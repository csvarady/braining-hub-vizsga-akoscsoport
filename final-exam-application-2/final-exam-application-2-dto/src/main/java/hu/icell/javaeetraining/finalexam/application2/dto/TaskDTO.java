package hu.icell.javaeetraining.finalexam.application2.dto;

public class TaskDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	private int priority;

	// Ez itt helytelen volt, a teljes TodoDTO -t bevesszük, különben nem tudunk entitást előállítani ha csak az ID van meg.
	//private Integer todoId;
	private TodoDTO todoDTO;
	
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

	public TodoDTO getTodoDTO() {
		return todoDTO;
	}

	public void setTodoDTO(TodoDTO todo) {
		this.todoDTO = todo;
	}

}
