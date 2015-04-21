package com.beto.project.sm.exceptions;

public class SequenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SequenceException [errCode=");
		builder.append(errCode);
		builder.append(", errMsg=");
		builder.append(errMsg);
		builder.append("]");
		return builder.toString();
	}

	// get, set...
	public SequenceException(String errMsg) {
		this.errMsg = errMsg;
	}

}
