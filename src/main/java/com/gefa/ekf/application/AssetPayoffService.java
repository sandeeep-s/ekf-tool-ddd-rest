package com.gefa.ekf.application;

import com.gefa.ekf.domain.Payoff;
import com.gefa.ekf.domain.repositories.PayoffRepository;

public class AssetPayoffService {
	
	private PayoffRepository payoffRepository;

	public void payoff(Payoff payoff){
		payoffRepository.savePayoff(payoff);
	}
	
}
