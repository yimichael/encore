package com.encore.util;

public enum Gender {
	M ("Male","남자"),
	F("Female","여자");
	
	String engName;
	String korName;
	
	Gender(String engName, String korName){
		this.engName = engName;
		this.korName= korName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getKorName() {
		return korName;
	}

	public void setKorName(String korName) {
		this.korName = korName;
	}




}
