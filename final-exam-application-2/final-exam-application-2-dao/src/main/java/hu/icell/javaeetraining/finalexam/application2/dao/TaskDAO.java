package hu.icell.javaeetraining.finalexam.application2.dao;

import hu.icell.javaeetraining.finalexam.application2.dto.TaskDTO;

public interface TaskDAO extends BaseDAO<TaskDTO, Integer> {	
	void delete(TaskDTO object, Integer todoId) throws TaskNotFoundException;
}
