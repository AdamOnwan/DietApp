package com.onwan.dietapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name = "portion_size")
	private double portionSize;
	@Column(name = "portion_type")
	private String portionType;
	private double calorie;
	private double fat;
	private double cholesterol;
	private double sodium;
	private double carbohydrate;
	private double fiber;
	private double sugar;
	private double protein;
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "user_food", joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns =
	@JoinColumn(name = "user_id"))
	private List<User> users;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "food_recipe", joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns =
	@JoinColumn(name = "recipe_id"))
	private List<Recipe> recipes;
	
	public void addUser(User user) {
		if(users == null) {
			users = new ArrayList<>();
		}
		if(!users.contains(user)) {
			users.add(user);
			user.addFood(this);
		}
	}
	
	public void removeUser(User user) {
		if(users != null && users.contains(user)) {
			users.remove(user);
			user.removeFood(this);
		}
	}
	
	public void addRecipe(Recipe recipe) {
		if(recipes == null) {
			recipes = new ArrayList<>();
		}
		if(!recipes.contains(recipe)) {
			recipes.add(recipe);
			recipe.addFood(this);
		}
	}
	
	public void removeRecipe(Recipe recipe) {
		if(recipes != null && recipes.contains(recipe)) {
			recipes.remove(recipe);
			recipe.removeFood(this);
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
	public double getPortionSize () {
		return portionSize;
	}
	public void setPortionSize(double portionSize) {
		this.portionSize = portionSize;
	}
	public String getPortionType() {
		return portionType;
	}
	public void setPortionType(String portionType) {
		this.portionType = portionType;
	}
	public double getCalorie() {
		return calorie;
	}
	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getCholestrol() {
		return cholesterol;
	}
	public void setCholestrol(double cholestrol) {
		this.cholesterol = cholestrol;
	}
	public double getSodium() {
		return sodium;
	}
	public void setSodium(double sodium) {
		this.sodium = sodium;
	}
	public double getCarbohydrate() {
		return carbohydrate;
	}
	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	public double getFiber() {
		return fiber;
	}
	public void setFiber(double fiber) {
		this.fiber = fiber;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorie);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(carbohydrate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cholesterol);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		temp = Double.doubleToLongBits(fat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fiber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(portionSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((portionType == null) ? 0 : portionType.hashCode());
		temp = Double.doubleToLongBits(protein);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sodium);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sugar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
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
		Food other = (Food) obj;
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
		if (Double.doubleToLongBits(portionSize) != Double.doubleToLongBits(other.portionSize))
			return false;
		if (portionType == null) {
			if (other.portionType != null)
				return false;
		} else if (!portionType.equals(other.portionType))
			return false;
		if (Double.doubleToLongBits(calorie) != Double.doubleToLongBits(other.calorie))
			return false;
		if (Double.doubleToLongBits(fat) != Double.doubleToLongBits(other.fat))
			return false;
		if (Double.doubleToLongBits(cholesterol) != Double.doubleToLongBits(other.cholesterol))
			return false;
		if (Double.doubleToLongBits(sodium) != Double.doubleToLongBits(other.sodium))
			return false;
		if (Double.doubleToLongBits(carbohydrate) != Double.doubleToLongBits(other.carbohydrate))
			return false;
		if (Double.doubleToLongBits(fiber) != Double.doubleToLongBits(other.fiber))
			return false;
		if (Double.doubleToLongBits(sugar) != Double.doubleToLongBits(other.fiber))
			return false;
		if (Double.doubleToLongBits(protein) != Double.doubleToLongBits(other.protein))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		return true;
	}
	
	public Food() {
		super();
	}
	
	public Food(int id, String name, String description, double portionSize, String portionType, double calorie, double fat,
			double cholestrol, double sodium, double carbohydrate, double fiber, double sugar, double protein, List<User> users,
			List<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.portionSize = portionSize;
		this.portionType = portionType;
		this.calorie = calorie;
		this.fat = fat;
		this.cholesterol = cholestrol;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
		this.fiber = fiber;
		this.sugar = sugar;
		this.protein = protein;
		this.users = users;
		this.recipes = recipes;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", portionSize=");
		builder.append(portionSize);
		builder.append(", portionType=");
		builder.append(portionType);
		builder.append(", calorie=");
		builder.append(calorie);
		builder.append(", fat=");
		builder.append(fat);
		builder.append(", cholestrol=");
		builder.append(cholesterol);
		builder.append(", sodium=");
		builder.append(sodium);
		builder.append(", carbohydrate=");
		builder.append(carbohydrate);
		builder.append(", fiber=");
		builder.append(fiber);
		builder.append(", sugar=");
		builder.append(sugar);
		builder.append(", protein=");
		builder.append(protein);
		builder.append(", recipes=");
		builder.append(recipes);
		builder.append("]");
		return builder.toString();
	}
}