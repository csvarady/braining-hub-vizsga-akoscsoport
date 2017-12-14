package hu.icell.javaeetraining.finalexam.application2.daojpa;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import hu.icell.javaeetraining.finalexam.application2.dao.TodoDAO;
import hu.icell.javaeetraining.finalexam.application2.dto.TodoDTO;

@ApplicationScoped
public class JPATodoDAO implements TodoDAO {

	
	
	
	@Override
	public void persist(TodoDTO object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TodoDTO object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TodoDTO object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TodoDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodoDTO getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}