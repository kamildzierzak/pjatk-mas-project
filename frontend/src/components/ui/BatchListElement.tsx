import { Batch } from "../../types";
import { Link } from "react-router-dom";

export default function BatchListElement({ batch }: { batch: Batch }) {
  const {
    id,
    plantName,
    dimensions,
    weight,
    rowLocation,
    rackLocation,
    shelfLocation,
    quantity,
  } = batch;

  return (
    <li>
      <Link to={`/batches/${batch.id}`}>
        <div className="w-full min-h-14 flex flex-col lg:flex-row gap-5 p-4 border rounded-lg shadow ">
          <span className="flex flex-row gap-3 font-semibold min-w-10">
            <span className="font-bold lg:hidden w-[75px]">ID: </span>
            <span>{id}</span>
          </span>
          <span className="flex flex-row gap-3 font-semibold min-w-36">
            <span className="font-bold lg:hidden w-[75px]">Nazwa: </span>
            <span>{plantName}</span>
          </span>
          <span className="flex flex-row gap-3 font-semibold min-w-20">
            <span className="font-bold lg:hidden w-[75px]">Wymiary: </span>
            <span>{dimensions}</span>
          </span>
          <span className="flex flex-row gap-3 font-semibold min-w-12">
            <span className="font-bold lg:hidden w-[75px]">Waga: </span>
            <span>{weight}</span>
          </span>
          <span className="flex flex-row gap-3 font-semibold min-w-12">
            <span className="font-bold lg:hidden w-[75px]">Rząd: </span>
            <span>{rowLocation}</span>
          </span>
          <span className="flex flex-row gap-3 font-semibold min-w-12">
            <span className="font-bold lg:hidden w-[75px]">Regał: </span>
            <span>{rackLocation}</span>
          </span>
          <span className="flex flex-row gap-3 font-semibold min-w-12">
            <span className="font-bold lg:hidden w-[75px]">Półka: </span>
            <span>{shelfLocation}</span>
          </span>
          <span className="flex flex-row gap-3 font-semibold min-w-16">
            <span className="font-bold lg:hidden w-[75px]">Ilość: </span>
            <span>{quantity}</span>
          </span>
        </div>
      </Link>
    </li>
  );
}
