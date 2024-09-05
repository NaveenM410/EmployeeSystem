package EmployeeSystem.model;

public class Employee
{
    private int id;
    private String name;
    private int age;
    private String address;
    private String maritalStatus;
    private String active;
	public Employee(int id, String name, int age, String address, String maritalStatus, String active) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.maritalStatus = maritalStatus;
		this.active = active;
	}
	public Employee(String name, int age, String address, String maritalStatus, String active) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.maritalStatus = maritalStatus;
		this.active = active;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
    
    
   

    
}

