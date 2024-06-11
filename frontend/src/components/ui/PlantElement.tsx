import { Plant } from "../../types";

export default function PlantElement({ plant }: { plant: Plant }) {
  const { name, description, type } = plant;

  return (
    <div className="w-full min-h-16 flex flex-wrap items-center gap-3 p-5 border shadow-sm">
      <span className="w-1/5">{name}</span>
      <span className="w-1/5">{type}</span>
      <span>{description}</span>
    </div>
  );
}
