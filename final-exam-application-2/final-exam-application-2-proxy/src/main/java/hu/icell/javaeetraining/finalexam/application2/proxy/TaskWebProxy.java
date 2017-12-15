package hu.icell.javaeetraining.finalexam.application2.proxy;

import hu.icell.javaeetraining.finalexam.application2.dto.TaskDTO;
import hu.icell.javaeetraining.finalexam.application2.model.Task;

public class TaskWebProxy implements BaseProxy<Task, TaskDTO> {

	public TaskDTO entityToDTO(Task entity) {
		TaskDTO dto = new TaskDTO();

		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setPriority(entity.getPriority());
		
		return dto;
	}

	public Task DTOToEntity(TaskDTO dto) {
		Task task = new Task();
		
		task.setId(dto.getId());
		task.setName(dto.getName());
		task.setDescription(dto.getDescription());
		task.setPriority(dto.getPriority());

		return task;
	}

}
