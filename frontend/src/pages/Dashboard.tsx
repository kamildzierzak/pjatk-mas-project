export default function Dashboard() {
  return (
    <div className="grid grid-cols-4 gap-5">
      {/* 4 grid components */}
      <div className="bg-blue-500 col-span-2 p-5">Orders</div>
      <div className="bg-blue-500 col-span-2 p-5">Stock</div>
      <div className="bg-blue-500 col-span-2 p-5">People</div>
      <div className="bg-blue-500 col-span-2 p-5">Deliveries</div>
    </div>
  );
}
