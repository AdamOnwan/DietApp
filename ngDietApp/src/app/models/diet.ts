export class Diet {
  id: number;
  name: string;
  purpose: string;
  description: string;

  constructor(id: number, name: string, purpose: string, description: string) {
    this.id = id;
    this.name = name;
    this.purpose = purpose;
    this.description = description;
  }
}
