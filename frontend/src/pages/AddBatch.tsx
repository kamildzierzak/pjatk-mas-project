import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getOrders, moveBatchToShelf } from "../services/orderServices";
import { getRows } from "../services/rowServices";
import { toast } from "react-toastify";

export default function AddBatch() {
  const navigate = useNavigate();
  const [deliveriesData, setDeliveriesData] = useState([]);
  const [rowsData, setRowsData] = useState([]);
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
  const [rackOptions, setRackOptions] = useState([]);
  const [shelfOptions, setShelfOptions] = useState([]);
  const [selectedBatchQuantityMaximum, setSelectedBatchQuantityMaximum] =
    useState(0);

  const getAllData = async () => {
    try {
      const { data: orders } = await getOrders();

      const filteredOrders = orders.filter(order => order.content.length > 0);
      const { data: rows } = await getRows();

      setDeliveriesData(filteredOrders);
      setRowsData(rows);
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
    const selectedDelivery = deliveriesData.find(
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

    setFormState({
      ...formState,
      selectedBatch: selectedBatchId,
      selectedPlantName: selectedBatch ? selectedBatch.plantName : "",
      selectedBatchQuantity: selectedBatch ? selectedBatch.quantity : 0,
    });
    setSelectedBatchQuantityMaximum(selectedBatch ? selectedBatch.quantity : 0);
  };

  const handleSelectRow = e => {
    const selectedRowId = e.target.value;
    const selectedRow = rowsData.find(row => row.id == selectedRowId);

    setFormState({
      ...formState,
      selectedRow: selectedRowId,
      selectedRack: "Wybierz",
      selectedShelf: "Wybierz",
    });

    if (!selectedRow) return;
    const emptyRacks = selectedRow.racks.filter(rack => {
      return rack.shelves.some(shelf => {
        return (
          shelf.batchId === null ||
          shelf.batchId === undefined ||
          shelf.batchId === ""
        );
      });
    });

    setRackOptions(selectedRow ? emptyRacks || [] : []);
  };

  const handleSelectRack = e => {
    const selectedRackId = e.target.value;
    const selectedRack = rackOptions.find(rack => rack.id == selectedRackId);

    setFormState({
      ...formState,
      selectedRack: selectedRackId,
      selectedShelf: "Wybierz",
    });

    // Filter empty shelves -> Move it to the backend later
    if (!selectedRack) return;
    const emptyShelves = selectedRack.shelves.filter(shelf => {
      return (
        shelf.batchId === null ||
        shelf.batchId === undefined ||
        shelf.batchId === ""
      );
    });

    setShelfOptions(selectedRack ? emptyShelves || [] : []);
  };

  const handleSelectShelf = e => {
    const selectedShelfId = e.target.value;

    setFormState({
      ...formState,
      selectedShelf: selectedShelfId,
    });
  };

  const handleFormSubmit = async e => {
    e.preventDefault();

    try {
      const {
        selectedDelivery,
        selectedBatch,
        selectedRow,
        selectedRack,
        selectedShelf,
        selectedPricePerItem,
        selectedBatchQuantity,
      } = formState;

      // Dumb validation
      if (
        selectedDelivery === "Wybierz" ||
        selectedBatch === "Wybierz" ||
        selectedRow === "Wybierz" ||
        selectedRack === "Wybierz" ||
        selectedShelf === "Wybierz"
      ) {
        toast(
          "Pola dostawy, parti, rzędu, regału oraz półki muszą być wybrane.",
          { type: "error" }
        );
        return;
      }

      if (selectedPricePerItem == 0 || selectedPricePerItem < 0) {
        toast("Cena nie może być równa lub mniejsza niż 0", { type: "error" });
        return;
      }

      if (
        selectedBatchQuantity == 0 ||
        selectedBatchQuantity < 0 ||
        selectedBatchQuantity > selectedBatchQuantityMaximum
      ) {
        toast(
          "Ilość musi być większa niż 0 oraz mniejsza niż ilość maksymalna na partię danej rośliny.",
          { type: "error" }
        );
        return;
      }

      const response = await moveBatchToShelf(
        Number(selectedDelivery),
        Number(selectedBatch),
        Number(selectedShelf),
        Number(selectedPricePerItem),
        Number(selectedBatchQuantity)
      );

      if (response.status === 200) {
        navigate("/batches");
        toast("Partia dodana", { type: "success" });
      }
    } catch (error) {
      toast("Wystąpił błąd podczas dodawania partii", { type: "error" });
      console.log(error);
    }

    // console.log(formState);
  };

  const handleCancel = () => {
    navigate("/batches");
  };

  useEffect(() => {
    getAllData();
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
            {deliveriesData.map(delivery => {
              return (
                <option key={delivery.id} value={delivery.id}>
                  {delivery.id} [
                  {delivery.content.map(batch => batch.plantName + ", ")}]
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
                  {batch.id} {batch.plantName}
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
            onChange={handleSelectRow}
            name="selectedRow"
            value={formState.selectedRow}
            disabled={formState.selectedBatch === "Wybierz"}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
            {rowsData.map(row => {
              return (
                <option key={row.id} value={row.id}>
                  {row.name}
                </option>
              );
            })}
          </select>
        </div>
        {/* Rack select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Regał
          </label>
          <select
            onChange={handleSelectRack}
            name="selectedRack"
            value={formState.selectedRack}
            disabled={formState.selectedRow === "Wybierz"}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
            {rackOptions.map(rack => {
              return (
                <option key={rack.id} value={rack.id}>
                  {rack.number}
                </option>
              );
            })}
          </select>
        </div>
        {/* Shelf select */}
        <div className="flex flex-col gap-2">
          <label htmlFor="" className="font-bold">
            Półka
          </label>
          <select
            onChange={handleSelectShelf}
            name="selectedShelf"
            value={formState.selectedShelf}
            disabled={formState.selectedRack === "Wybierz"}
            className="h-10 border rounded-lg px-4 py-2"
          >
            <option value="Wybierz">Wybierz</option>
            {shelfOptions.map(shelf => {
              return (
                <option key={shelf.id} value={shelf.id}>
                  {shelf.number}
                </option>
              );
            })}
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
            className="btn btn-accent text-white hover:scale-110"
          >
            Anuluj
          </button>
          <button
            onClick={handleFormSubmit}
            type="submit"
            className="btn btn-primary text-white hover:scale-110"
          >
            Dodaj
          </button>
        </div>
      </form>
    </div>
  );
}
