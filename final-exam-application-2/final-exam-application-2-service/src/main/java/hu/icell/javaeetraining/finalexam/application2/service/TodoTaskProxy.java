package hu.icell.javaeetraining.finalexam.application2.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import hu.icell.javaeetraining.finalexam.application2.dto.TaskDTO;
import hu.icell.javaeetraining.finalexam.application2.dto.TodoDTO;

@Path("/todo")
@Named
@RequestScoped
public class TodoTaskProxy {

	@Context
	private UriInfo uriInfo;
	
	@EJB
	private TodoService service;
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTodo(TodoDTO todo) throws URISyntaxException {

		Integer todoID = service.createTodo(todo);

		URI location = new URI(uriInfo.getRequestUri() + "/" + todoID);
		return Response.status(Response.Status.CREATED).location(location).build();		
	}

	@DELETE
	@Path("/{todoID}")
	public Response deleteTodo(@PathParam("todoID") Integer todoID) {
		
		service.deleteTodo(todoID);
		
		return Response.status(Response.Status.OK).entity(null).build();
	}
	
	@PUT
	@Path("/{todoID}/task")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTask(@PathParam("todoID") Integer todoID, TaskDTO task) {
		
		task.setTodoId(todoID);
		service.addTask(task);
		
		return Response.status(Response.Status.CREATED).entity(null).build();
	}

	@DELETE
	@Path("/{todoID}/task/{taskID}")
	public Response deleteTask(@PathParam("todoID") Integer todoID, @PathParam("taskID") Integer taskID) {
		
		List<TaskDTO> tasks = service.getAllTaskForTodo(todoID);
		for (TaskDTO task : tasks) {
			if (task.getId() == taskID) {
				service.removeTask(taskID);
				return Response.status(Response.Status.OK).entity(null).build();
			}
		}

		return Response.status(Response.Status.NOT_FOUND).
			header("message", "No such task for this todo. todoId: "+todoID+", taskId: "+taskID)
			.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listTodos() {
		
		List<TodoDTO> todos = service.getAllTodo();
		
		return Response.status(Response.Status.OK).entity(todos).build();
	}
	
	@GET
	@Path("/{todoID}/task")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listTodoTasks(@PathParam("todoID") Integer todoID) {
		
		List<TaskDTO> todoTasks = service.getAllTaskForTodo(todoID);
		
		return Response.status(Response.Status.OK).entity(todoTasks).build();
	}
	
}
