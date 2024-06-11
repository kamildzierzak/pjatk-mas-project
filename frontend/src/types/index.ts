export enum PlantType {
  HERB,
  SHRUB,
  CLIMBER,
  TREE,
  CREEPER,
}

export type Plant = {
  id?: number;
  name: string;
  description: string;
  type: PlantType;
};
