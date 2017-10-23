package com.gefa.ekf.boundary.rest.resources;

import com.gefa.ekf.boundary.rest.activities.PayoffActivity;
import com.gefa.ekf.boundary.rest.representations.PayoffRepresentation;

public class PayoffResourceImpl implements PayoffResource {

	private PayoffActivity payoffActivity;

	public PayoffRepresentation payoff(PayoffRepresentation payoffRepresentation) {
		PayoffRepresentation responseRepresentation =  payoffActivity.payoff(payoffRepresentation);
		return responseRepresentation;
	}

}
