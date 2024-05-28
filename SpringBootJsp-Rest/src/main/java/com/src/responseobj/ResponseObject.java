package com.src.responseobj;

public class ResponseObject {

	private Integer statuscode;
	private Object result;

	/**
	 * @param statuscode
	 * @param result
	 */
	public ResponseObject(Integer statuscode, Object result) {
		super();
		this.statuscode = statuscode;
		this.result = result;
	}

	public ResponseObject() {
		super();
	}

	public Integer getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResponseObject [statuscode=" + statuscode + ", result=" + result + "]";
	}

}
