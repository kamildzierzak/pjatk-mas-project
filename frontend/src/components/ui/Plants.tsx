import { useEffect, useState } from "react";
import PlantElement from "./PlantElement";
import { getPlants } from "../../api/plantService";

export default function Plants() {
  const [data, setData] = useState([]);

  const getAllPlants = async () => {
    try {
      const { data } = await getPlants();
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
      <div className="flex flex-wrap gap-5 px-5">
        <span className="w-1/5">Name</span>
        <span className="w-1/5">Type</span>
        <span>Description</span>
      </div>
      {data?.length > 0 ? (
        <ul className="flex flex-col gap-3">
          {data.map(plant => {
            return <PlantElement key={plant.id} plant={plant} />;
          })}
        </ul>
      ) : (
        <div className="text-center">No plants found</div>
      )}
    </div>
  );
}
