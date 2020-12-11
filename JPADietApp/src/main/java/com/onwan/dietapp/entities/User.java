package com.onwan.dietapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String phone;
	private boolean enabled;
	private String role;
	@Column(name = "image_url")
	private String imageUrl;
	private Integer height;
	private Integer weight;
	private String description;
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Service> services;
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations;
	@ManyToMany(mappedBy="users")
	private List<Food> foods;
	@ManyToMany
	@JoinTable(name = "user_allergy", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns =
	@JoinColumn(name = "allergy_id"))
	private List<Allergy> allergies;
	@ManyToOne
	@JoinColumn(name = "diet_id")
	private Diet diet;
	@ManyToMany(mappedBy = "users")
	private List<Equipment> equipmentList;
	
	public void  addAllergy(Allergy allergy) {
		if(allergies == null) {
			allergies = new ArrayList<>();
		}
		if(!allergies.contains(allergy)) {
			allergies.add(allergy);
			allergy.addUser(this);
		}
	}
	
	public void removeAllergy(Allergy allergy) {
		if(allergies != null && allergies.contains(allergy)) {
			allergies.remove(allergy);
			allergy.removeUser(this);
		}
	}
	
	public void addFood(Food food) {
		if(foods == null) {
			foods = new ArrayList<>();
		}
		if(!foods.contains(food)) {
			foods.add(food);
			food.addUser(this);
		}
	}
	
	public void removeFood(Food food) {
		if(foods != null && foods.contains(food)) {
			foods.remove(food);
			food.removeUser(this);
		}
	}
	
	public void addEquipment(Equipment equipment) {
		if(equipmentList == null) {
			equipmentList = new ArrayList<>();
		}
		if(!equipmentList.contains(equipment)) {
			equipmentList.add(equipment);
			equipment.addUser(this);
		}
	}
	
	public void removeEquipment(Equipment equipment) {
		if(equipmentList != null && equipmentList.contains(equipment)) {
			equipmentList.remove(equipment);
			equipment.removeUser(this);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservation (List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	public List<Allergy> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}
	public Diet getDiet() {
		return diet;
	}
	public void setDiet(Diet diet) {
		this.diet = diet;
	}
	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}
	public void setEquipmentList(List<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		result = prime * result + ((reservations == null) ? 0 : reservations.hashCode());
		result = prime * result + ((foods == null) ? 0 : foods.hashCode());
		result = prime * result + ((allergies == null) ? 0 : allergies.hashCode());
		result = prime * result + ((diet == null) ? 0 : diet.hashCode());
		result = prime * result + ((equipmentList == null) ? 0 : equipmentList.hashCode());
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		if (reservations == null) {
			if (other.reservations != null)
				return false;
		} else if (!reservations.equals(other.reservations))
			return false;
		if (foods == null) {
			if (other.foods != null)
				return false;
		} else if (!foods.equals(other.foods))
			return false;
		if (allergies == null) {
			if (other.allergies != null)
				return false;
		} else if (!allergies.equals(other.allergies))
			return false;
		if (diet == null) {
			if (other.diet != null)
				return false;
		} else if (!diet.equals(other.diet))
			return false;
		if (equipmentList == null) {
			if (other.equipmentList != null)
				return false;
		} else if (!equipmentList.equals(other.equipmentList))
			return false;
		return true;
	}
	
	public User(int id, String firstName, String lastName, String email, String password, String phone, boolean enabled,
			String role, String imageUrl, Integer height, Integer weight, String description, Address address, List<Service> services,
			List<Reservation> reservations, List<Food> foods, List<Allergy> allergies, Diet diet, List<Equipment> equipmentList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.enabled = enabled;
		this.role = role;
		this.imageUrl = imageUrl;
		this.height = height;
		this.weight = weight;
		this.description = description;
		this.address = address;
		this.services = services;
		this.reservations = reservations;
		this.foods = foods;
		this.allergies = allergies;
		this.diet = diet;
		this.equipmentList = equipmentList;
	}
	
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", role=");
		builder.append(role);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", height=");
		builder.append(height);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", description=");
		builder.append(description);
		builder.append(", address=");
		builder.append(address);
		builder.append(", services=");
		builder.append(services);
		builder.append(", reservations=");
		builder.append(reservations);
		builder.append(", foods=");
		builder.append(foods);
		builder.append(", allergies=");
		builder.append(allergies);
		builder.append(", diet=");
		builder.append(diet);
		builder.append(", equipmentList=");
		builder.append(equipmentList);
		builder.append("]");
		return builder.toString();
	}
}