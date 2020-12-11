package com.onwan.dietapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_equipment", joinColumns = @JoinColumn(name = "equipment_id"), inverseJoinColumns =
	@JoinColumn(name = "user_id"))
	private List<User> users;	
	
	public void addUser(User user) {
		if(users == null) {
			users = new ArrayList<>();
		}
		if(!users.contains(user)) {
			users.add(user);
			user.addEquipment(this);
		}
	}
	
	public void removeUser(User user) {
		if(users != null && users.contains(user)) {
			user.removeEquipment(this);
		}
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Equipment other = (Equipment) obj;
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (name != other.name)
				return false;
		} else if (!name.equals(other.name))
			return true;
		if (description == null) {
			if (description != other.description)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	public Equipment(int id, String name, String description, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.users = users;
	}
	
	public Equipment() {
		super();
	}
	
	@Override 
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipment [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", users=");
		builder.append(users);
		builder.append("]");
		return builder.toString();	
	}
}