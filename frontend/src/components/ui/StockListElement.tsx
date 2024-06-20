import { Plant } from "../../types";

export default function StockListElement({ plant }: { plant: Plant }) {
  const { id, name, description, type } = plant;

  return (
    <li className="w-full min-h-14 flex flex-col md:flex-row gap-5 p-4 border rounded-lg shadow">
      <span className="font-semibold min-w-16">{id}</span>
      <span className="font-semibold min-w-44">{name}</span>
      <span className="font-semibold min-w-20">{type}</span>
      <span className="font-semibold">{description}</span>
    </li>
  );
}
