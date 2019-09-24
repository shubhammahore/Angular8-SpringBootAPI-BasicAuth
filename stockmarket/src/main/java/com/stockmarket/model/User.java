package com.stockmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", isactivated="
				+ isactivated + "]";
	}

	public User(
			@NotNull(message = "Email cannot be empty!") @Size(max = 255, message = "Email cannot exceed 255 characters!") @Pattern(regexp = ".+@.+\\..+", message = "Invalid email address!") String email,
			@NotNull(message = "Password cannot be empty!") @Size(min = 6, max = 100, message = "Password must be 6 to 30 characters!") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(int id,
			@NotNull(message = "Name cannot be empty!") @Size(max = 70, message = "Name cannot exceed 70 characters!") String name,
			@NotNull(message = "Password cannot be empty!") @Size(min = 6, max = 100, message = "Password must be 6 to 30 characters!") String password,
			@NotNull(message = "Email cannot be empty!") @Size(max = 255, message = "Email cannot exceed 255 characters!") @Pattern(regexp = ".+@.+\\..+", message = "Invalid email address!") String email,
			String isactivated) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.isactivated = isactivated;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	@NotNull(message = "Name cannot be empty!")
	@Column(name = "user_name")
	@Size(max = 70, message = "Name cannot exceed 70 characters!")
	private String name;

	@NotNull(message = "Password cannot be empty!")
	@Size(min = 6, max = 100, message = "Password must be 6 to 30 characters!")
	@Column(name = "user_password")
	private String password;
	
	@NotNull(message = "Email cannot be empty!")
	@Size(max = 255, message = "Email cannot exceed 255 characters!")
	@Pattern(regexp = ".+@.+\\..+", message = "Invalid email address!")
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_isactivated")
	private String isactivated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String isIsactivated() {
		return isactivated;
	}

	public void setIsactivated(String isactivated) {
		this.isactivated = isactivated;
	}
}