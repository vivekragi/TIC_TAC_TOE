package com.nagal.splitwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private String username;
	private Character uid;

	public User(String username,Character uid) {
		this.username = username;
		this.uid=uid;
	}

}
