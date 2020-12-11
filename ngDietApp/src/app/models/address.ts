import { User } from 'src/app/models/user';
export class Address {
  id: number;
  address: string;
  address2: string;
  city: string;
  state: string;
  postalCode: string;
  country: string;
  user: User;

  constructor(id: number, address: string, address2: string, city: string, state: string,
              postalCode: string, country: string, user: User) {
    this.id = id;
    this.address = address;
    this.address2 = address2;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
    this.user = user;
  }
}
