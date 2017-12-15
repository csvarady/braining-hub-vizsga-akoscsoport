package hu.icell.javaeetraining.finalexam.application2.dao;

import java.io.Serializable;
import java.util.List;

import hu.icell.javaeetraining.finalexam.application2.dto.BaseDTO;

public interface BaseDAO<T extends BaseDTO, ID extends Serializable> {

		void persist(T object);
		
		void update(T object);
		
		void delete(T object);
		
		List<T> getAll();
		
		T getById(ID id);
	}