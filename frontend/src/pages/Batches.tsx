import { useEffect, useState } from "react";
import { BsFunnel, BsListUl, BsGrid } from "react-icons/bs";
import BatchListElement from "../components/ui/BatchListElement";
import { getBatches } from "../services/batchService";
import { useNavigate } from "react-router-dom";
import { debounce } from "lodash";

const draftState = {
  searchButton: true,
  filterButton: true,
  listButton: true,
  gridButton: true,
};

export default function Batches() {
  const navigate = useNavigate();
  const [unfilteredData, setUnfilteredData] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);
  const [search, setSearch] = useState("");

  const getAllBatches = async (page = 0, size = 10) => {
    try {
      setCurrentPage(page);

      const { data } = await getBatches(page, size);

      setUnfilteredData(data);
    } catch (error) {
      console.log(error);
    }
  };

  const debounceSearch = debounce(searchQuery => {
    setSearch(searchQuery);
  }, 500);

  const handleSearch = async e => {
    debounceSearch(e.target.value);
    console.log(search);
  };

  // TODO: Implement validation before navigating to /batches/create
  // Check if there is at least one delivery to unload
  // Check if there is at least one empty shelf
  const handleAddBatch = () => {
    navigate("/batches/create");
  };

  // For getting all batches
  useEffect(() => {
    getAllBatches();
  }, []);

  return (
    <div className="flex flex-col gap-8">
      <h1 className="h-20 text-2xl font-bold py-6">Partie</h1>
      <div className="flex justify-between flex-wrap gap-5">
        <div className="flex flex-wrap gap-4">
          <input
            type="search"
            name="search"
            id="searchBar"
            placeholder=" Szukaj..."
            disabled={draftState.searchButton}
            onChange={handleSearch}
            className="min-w-[250px] max-w-[400px] h-12 p-2 border rounded-lg"
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
        <div className="max-w-[300px] min-h-12 flex flex-wrap gap-6">
          <button
            onClick={handleAddBatch}
            className={`max-w-[200px] px-4 py-2 btn btn-primary text-white font-bold hover:scale-105`}
          >
            Dodaj partie
          </button>
          <div className="h-12 flex p-1 bg-base-200 rounded-lg">
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
        {unfilteredData && unfilteredData.content?.length > 0 ? (
          <ul className="flex flex-col gap-3">
            <li className="hidden w-full min-h-14 lg:flex flex-row gap-5 p-4 ">
              <span className="font-bold min-w-10 ">ID</span>
              <span className="font-bold min-w-36">Nazwa</span>
              <span className="font-bold min-w-20">Wymiary</span>
              <span className="font-bold min-w-12">Waga</span>
              <span className="font-bold min-w-12">Rząd</span>
              <span className="font-bold min-w-12">Regał</span>
              <span className="font-bold min-w-12">Półka</span>
              <span className="font-bold min-w-16">Ilość</span>
            </li>
            {unfilteredData.content?.map(batch => {
              return <BatchListElement key={batch.id} batch={batch} />;
            })}
          </ul>
        ) : (
          <p>Brak roślin w bazie danych</p>
        )}
      </div>
      {unfilteredData && unfilteredData.content?.length > 0 && (
        <div className="w-full min-h-12 flex justify-center mb-4">
          {unfilteredData.totalPages > 1 && (
            <div className="flex gap-1 join text-white font-semibold">
              {currentPage !== 0 ? (
                <button
                  onClick={() => getAllBatches(currentPage - 1)}
                  className="min-w-24 join-item btn btn-primary text-white p-2 hover:scale-105"
                >
                  Poprzednia
                </button>
              ) : (
                <button
                  disabled={true}
                  className="min-w-24 join-item btn btn-primary text-white opacity-50 p-2"
                >
                  Poprzednia
                </button>
              )}
              {currentPage < unfilteredData.totalPages - 1 ? (
                <button
                  onClick={() => getAllBatches(currentPage + 1)}
                  className="min-w-24 join-item btn btn-primary text-white p-2 hover:scale-105"
                >
                  Następna
                </button>
              ) : (
                <button
                  disabled={true}
                  className="min-w-24 join-item btn btn-primary text-white opacity-50 p-2"
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
