package models;

public class User {
	private String name;
	private String lastName;
	private int age;
	
	public User(String name, String lastName, int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	
	// Getters
	
	public String getName() {
		return this.name;
	}
	public String getlastName() {
		return this.lastName;
	}
	public String getFullName() {
		return this.name + "" + this.lastName;
	}
	public int getAge() {
		return this.age;
	}
	
}
