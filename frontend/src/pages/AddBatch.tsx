import { useState } from "react";
import { useNavigate } from "react-router-dom";

const mock = {
  deliveries: [
    {
      id: 1,
      name: "Dostawa 1",
      batches: [
        { id: 1, name: "Partia 1" },
        { id: 2, name: "Partia 2" },
      ],
    },
    {
      id: 2,
      name: "Dostawa 2",
      batches: [
        { id: 3, name: "Partia 3" },
        { id: 4, name: "Partia 4" },
      ],
    },
    {
      id: 3,
      name: "Dostawa 3",
      batches: [
        { id: 5, name: "Partia 5" },
        { id: 6, name: "Partia 6" },
      ],
    },
  ],
};

export default function AddBatch() {
  const navigate = useNavigate();
  const [selectedDelivery, setSelectedDelivery] = useState("");
  const [selectedBatch, setSelectedBatch] = useState("");
  const [selectedRow, setSelectedRow] = useState("");
  const [selectedRack, setSelectedRack] = useState("");
  const [selectedShelf, setSelectedShelf] = useState("");
  const [selectedPlantName, setSelectedPlantName] = useState("");
  const [selectedPricePerItem, setSelectedPricePerItem] = useState(0);
  const [selectedPlantsQuantity, setSelectedPlantsQuantity] = useState(0);

  const handleFormSubmit = e => {
    e.preventDefault();
    console.log(e.target.elements);
  };

  const handleCancel = () => {
    navigate("/batches");
  };

  const handleAdd = () => {};

  return (
    <div className="flex flex-col gap-8">
      <h1 className="h-20 text-2xl font-bold py-6 ">Dodaj partie</h1>
      <form
        onSubmit={handleFormSubmit}
        className="max-w-screen-md flex flex-col gap-8"
      >
        {/* Delivery select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Dostawa
          </label>
          <select
            onChange={e => setSelectedDelivery(e.target.value)}
            name="delivery"
            id="delivery"
            value={selectedDelivery}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
            {mock.deliveries.map(delivery => {
              return (
                <option key={delivery.id} value={delivery.name}>
                  {delivery.name}
                </option>
              );
            })}
          </select>
        </div>
        {/* Batch select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Partia
          </label>
          <select
            onChange={e => console.log(e.target.value)}
            name="batch"
            id="batch"
            value={selectedBatch}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
          </select>
          {selectedBatch}
        </div>
        {/* Row select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Rząd
          </label>
          <select
            onChange={e => console.log(e.target.value)}
            name="row"
            id="row"
            value={selectedRow}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
          </select>
          {selectedRow}
        </div>
        {/* Rack select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Regał
          </label>
          <select
            onChange={e => console.log(e.target.value)}
            name="rack"
            id="rack"
            value={selectedRack}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
          </select>
          {selectedRack}
        </div>
        {/* Shelf select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Półka
          </label>
          <select
            onChange={e => console.log(e.target.value)}
            name="shelf"
            id="shelf"
            value={selectedShelf}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
          </select>
          {selectedShelf}
        </div>

        <div className="flex flex-col gap-2">
          <span className="font-bold">Szczegóły</span>
          <div className="flex flex-col md:flex-row gap-2">
            <div className="md:w-1/3 flex flex-col gap-2">
              <label htmlFor="" className="font-semibold">
                Roślina
              </label>
              <input
                type="text"
                value={selectedPlantName}
                disabled={true}
                className="h-10 px-4 py-2 rounded-lg border"
              />
            </div>
            <div className="md:w-1/3 flex flex-col gap-2">
              <label htmlFor="" className="font-semibold">
                Cena za sztukę (zł)
              </label>
              <input
                onChange={e => setSelectedPricePerItem(e.target.value)}
                value={selectedPricePerItem}
                type="text"
                className="h-10 px-4 py-2 rounded-lg border"
              />
            </div>
            <div className="md:w-1/3 flex flex-col gap-2">
              <label htmlFor="" className="font-semibold">
                Ilość
              </label>
              <input
                onChange={e => setSelectedPlantsQuantity(e.target.value)}
                value={selectedPlantsQuantity}
                type="text"
                className="h-10 px-4 py-2 rounded-lg border"
              />
            </div>
          </div>
        </div>

        <div className="w-full flex justify-between">
          <button
            onClick={handleCancel}
            className="btn bg-accent text-white hover:scale-105"
          >
            Anuluj
          </button>
          <button
            onClick={handleAdd}
            className="btn bg-primary text-white hover:scale-105"
          >
            Dodaj
          </button>
        </div>
      </form>
    </div>
  );
}
