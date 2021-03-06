package hu.icell.javaeetraining.finalexam.application2.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class TodoTaskApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> classes = new HashSet<>();
		classes.add(TodoTaskRestService.class);
		
		return classes;
	}
}
