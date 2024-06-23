import { Link } from "react-router-dom";
import { Plant } from "../../types";
import { useEffect, useState } from "react";

export default function StockListElement({ plant }: { plant: Plant }) {
  const { id, name, description, type, batches } = plant;
  const [showBatches, setShowBatches] = useState(false);

  const handleShowBatches = async () => {
    if (!showBatches) {
      setShowBatches(true);
    } else {
      setShowBatches(false);
    }
  };

  return (
    <li
      className="w-full min-h-14 flex flex-col p-4 border-2 rounded-lg shadow hover:border-primary"
      onClick={handleShowBatches}
    >
      <div className="flex flex-col lg:flex-row gap-5">
        <span className="font-semibold min-w-16">{id}</span>
        <span className="font-semibold min-w-44">{name}</span>
        <span className="font-semibold min-w-20">{type}</span>
        <span className="font-semibold">{description}</span>
      </div>
      {showBatches && (
        <div className="flex flex-col gap-3">
          <div className="divider"></div>
          <h3 className="font-semibold">Partie ( {batches.length} ):</h3>
          <ul className="flex flex-col gap-2">
            {batches &&
              batches.map(batch => (
                <li
                  key={batch.id}
                  className={`rounded-lg ${
                    batch.orderId === null ? "bg-primary/50 " : "bg-accent/50"
                  }`}
                >
                  <Link to={`/batches/${batch.id}`}>
                    <div className="flex flex-row flex-wrap gap-3 p-4 rounded-lg hover:border-primary border-2">
                      <span>ID: {batch.id}</span>
                      <span>Wymiary: {batch.dimensions}</span>
                      <span>Waga: {batch.weight}</span>
                      {/* <span>Rząd: {batch.rowLocation}</span>
                      <span>Regał: {batch.rackLocation}</span>
                      <span>Półka: {batch.shelfLocation}</span> */}
                      <span>Ilość: {batch.quantity}</span>
                    </div>
                  </Link>
                </li>
              ))}
          </ul>
        </div>
      )}
    </li>
  );
}
