package controller;

import java.util.Date;

public class UserinfoParam {
	private long idValue;
	private String usernameValue;
	private String passwordValue;
	private long ageValue;
	private Date insertdateValue;
	
	public long getIdValue() {
		return idValue;
	}
	public void setIdValue(long idValue) {
		this.idValue = idValue;
	}
	public String getUsernameValue() {
		return usernameValue;
	}
	public void setUsernameValue(String usernameValue) {
		this.usernameValue = usernameValue;
	}
	public String getPasswordValue() {
		return passwordValue;
	}
	public void setPasswordValue(String passwordValue) {
		this.passwordValue = passwordValue;
	}
	public long getAgeValue() {
		return ageValue;
	}
	public void setAgeValue(long ageValue) {
		this.ageValue = ageValue;
	}
	public Date getInsertdateValue() {
		return insertdateValue;
	}
	public void setInsertdateValue(Date insertdateValue) {
		this.insertdateValue = insertdateValue;
	}
	
	
}
