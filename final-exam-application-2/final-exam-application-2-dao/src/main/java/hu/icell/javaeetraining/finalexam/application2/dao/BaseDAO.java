package hu.icell.javaeetraining.finalexam.application2.dao;

import java.io.Serializable;
import java.util.List;

import hu.icell.javaeetraining.finalexam.application2.model.BusinessObject;

public interface BaseDAO<T extends BusinessObject, ID extends Serializable> {

		void persist(T object);
		
		void update(T object);
		
		void delete(T object);
		
		List<T> getAll();
		
		T getById(ID id);
	}
