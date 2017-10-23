package com.gefa.ekf.domain.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gefa.ekf.domain.BusinessType;

public class TestBusinessTypeRepository implements BusinessTypeRepository {

	private Map<String, BusinessType> businessTypes = new HashMap<String, BusinessType>();

	public TestBusinessTypeRepository() {
		businessTypes.put("new-asset", new BusinessType("neuobj", "new-asset", 7007600100001L));
		businessTypes.put("used-asset", new BusinessType("gebrobj", "used-asset", 7007600100002L));
		businessTypes.put("showcased-asset", new BusinessType("vorfobj", "showcased-asset", 7007600100003L));
		businessTypes.put("rental-fleet-asset", new BusinessType("mietpobj", "rental-fleet-asset", 7007600100004L));

	}

	public BusinessType getBusinessType(String businessTypetitle) {
		return businessTypes.get(businessTypetitle);
	}

	@Override
	public List<BusinessType> getAllBusinessTypes() {

		return new ArrayList<BusinessType>(businessTypes.values());
	}

}
