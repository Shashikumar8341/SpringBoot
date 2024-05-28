package com.src.constants;

public enum Responsecode {
	update(201), delete(202), crate(203), ok(200), notfound(404);

	Responsecode(int code) {
		this.code = code;

	}

	public final Integer code;
}
