package com.mgo.project.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class UserModel {
	 @Id
	    private ObjectId id;
	    @Indexed(unique=true)
	    private String username;
		private String password;
		private String firstName;
		private String lastName;
		private int role;
	 
	    protected UserModel() {}
	 
	    public UserModel(String username, String password,
				String firstName, String lastName, int role) {
			this.setUsername(username);
			this.setPassword(password);
			this.setFirstName(firstName);
			this.setLastName(lastName);
			this.setRole(role);
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


		public int getRole() {
			return role;
		}


		public void setRole(int role) {
			this.role = role;
		}
}
