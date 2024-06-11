import PlantElement from "./PlantElement";

export default function Plants({ data }) {
  // TODO: Implement search plants
  const search = () => {
    console.log("Implement search plants");
  };

  return (
    <div className="flex flex-col gap-5">
      <div>
        <input
          type="text"
          placeholder="Search plants"
          className="w-full p-2 border rounded shadow-md"
          onChange={search}
        />
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
    </div>
  );
}
