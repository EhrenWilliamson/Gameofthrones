package com.sd.westeros.data;

public class House {
	
	private int id;
	private String houseName;
	private String castleName;
	private String location;
	private String headOfHouse;
	
	public House(){}

	public House(int id, String houseName, String castleName, String location, String headOfHouse) {
		this.id = id;
		this.houseName = houseName;
		this.castleName = castleName;
		this.location = location;
		this.headOfHouse = headOfHouse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getCastleName() {
		return castleName;
	}

	public void setCastleName(String castleName) {
		this.castleName = castleName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHeadOfHouse() {
		return headOfHouse;
	}

	public void setHeadOfHouse(String headOfHouse) {
		this.headOfHouse = headOfHouse;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", houseName=" + houseName + ", castleName=" + castleName
				+ ", location=" + location + ", headOfHouse=" + headOfHouse + "]";
	}
	
}
