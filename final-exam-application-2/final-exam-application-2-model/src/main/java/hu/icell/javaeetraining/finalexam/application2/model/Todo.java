package hu.icell.javaeetraining.finalexam.application2.model;

import java.time.LocalDateTime;
import java.util.List;

public class Todo extends BusinessObject{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDateTime todoDeadline;
	
	private String description;
	
	private List<Task> tasks;

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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}
