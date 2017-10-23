package com.gefa.ekf.application;

import java.util.List;

import com.gefa.ekf.domain.BusinessType;
import com.gefa.ekf.domain.repositories.BusinessTypeRepository;

public class BusinessTypeLookupService {

	private BusinessTypeRepository businessTypeRepository;
	
	public List<BusinessType> getAllBusinessTypes(){
		return businessTypeRepository.getAllBusinessTypes();
	}
	
}
