export class Food {
  id: number;
  name: string;
  description: string;
  portionSize: number;
  portionType: string;
  calorie: number;
  fat: number;
  cholestrol: number;
  sodium: number;
  carbohydrate: number;
  fiber: number;
  sugar: number;
  protein: number;

  constructor(id?: number, name?: string, description?: string, portionSize?: number, portionType?: string, calorie?: number,
              fat?: number, cholestrol?: number, sodium?: number, carbohydrate?: number, fiber?: number, sugar?: number, protein?: number) {
this.id = id;
this.name = name;
this.description = description;
this.portionSize = portionSize;
this.portionType = portionType;
this.calorie = calorie;
this.fat = fat;
this.cholestrol = cholestrol;
this.sodium = sodium;
this.carbohydrate = carbohydrate;
this.fiber = fiber;
this.sugar = sugar;
this.protein = protein;
  }
}
