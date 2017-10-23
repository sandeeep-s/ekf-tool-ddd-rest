package com.gefa.ekf.application;

import com.gefa.ekf.domain.Transformation;
import com.gefa.ekf.domain.repositories.TransformationRepository;

public class AssetTransformationService {

	private TransformationRepository transformationRepository;

	public void transform(Transformation transformation) {
		transformationRepository.save(transformation);
	}

}
