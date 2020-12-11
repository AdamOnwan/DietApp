export class Recipe {
  id: number;
  name: string;
  description: string;
  cookTime: number;
  prepTime: number;
  imageUrl: string;
  imageUrl2: string;
  imageUrl3: string;

  constructor(id: number, name: string, description: string, cookTime: number, prepTime: number,
              imageUrl: string, imageUrl2: string, imageUrl3: string) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.cookTime = cookTime;
    this.prepTime = prepTime;
    this.imageUrl = imageUrl;
    this.imageUrl2 = imageUrl2;
    this.imageUrl3 = imageUrl3;
  }
}
