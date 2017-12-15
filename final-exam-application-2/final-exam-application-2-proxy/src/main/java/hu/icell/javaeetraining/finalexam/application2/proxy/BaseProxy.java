package hu.icell.javaeetraining.finalexam.application2.proxy;

import hu.icell.javaeetraining.finalexam.application2.dto.BaseDTO;
import hu.icell.javaeetraining.finalexam.application2.model.BusinessObject;

public interface BaseProxy<BO extends BusinessObject, DTO extends BaseDTO> {
	public DTO entityToDTO(BO entity);
	public BO DTOToEntity(DTO dto);
}
