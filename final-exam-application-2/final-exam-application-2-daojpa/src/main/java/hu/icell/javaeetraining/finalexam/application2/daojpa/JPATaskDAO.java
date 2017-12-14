package hu.icell.javaeetraining.finalexam.application2.daojpa;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hu.icell.javaeetraining.finalexam.application2.dao.TaskDAO;
import hu.icell.javaeetraining.finalexam.application2.dto.TaskDTO;
import hu.icell.javaeetraining.finalexam.application2.model.Task;
import hu.icell.javaeetraining.finalexam.application2.proxy.TaskWebProxy;


@ApplicationScoped
public class JPATaskDAO implements TaskDAO {

	@PersistenceContext(name = "ExampleDS")
	protected EntityManager em;
	
	protected TaskWebProxy proxy = new TaskWebProxy();
	
	public void persist(TaskDTO object) {
		Task task = proxy.DTOToEntity(object);
		em.persist(task);
	}

	public void update(TaskDTO object) {
		Task task = proxy.DTOToEntity(object);
		em.merge(task);
	}

	public void delete(TaskDTO object) {
		Task task = proxy.DTOToEntity(object);
		em.remove(task);
	}

	public List<TaskDTO> getAll() {
		List<TaskDTO> tasks = new ArrayList<TaskDTO>();
		
		em.createQuery("Select e from Task e", Task.class).getResultList().forEach(task -> {
			tasks.add(proxy.entityToDTO(task));
		});
		
		return tasks; 
	}

	public TaskDTO getById(Integer id) {
		Task task = em.find(Task.class, id);
		
		return proxy.entityToDTO(task);
	}
}
