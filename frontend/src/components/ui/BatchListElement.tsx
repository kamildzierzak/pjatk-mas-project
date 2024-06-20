import { Batch } from "../../types";

export default function BatchListElement({ batch }: { batch: Batch }) {
  const {
    id,
    plantName,
    dimensions,
    weight,
    rowLocation,
    rackLocation,
    shelfLocation,
    plantsQuantity,
  } = batch;

  return (
    <li className="w-full min-h-14 flex flex-col lg:flex-row gap-5 p-4 border rounded-lg shadow text-center">
      <span className="font-semibold min-w-16">{id}</span>
      <span className="font-semibold min-w-36">{plantName}</span>
      <span className="font-semibold min-w-20">{dimensions}</span>
      <span className="font-semibold min-w-12">{weight}</span>
      <span className="font-semibold min-w-12">{rowLocation}</span>
      <span className="font-semibold min-w-12">{rackLocation}</span>
      <span className="font-semibold min-w-12">{shelfLocation}</span>
      <span className="font-semibold min-w-16">{plantsQuantity}</span>
    </li>
  );
}
