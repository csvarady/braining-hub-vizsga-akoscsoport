package hu.icell.javaeetraining.finalexam.application2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TASK")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task extends BusinessObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="NAME")
	private String name;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="PRIORITY")
	private int priority;

	@ManyToOne
	@JoinColumn(name = "TODO_ID", referencedColumnName = "ID")
	private Todo todo;
	
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

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

}
