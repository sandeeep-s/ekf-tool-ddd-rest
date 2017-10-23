package com.gefa.ekf.application;

import java.util.List;

import com.gefa.ekf.domain.Manufacturer;
import com.gefa.ekf.domain.repositories.ManufacturerRepository;

public class ManufacturerLookupService {

	ManufacturerRepository manufacturerRepository;

	public List<Manufacturer> getAllManufacturers() {
		return manufacturerRepository.getAllManufacturers();
	}

}
