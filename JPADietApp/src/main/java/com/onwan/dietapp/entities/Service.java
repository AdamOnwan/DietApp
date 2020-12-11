package com.onwan.dietapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private Double price;
	private boolean available;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "image_url2")
	private String imageUrl2;
	@Column(name = "image_url3")
	private String imageUrl3;
	private String category;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;
	@JsonIgnore
	@OneToMany(mappedBy = "service")
	private List<Reservation> reservations;
	
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean getAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageUrl2() {
		return imageUrl2;
	}
	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}
	public String getImageUrl3() {
		return imageUrl3;
	}
	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((imageUrl2 == null) ? 0 : imageUrl2.hashCode());
		result = prime * result + ((imageUrl3 == null) ? 0 : imageUrl3.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((reservations == null) ? 0 : reservations.hashCode());
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
		Service other = (Service) obj;
		if (id != other.id) {
			return false;			
		}
		if (name == null) {
			if (name != other.name)
				return false;
			} else if (!name.equals(other.name))
				return false;
		if (description == null) {
			if (description != other.description)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (price == null) {
			if (price != other.price)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (available != other.available)
			return false;
		if (imageUrl == null) {
			if (imageUrl != other.imageUrl)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (imageUrl2 == null) {
			if (imageUrl2 != other.imageUrl2)
				return false;
		} else if (!imageUrl2.equals(other.imageUrl2))
			return false;
		if (imageUrl3 == null) {
			if (imageUrl3 != other.imageUrl3)
				return false;
		} else if (!imageUrl3.equals(other.imageUrl3))
			return false;
		if (category == null) {
			if (category != other.category)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (reservations == null) {
			if (other.reservations != null)
				return false;
		} else if (!reservations.equals(other.reservations))
			return false;
		return true;
	}
	
	public Service (int id, String name, String description, Double price, boolean available, String imageUrl, String imageUrl2,
			String imageUrl3, String category, User user, List<Reservation> reservations) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.available = available;
		this.imageUrl = imageUrl;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.category = category;
		this.user = user;
		this.reservations = reservations;
	}
	
	public Service() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Service [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(String.format("%.2f", price));
		builder.append(", available=");
		builder.append(available);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", imageUrl2=");
		builder.append(imageUrl2);
		builder.append(", imageUrl3=");
		builder.append(imageUrl3);
		builder.append(", category=");
		builder.append(category);
		return builder.toString();
	}
}
