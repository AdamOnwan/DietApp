package com.onwan.dietapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name = "cook_time")
	private int cookTime;
	@Column(name = "prep_time")
	private int prepTime;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "image_url2")
	private String imageUrl2;
	@Column(name = "image_url3")
	private String imageUrl3;
	@ManyToMany(mappedBy="recipes")
	private List<Food> foods;
	
	public void addFood(Food food) {
		if(foods == null) {
			foods = new ArrayList<>();
		}
		if(!foods.contains(food)) {
			foods.add(food);
			food.addRecipe(this);
		}
	}
	
	public void removeFood(Food food) {
		if(foods != null && foods.contains(food)) {
			foods.remove(food);
			food.removeRecipe(this);
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
	public int getCookTime() {
		return cookTime;
	}
	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}
	public int getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
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
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + cookTime;
		result = prime * result + prepTime;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((imageUrl2 == null) ? 0 : imageUrl2.hashCode());
		result = prime * result + ((imageUrl3 == null) ? 0 : imageUrl3.hashCode());
		result = prime * result + ((foods == null) ? 0 : foods.hashCode());
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
		Recipe other = (Recipe) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (cookTime != other.cookTime)
			return false;
		if (prepTime != other.prepTime)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (imageUrl2 == null) {
			if (other.imageUrl2 != null)
				return false;
		} else if (!imageUrl2.equals(other.imageUrl2))
			return false;
		if (imageUrl3 == null) {
			if (other.imageUrl3 != null)
				return false;
		} else if (!imageUrl3.equals(other.imageUrl3))
			return false;
		if (foods == null) {
			if (other.foods != null)
				return false;
		} else if (!foods.equals(other.foods))
			return false;
		return true;
	}
	
	public Recipe() {
		super();
	}
	
	public Recipe(int id, String name, String description, int cookTime, int prepTime, String imageUrl, String imageUrl2,
			String imageUrl3, List<Food> foods) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cookTime = cookTime;
		this.prepTime = prepTime;
		this.imageUrl = imageUrl;
		this.imageUrl2 = imageUrl2;
		this.imageUrl3 = imageUrl3;
		this.foods = foods;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recipe [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", cookTime=");
		builder.append(cookTime);
		builder.append(", prepTime=");
		builder.append(prepTime);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", imageUrl2=");
		builder.append(imageUrl2);
		builder.append(", imageUrl3=");
		builder.append(imageUrl3);
		builder.append("]");
		return builder.toString();
	}
}
