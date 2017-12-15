package hu.icell.javaeetraining.finalexam.application2.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TodoDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDateTime todoDeadline;

	private String description;

	private List<Integer> tasksIds;

	public LocalDateTime getTodoDeadline() {
		return todoDeadline;
	}

	public void setTodoDeadline(LocalDateTime todoDeadline) {
		this.todoDeadline = todoDeadline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getTasksIds() {
		return tasksIds;
	}

	public void setTasksIds(List<Integer> tasksIds) {
		this.tasksIds = tasksIds;
	}

}
