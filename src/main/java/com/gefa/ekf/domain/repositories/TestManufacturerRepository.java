package com.gefa.ekf.domain.repositories;

import java.util.List;

import com.gefa.ekf.domain.Manufacturer;
import com.gefa.ekf.domain.repositories.ManufacturerRepository;

public class TestManufacturerRepository implements ManufacturerRepository {

	public Manufacturer getManufacturer(String manufacturerTitle) {
		return new Manufacturer(manufacturerTitle, 7007600400005L);
	}

	@Override
	public List<Manufacturer> getAllManufacturers() {
		// TODO Auto-generated method stub
		return null;
	}

}
