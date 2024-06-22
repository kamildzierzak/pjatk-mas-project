import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getOrders } from "../services/orderServices";

export default function AddBatch() {
  const navigate = useNavigate();
  const [data, setData] = useState([]);
  const [formState, setFormState] = useState({
    selectedDelivery: "Wybierz",
    selectedBatch: "Wybierz",
    selectedRow: "Wybierz",
    selectedRack: "Wybierz",
    selectedShelf: "Wybierz",
    selectedPlantName: "",
    selectedPricePerItem: 0,
    selectedBatchQuantity: 0,
  });
  const [batchOptions, setBatchOptions] = useState([]);
  const [rowOptions, setRowOptions] = useState([]);
  const [rackOptions, setRackOptions] = useState([]);
  const [shelfOptions, setShelfOptions] = useState([]);

  const getAllOrders = async () => {
    try {
      const { data } = await getOrders();
      setData(data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleSelect = e => {
    const { name, value } = e.target;
    setFormState({ ...formState, [name]: value });
  };

  const handleSelectDelivery = e => {
    const selectedDeliveryId = e.target.value;
    const selectedDelivery = data.find(
      delivery => delivery.id == selectedDeliveryId
    );
    setFormState({
      ...formState,
      selectedDelivery: selectedDeliveryId,
      selectedBatch: "Wybierz",
      selectedPlantName: "",
      selectedBatchQuantity: 0,
    });
    setBatchOptions(selectedDelivery ? selectedDelivery.content || [] : []);
  };

  const handleSelectBatch = e => {
    const selectedBatchId = e.target.value;
    const selectedBatch = batchOptions.find(
      batch => batch.id == selectedBatchId
    );
    console.log(selectedBatch);

    setFormState({
      ...formState,
      selectedBatch: selectedBatchId,
      selectedPlantName: selectedBatch ? selectedBatch.plantName : "",
      selectedBatchQuantity: selectedBatch ? selectedBatch.quantity : 0,
    });
  };

  const handleFormSubmit = e => {
    e.preventDefault();
  };

  const handleCancel = () => {
    navigate("/batches");
  };

  const handleAdd = () => {};

  useEffect(() => {
    getAllOrders();
  }, []);

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
            onChange={handleSelectDelivery}
            name="selectedDelivery"
            value={formState.selectedDelivery}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
            {data.map(delivery => {
              return (
                <option key={delivery.id} value={delivery.id}>
                  {delivery.id}
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
            onChange={handleSelectBatch}
            name="selectedBatch"
            value={formState.selectedBatch}
            disabled={formState.selectedDelivery === "Wybierz"}
            className={`h-10 border rounded-lg px-4 py-2`}
          >
            <option value="Wybierz">Wybierz</option>
            {batchOptions.map(batch => {
              return (
                <option key={batch.id} value={batch.id}>
                  {batch.id}
                </option>
              );
            })}
          </select>
        </div>
        {/* Row select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Rząd
          </label>
          <select
            onChange={handleSelect}
            name="selectedRow"
            value={formState.selectedRow}
            disabled={formState.selectedBatch === "Wybierz"}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
          </select>
        </div>
        {/* Rack select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Regał
          </label>
          <select
            onChange={e => console.log(e.target.value)}
            name="selectedRack"
            value={formState.selectedRack}
            disabled={formState.selectedRow === "Wybierz"}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
          </select>
        </div>
        {/* Shelf select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Półka
          </label>
          <select
            onChange={e => console.log(e.target.value)}
            name="selectedShelf"
            value={formState.selectedShelf}
            disabled={formState.selectedRack === "Wybierz"}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
          </select>
        </div>
        {/* Details */}
        <div className="flex flex-col gap-2">
          <span className="font-bold">Szczegóły</span>
          <div className="flex flex-col md:flex-row gap-2">
            <div className="md:w-1/3 flex flex-col gap-2">
              <label htmlFor="" className="font-semibold">
                Roślina
              </label>
              <input
                type="text"
                name="selectedPlantName"
                value={formState.selectedPlantName}
                disabled={true}
                className="h-10 px-4 py-2 rounded-lg border"
              />
            </div>
            <div className="md:w-1/3 flex flex-col gap-2">
              <label htmlFor="" className="font-semibold">
                Cena za sztukę (zł)
              </label>
              <input
                onChange={handleSelect}
                name="selectedPricePerItem"
                value={formState.selectedPricePerItem}
                type="text"
                disabled={formState.selectedShelf === "Wybierz"}
                className="h-10 px-4 py-2 rounded-lg border"
              />
            </div>
            <div className="md:w-1/3 flex flex-col gap-2">
              <label htmlFor="" className="font-semibold">
                Ilość
              </label>
              <input
                onChange={handleSelect}
                name="selectedBatchQuantity"
                value={formState.selectedBatchQuantity}
                type="text"
                disabled={formState.selectedShelf === "Wybierz"}
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
