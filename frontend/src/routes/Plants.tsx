import { useEffect, useState } from "react";
import PlantElement from "../components/ui/PlantElement";
import { getPlants } from "../api/plantService";
import { PageablePlant } from "../types";

export default function Plants() {
  const [data, setData] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);

  const getAllPlants = async (page = 0, size = 15) => {
    try {
      setCurrentPage(page);
      const { data } = await getPlants(page, size);
      setData(data);
      console.log(data);
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
    <div className="flex flex-col gap-5">
      <div className="flex flex-col flex-wrap gap-3">
        <input
          type="text"
          placeholder="Search plants"
          className="w-full p-2 border rounded shadow-md"
          onChange={search}
        />
        <button className="bg-primary border min-w-32 p-2 hover:scale-110 hover:bg-secondary transition-all">
          Add new
        </button>
      </div>
      <div className="flex flex-wrap gap-5 mt-5 px-5">
        <span className="w-1/5 font-bold">Name</span>
        <span className="w-1/5 font-bold">Type</span>
        <span className="font-bold">Description</span>
      </div>
      {data?.content?.length > 0 ? (
        <ul className="flex flex-col gap-3">
          {data.content.map(plant => {
            return <PlantElement key={plant.id} plant={plant} />;
          })}
        </ul>
      ) : (
        <div className="text-center">No plants found</div>
      )}
      {data?.totalPages > 1 && (
        <div className="join self-center mt-5">
          {[...Array(data.totalPages).keys()].map(page => {
            return (
              <button
                onClick={() => getAllPlants(page)}
                key={page}
                className={
                  "join-item btn" + (currentPage === page ? " btn-active" : "")
                }
              >
                {page + 1}
              </button>
            );
          })}
        </div>
      )}
    </div>
  );
}
