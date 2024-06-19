import { useEffect, useState } from "react";
import { getPlants } from "../services/plantService";
import { BsFunnel, BsListUl, BsGrid } from "react-icons/bs";
import StockListElement from "../components/ui/StockListElement";

const draftState = {
  searchInput: true,
  filterButton: true,
  addPlantButton: true,
  listButton: true,
  gridButton: true,
};

export default function Stocks() {
  const [data, setData] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);

  const getAllPlants = async (page = 0, size = 10) => {
    try {
      setCurrentPage(page);

      const { data } = await getPlants(page, size);

      setData(data);
    } catch (error) {
      console.log(error);
    }
  };

  // TODO: Implement search plants
  const search = () => {
    console.log("Implement search plants");
  };

  useEffect(() => {
    getAllPlants();
  }, []);

  return (
    <div className="flex flex-col gap-8">
      <h1 className="h-20 text-2xl font-bold py-6">Asortyment roślin</h1>
      <div className="flex justify-between flex-wrap gap-5">
        <div className="flex flex-wrap gap-4">
          <input
            type="search"
            name="search"
            id="searchBar"
            placeholder=" Szukaj..."
            onChange={search}
            className="min-w-[250px] max-w-[400px] h-10 p-2 border rounded-lg"
            disabled={draftState.searchInput}
          />
          <button
            className={`flex items-center gap-3 p-2 border rounded-lg ${
              draftState.filterButton ? "opacity-50" : ""
            }`}
          >
            <BsFunnel />
            Filtry
          </button>
        </div>
        <div className="max-w-[300px] min-h-10 flex flex-wrap gap-6">
          <button
            className={`max-w-[200px] px-4 py-2 rounded-lg bg-primary text-white font-bold ${
              draftState.addPlantButton ? "opacity-50" : ""
            }`}
            disabled={true}
          >
            Dodaj roślinę
          </button>
          <div className="h-10 flex p-1 bg-base-200 rounded-lg">
            <button
              className={`px-3 py-1 rounded-lg bg-base-100 ${
                draftState.listButton ? "opacity-50" : ""
              }`}
            >
              <BsListUl size={24} />
            </button>
            <button
              className={`px-3 py-1 rounded-lg ${
                draftState.gridButton ? "opacity-50" : ""
              }`}
            >
              <BsGrid size={24} />
            </button>
          </div>
        </div>
      </div>
      <div>
        {data && data.content?.length > 0 ? (
          <ul className="flex flex-col gap-3">
            <li className="w-full min-h-14 flex flex-col md:flex-row gap-5 p-4">
              <span className="font-bold min-w-[70px]">ID</span>
              <span className="font-bold min-w-[170px]">Nazwa</span>
              <span className="font-bold min-w-[70px]">Typ</span>
              <span className="font-bold">Opis</span>
            </li>
            {data.content?.map(plant => {
              return <StockListElement key={plant.id} plant={plant} />;
            })}
          </ul>
        ) : (
          <p>Brak roślin w bazie danych</p>
        )}
      </div>
      {data && data.content?.length > 0 && (
        <div className="w-full min-h-10 flex justify-center mb-4">
          {data.totalPages > 1 && (
            <div className="flex gap-1 join text-white font-semibold">
              {currentPage !== 0 ? (
                <button
                  onClick={() => getAllPlants(currentPage - 1)}
                  className="min-w-24 join-item bg-primary p-2 rounded-lg hover:scale-105"
                >
                  Poprzednia
                </button>
              ) : (
                <button
                  disabled={true}
                  className="min-w-24 join-item bg-primary opacity-50 p-2 rounded-lg"
                >
                  Poprzednia
                </button>
              )}
              {currentPage < data.totalPages - 1 ? (
                <button
                  onClick={() => getAllPlants(currentPage + 1)}
                  className="min-w-24 join-item bg-primary p-2 rounded-lg hover:scale-105"
                >
                  Następna
                </button>
              ) : (
                <button
                  disabled={true}
                  className="min-w-24 join-item bg-primary opacity-50 p-2 rounded-lg"
                >
                  Następna
                </button>
              )}
            </div>
          )}
        </div>
      )}
    </div>
  );
}
