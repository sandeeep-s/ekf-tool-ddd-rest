package com.gefa.ekf.domain.repositories;

import java.util.Collection;
import java.util.List;

import com.gefa.ekf.domain.BusinessType;

public interface BusinessTypeRepository {

	public BusinessType getBusinessType(String businessTypetitle);

	public List<BusinessType> getAllBusinessTypes();

}
