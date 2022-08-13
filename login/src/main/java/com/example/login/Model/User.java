package com.example.login.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
// @Getter @Setter @ToString @AllArgsConstructor
public class User{
	@Id
	@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(nullable=false,updatable=false)
	String userCode;
	@Column(nullable=false,updatable=false)
	String email;
	@Column(nullable=false,updatable=false)
    String userName;
	String firstName;
	String lastName;
	@Column(nullable=false)
	String password;
    String city;
	String state;
	// @Id
	// String userCode;
	public User(){

	}
	public String getEmail() {
		return email;
	}
	public User(String email, String userName, String firstName, String lastName, String password, String city,String state,
			String userCode) {
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.city = city;
		this.state=state;
		this.userCode = userCode;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	@Override
	public String toString() {
		return "User [city=" + city + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", state=" + state + ", userCode=" + userCode + ", userName=" + userName
				+ "]";
	}
	
	
}