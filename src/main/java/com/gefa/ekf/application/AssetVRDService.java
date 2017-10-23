package com.gefa.ekf.application;

import com.gefa.ekf.domain.VRDRequest;
import com.gefa.ekf.domain.repositories.VRDRequestRepository;

public class AssetVRDService {

	private VRDRequestRepository vrdRequestRepository;
	
	public void requestVRD(VRDRequest vrdRequest){
		vrdRequestRepository.save(vrdRequest);
	}
	
}
