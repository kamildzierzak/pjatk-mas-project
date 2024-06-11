export default function PlantElement({ plant }) {
  return (
    <div className="w-full border p-3 shadow-sm">
      <div>{plant.name}</div>
    </div>
  );
}
