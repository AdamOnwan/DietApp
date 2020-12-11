import { Food } from './food';
import { Address } from './address';
import { Diet } from './diet';
export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  phone: string;
  enabled: boolean;
  role: string;
  imageUrl: string;
  height: number;
  weight: number;
  description: string;
  address: Address;
  diet: Diet;
  food: Food;

  constructor(id?: number, firstName?: string, lastName?: string, email?: string, password?: string, phone?: string,
              enabled?: boolean, role?: string, imageUrl?: string, height?: number, weight?: number,
              description?: string, address?: Address, diet?: Diet, food?: Food) {
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
    this.diet = diet;
    this.food = food;
  }
}
