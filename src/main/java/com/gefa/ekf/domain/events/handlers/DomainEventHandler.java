package com.gefa.ekf.domain.events.handlers;

import com.gefa.ekf.domain.events.DomainEvent;

public interface DomainEventHandler {

	public void handle(DomainEvent domainEvent);

}
