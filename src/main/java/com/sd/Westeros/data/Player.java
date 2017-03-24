package com.sd.Westeros.data;

public class Player {
	private String firstName;
	private String lastName;
	private String nickName;
	private String status;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName + ", status="
				+ status + "]";
	}

	public Player() {

	}
}
