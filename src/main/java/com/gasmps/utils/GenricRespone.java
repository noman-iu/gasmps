package com.gasmps.utils;

import java.util.Map;

public class GenricRespone {

	private boolean status;
	private Map<String, String> message;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GenricRespone [status=" + status + ", message=" + message + "]";
	}

}