package hu.icell.javaeetraining.finalexam.application2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TODO")
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo extends BusinessObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*TODO: meg kell vizsgálni hogy LocalDateTime működik-e, nem okoz gondot JPA mapping-ben*/

	@Column(name="DEADLINE")
	private LocalDateTime todoDeadline;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	//mono-directional one-to-many association to Task
	@OneToMany
	private List<Task> tasks = new ArrayList<>();

	@Override
	public String toString() {
		return "Todo [todoDeadline=" + todoDeadline + ", description=" + description + ", tasks=" + tasks + "]";
	}

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
