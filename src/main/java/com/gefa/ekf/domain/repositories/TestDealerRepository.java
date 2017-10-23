package com.gefa.ekf.domain.repositories;

import com.gefa.ekf.domain.Dealer;
import com.gefa.ekf.domain.repositories.DealerRepository;

public class TestDealerRepository implements DealerRepository{

	public Dealer getDealer(Long gevisNumber) {
		return new Dealer(gevisNumber);
	}

}
