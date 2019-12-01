package ro.dragos.model;

import java.util.Date;

public class Client {

	private Integer id;
	private String name;
	private String email;
	private Date dateJoined;
	
	public Client() {
	
	}

	public Client(Integer id, String name, String email, Date dateJoined) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dateJoined = dateJoined;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", dateJoined=" + dateJoined + "]";
	}
	
	
	
	
}
