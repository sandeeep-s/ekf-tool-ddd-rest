package com.gefa.ekf.domain;

public abstract class AssetState {

	public enum StatusCode {
		CREATED, FINAL_SIGNATURE_REQUESTED, PENDING_AT_GEFA, IN_INVENTORY, APPROVED;
	}

	private StatusCode statusCode;


	public void moveToCreatedState() {
		throw new UnsupportedOperationException();
	}

	public void moveToSubmittedState() {
		throw new UnsupportedOperationException();
	}

	public void moveToApprovedState() {
		throw new UnsupportedOperationException();
	}

	public void moveToDeletedState() {
		throw new UnsupportedOperationException();
	}

	public void moveToArchivedState() {
		throw new UnsupportedOperationException();
	}


}
