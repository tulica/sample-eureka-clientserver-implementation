package com.webapi.user.model;

import javax.persistence.Embeddable;

@Embeddable
public class Company {
	 private String cname;
	 private String catchphrase;
	 private String bs;
	public String getName() {
		return cname;
	}
	public void setName(String cname) {
		this.cname = cname;
	}
	public String getCatchphrase() {
		return catchphrase;
	}
	public void setCatchphrase(String catchphrase) {
		this.catchphrase = catchphrase;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	 

}
