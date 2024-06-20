export enum PlantType {
  HERB,
  SHRUB,
  CLIMBER,
  TREE,
  CREEPER,
}

export type Pageable = {
  page?: number;
  size?: number;
};

export type Plant = {
  id?: number;
  name: string;
  description: string;
  type: PlantType;
};

export type Batch = {
  id?: number;
  plantName: string;
  dimensions: string;
  weight: string;
  rowLocation: string;
  rackLocation: string;
  shelfLocation: string;
  plantsQuantity: number;
  orderId?: number;
};
