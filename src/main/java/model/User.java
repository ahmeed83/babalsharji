package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	private String id;
	private String age;
	private String name;
	private String userName;
	private String email;
	private String password;
	
	public String getId() { return id; }
	
	public String getAge() { return age; }
	public void setAge(String age) { this.age = age; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
}