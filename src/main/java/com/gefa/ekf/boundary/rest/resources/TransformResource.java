package com.gefa.ekf.boundary.rest.resources;

import com.gefa.ekf.boundary.rest.representations.TransformationRepresentation;

public interface TransformResource {

	TransformationRepresentation transform(TransformationRepresentation transformationRepresentation);
	
}
