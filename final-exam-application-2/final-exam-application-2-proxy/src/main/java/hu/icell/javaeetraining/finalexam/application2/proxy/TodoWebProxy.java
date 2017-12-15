package hu.icell.javaeetraining.finalexam.application2.proxy;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.icell.javaeetraining.finalexam.application2.dao.TaskDAO;
import hu.icell.javaeetraining.finalexam.application2.dto.TodoDTO;
import hu.icell.javaeetraining.finalexam.application2.model.Task;
import hu.icell.javaeetraining.finalexam.application2.model.Todo;

public class TodoWebProxy implements BaseProxy<Todo, TodoDTO> {

	@Inject
	private TaskDAO dao;

	public TodoDTO entityToDTO(Todo entity) {
		// TODO Auto-generated method stub
		TodoDTO dto = new TodoDTO();

		final List<Integer> ids = new ArrayList<Integer>();
		entity.getTasks().forEach(task -> { ids.add(task.getId()); });

		dto.setTasksIds(ids);
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setTodoDeadline(entity.getTodoDeadline());
		return dto;
	}

	public Todo DTOToEntity(TodoDTO dto) {
		Todo todo = new Todo();
		TaskWebProxy taskProxy = new TaskWebProxy();
		
		final List<Task> tasks = new ArrayList<Task>();
		dto.getTasksIds().forEach(taskId -> { 
			Task task = taskProxy.DTOToEntity(dao.getById(taskId));
			tasks.add(task); 
		});
		
		todo.setTasks(tasks);
		todo.setDescription(dto.getDescription());
		todo.setId(dto.getId());
		todo.setTodoDeadline(dto.getTodoDeadline());
	
		return todo;
	}

}
