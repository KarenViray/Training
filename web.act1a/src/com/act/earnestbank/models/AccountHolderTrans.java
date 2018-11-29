package com.act.earnestbank.models;

import java.sql.Date;

public class AccountHolderTrans {
	private String id;
	private Date dateOfTrans;
	private float transAmt;
	
	public AccountHolderTrans() {
	}
	
	/**
	 * @param id
	 * @param dateOfTrans
	 * @param transAmt
	 */

	public AccountHolderTrans(String id, Date dateOfTrans, float transAmt) {
		this.id = id;
		this.dateOfTrans = dateOfTrans;
		this.transAmt = transAmt;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Date getDateofTrans() {
		return dateOfTrans;
	}

	public void setDateofTrans(Date dateOfTrans ) {
		this.dateOfTrans = dateOfTrans;
	}
	
	public float getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(float transAmt ) {
		this.transAmt = transAmt;
	}
	
}
