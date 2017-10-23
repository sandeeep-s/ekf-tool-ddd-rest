package com.gefa.ekf.domain;

import java.util.ArrayList;
import java.util.List;

import com.gefa.ekf.domain.events.DomainEvent;

public abstract class AggregateRoot {

	private List<DomainEvent> domainEvents;

	public void addDomainEvent(DomainEvent domainEvent) {
		if (null == domainEvents) {
			domainEvents = new ArrayList<DomainEvent>();
		}

		domainEvents.add(domainEvent);
	}

	public void clearDomainEvents() {
		domainEvents = new ArrayList<DomainEvent>();
	}

	public List<DomainEvent> getDomainEvents() {
		return domainEvents;
	}
}
