package com.training.emp.model;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String cityName;
//	private int salary;
//	private String department;
//	private int age;
	private static final String org = "CodeWine";
	
public Employee(int id, String firstName, String lastName, String address, String cityName) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.cityName = cityName;
}

public int getId() {
	return id;
}

public String getFirstName() {
	return firstName;
}

public String getLastName() {
	return lastName;
}

public String getAddress() {
	return address;
}

public String getCityName() {
	return cityName;
}

public static String getOrg() {
	return org;
}

public void setId(int id) {
	this.id = id;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setAddress(String address) {
	this.address = address;
}

public void setCityName(String cityName) {
	this.cityName = cityName;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + id;
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (cityName == null) {
		if (other.cityName != null)
			return false;
	} else if (!cityName.equals(other.cityName))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (id != other.id)
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	return true;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
			+ ", cityName=" + cityName + "]";
}
	
	
	
	
	
	

}
