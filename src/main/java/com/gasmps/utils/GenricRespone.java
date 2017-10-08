package com.gasmps.utils;

public class GenricRespone {

	private boolean status;
	private String message;
	private int code = 200;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "GenricRespone [status=" + status + ", message=" + message + ", code=" + code + "]";
	}
}