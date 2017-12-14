package hu.icell.javaeetraining.finalexam.application2.proxy;


import javax.inject.Inject;

import hu.icell.javaeetraining.finalexam.application2.dao.TaskDAO;
import hu.icell.javaeetraining.finalexam.application2.dto.TaskDTO;
import hu.icell.javaeetraining.finalexam.application2.model.Task;

public class TaskWebProxy implements BaseProxy<Task, TaskDTO> {

	@Inject
	private TaskDAO dao;

	public TaskDTO entityToDTO(Task entity) {
		// TODO Auto-generated method stub
		TaskDTO dto = new TaskDTO();

		TodoWebProxy todoProxy = new TodoWebProxy();
		
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setPriority(entity.getPriority());
		//dto.setTodoId(entity.getTodo().getId());
		
		dto.setTodoDTO(todoProxy.entityToDTO(entity.getTodo()));
		
		return dto;
	}

	public Task DTOToEntity(TaskDTO dto) {
		Task task = new Task();

		TodoWebProxy todoProxy = new TodoWebProxy();
		
		task.setId(dto.getId());
		task.setName(dto.getName());
		task.setDescription(dto.getDescription());
		task.setPriority(dto.getPriority());
		task.setTodo(todoProxy.DTOToEntity(dto.getTodoDTO()));
	
		return task;
	}

}
