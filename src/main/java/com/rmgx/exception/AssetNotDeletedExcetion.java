package com.rmgx.exception;

public class AssetNotDeletedExcetion extends RuntimeException {

	private static final long serialVersionUID = 6715012608178626674L;

	public AssetNotDeletedExcetion(String msg) {
		super(msg);
	}
}
