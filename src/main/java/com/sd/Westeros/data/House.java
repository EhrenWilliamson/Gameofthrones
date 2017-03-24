package com.sd.Westeros.data;

public class House {
	
	private int id;
	private String name;
	private String location;
	private String headOfHouse;

	@Override
	public String toString() {
		return "House [name=" + name + ", location=" + location + ", headOfHouse=" + headOfHouse + "]";
	}

	public String getHeadOfHouse() {
		return headOfHouse;
	}

	public void setHeadOfHouse(String headOfHouse) {
		this.headOfHouse = headOfHouse;
	}

	public House() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
