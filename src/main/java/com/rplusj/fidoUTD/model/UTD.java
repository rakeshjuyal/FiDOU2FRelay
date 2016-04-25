package com.rplusj.fidoUTD.model;

import java.io.Serializable;

public class UTD implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fsutURL;
	private String uthsURL;
	private String authSecret;
	private int numberOfTests;
	/**
	 * @return the fsutURL
	 */
	public String getFsutURL() {
		return fsutURL;
	}
	/**
	 * @param fsutURL the fsutURL to set
	 */
	public void setFsutURL(String fsutURL) {
		this.fsutURL = fsutURL;
	}
	/**
	 * @return the uthsURL
	 */
	public String getUthsURL() {
		return uthsURL;
	}
	/**
	 * @param uthsURL the uthsURL to set
	 */
	public void setUthsURL(String uthsURL) {
		this.uthsURL = uthsURL;
	}
	/**
	 * @return the authSecret
	 */
	public String getAuthSecret() {
		return authSecret;
	}
	/**
	 * @param authSecret the authSecret to set
	 */
	public void setAuthSecret(String authSecret) {
		this.authSecret = authSecret;
	}
	/**
	 * @return the numberOfTests
	 */
	public int getNumberOfTests() {
		return numberOfTests;
	}
	/**
	 * @param numberOfTests the numberOfTests to set
	 */
	public void setNumberOfTests(int numberOfTests) {
		this.numberOfTests = numberOfTests;
	}
	

	
}
