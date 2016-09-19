package com.app.usermanagement.rest.controller;

import java.util.LinkedHashMap;

public class ResultMap extends LinkedHashMap<String, Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResultMap() {
		super(1, 1.0f);
	}

	public ResultMap(int initialCapacity) {
		super(initialCapacity, 1.0f);
	}
}