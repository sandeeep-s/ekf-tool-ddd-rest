package com.gefa.ekf.domain.repositories;

import java.util.List;

import com.gefa.ekf.domain.Manufacturer;

public interface ManufacturerRepository {

	public Manufacturer getManufacturer(String manufacturerTitle);

	public List<Manufacturer> getAllManufacturers();

}
