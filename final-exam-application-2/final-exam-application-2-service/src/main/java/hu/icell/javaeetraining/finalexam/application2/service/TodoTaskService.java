package hu.icell.javaeetraining.finalexam.application2.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import hu.icell.javaeetraining.finalexam.application2.dao.TaskDAO;
import hu.icell.javaeetraining.finalexam.application2.dao.TodoDAO;
import hu.icell.javaeetraining.finalexam.application2.dto.TaskDTO;
import hu.icell.javaeetraining.finalexam.application2.dto.TodoDTO;

@Stateless
public class TodoTaskService implements TodoService {

	@Inject
	private TaskDAO taskDAO;

	@Inject
	private TodoDAO todoDAO;

	@Override
	public Integer createTodo(TodoDTO todo) {

		todoDAO.persist(todo);

		return todo.getId();
	}

	@Override
	public void deleteTodo(Integer id) {

		todoDAO.delete(todoDAO.getById(id));
	}

	@Override
	public void addTask(TaskDTO task) {

		taskDAO.persist(task);
	}

	@Override
	public void removeTask(Integer taskId) {

		taskDAO.delete(taskDAO.getById(taskId));
	}

	@Override
	public List<TodoDTO> getAllTodo() {

		return todoDAO.getAll();
	}

	@Override
	public List<TaskDTO> getAllTaskForTodo(Integer todoId) {

		TodoDTO todoDTO = todoDAO.getById(todoId);

		List<Integer> taskIDs = todoDTO.getTasksIds();

		List<TaskDTO> ret = new ArrayList<>();
		
		if (taskIDs != null) {

			taskIDs.forEach(id -> {
				ret.add(taskDAO.getById(id));
			});
		}

		return ret;
	}

}
