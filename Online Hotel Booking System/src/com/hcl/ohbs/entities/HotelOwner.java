package com.hcl.ohbs.entities;

public class HotelOwner {
	private int id;
	private String fistName;
	private String lastName;
	private String nic;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;
	private int status;
	public HotelOwner() {
		
	}
	public HotelOwner(String fistName, String lastName, String nic, String phoneNumber, String email, String username,
			String password) {
		this.fistName = fistName;
		this.lastName = lastName;
		this.nic = nic;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public HotelOwner(String fistName, String lastName, String nic, String phoneNumber, String email, String username,
			String password, int status) {
		this.fistName = fistName;
		this.lastName = lastName;
		this.nic = nic;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public HotelOwner(int id) {
		this.id = id;
	}
	public HotelOwner(int id, String fistName, String lastName, String nic, String phoneNumber, String email,
			String username, String password, int status) {
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.nic = nic;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public HotelOwner(int id, String fistName, String lastName, String nic, String phoneNumber, String email,int status) {
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.nic = nic;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public HotelOwner(int id, String fistName, String lastName, String nic, String phoneNumber, String email,
			String username, String password) {
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.nic = nic;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "HotelOwner [id=" + id + ", fistName=" + fistName + ", lastName=" + lastName + ", nic=" + nic
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", username=" + username + ", password="
				+ password + ", status=" + status + "]";
	}	
}
