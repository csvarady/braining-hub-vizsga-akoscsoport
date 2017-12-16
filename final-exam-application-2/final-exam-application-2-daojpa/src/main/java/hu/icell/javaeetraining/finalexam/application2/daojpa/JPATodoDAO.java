package hu.icell.javaeetraining.finalexam.application2.daojpa;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hu.icell.javaeetraining.finalexam.application2.dao.TodoDAO;
import hu.icell.javaeetraining.finalexam.application2.dao.TodoNotFoundException;
import hu.icell.javaeetraining.finalexam.application2.dto.TodoDTO;
import hu.icell.javaeetraining.finalexam.application2.model.Todo;
import hu.icell.javaeetraining.finalexam.application2.proxy.TodoWebProxy;

@ApplicationScoped
public class JPATodoDAO implements TodoDAO {

	@PersistenceContext(name = "ExampleDS")
	protected EntityManager em;
	
	protected TodoWebProxy proxy = new TodoWebProxy();
	
	public void persist(TodoDTO object) {
		Todo Todo = proxy.DTOToEntity(object);
		em.persist(Todo);
		object.setId(Todo.getId());
	}

	public void update(TodoDTO object) {
		Todo Todo = proxy.DTOToEntity(object);
		em.merge(Todo);
	}

	public void delete(TodoDTO object) throws TodoNotFoundException {
		if (object == null)
			throw new TodoNotFoundException();
		Todo todo = em.find(Todo.class, object.getId());
		if (em.contains(todo)) {
			em.remove(todo);
		}
	}

	public List<TodoDTO> getAll() {
		List<TodoDTO> Todos = new ArrayList<TodoDTO>();
		
		em.createQuery("Select e from Todo e", Todo.class).getResultList().forEach(Todo -> {
			Todos.add(proxy.entityToDTO(Todo));
		});
		
		return Todos; 
	}

	public TodoDTO getById(Integer id) {
		Todo Todo = em.find(Todo.class, id);
		if (Todo != null) {
			return proxy.entityToDTO(Todo);
		}
		else {
			return null;
		}
	}
}