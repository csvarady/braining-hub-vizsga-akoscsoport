package hu.icell.javaeetraining.finalexam.application2.service;

import java.util.List;

import hu.icell.javaeetraining.finalexam.application2.dto.TaskDTO;
import hu.icell.javaeetraining.finalexam.application2.dto.TodoDTO;

public interface TodoService {

	
	Integer createTodo(TodoDTO todo);
	
	void deleteTodo(Integer id);
	
	void addTask(TaskDTO task);
	
	void removeTask(Integer taskId);
	
	List<TodoDTO> getAllTodo();
	
	List<TaskDTO> getAllTaskForTodo(Integer todoId);
}
